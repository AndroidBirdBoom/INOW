package com.kobe.ubersplash.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kobe.ubersplash.R;
import com.kobe.ubersplash.activity.LeftMenu;
import com.kobe.ubersplash.adapter.DragAdapter;
import com.kobe.ubersplash.common.DividerGridItemDecoration;
import com.kobe.ubersplash.helper.MyItemTouchCallback;
import com.kobe.ubersplash.helper.OnRecyclerItemClickListener;
import com.kobe.ubersplash.utils.ACache;
import com.kobe.ubersplash.utils.Item;
import com.kobe.ubersplash.utils.VibratorUtil;


import java.util.ArrayList;
import java.util.List;

public class FragmentImpro extends Fragment implements MyItemTouchCallback.OnDragListener {
    private List<Item> results = new ArrayList<Item>();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        results.clear();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ////////////////////////////////////////////////////////
        /////////初始化数据，如果缓存中有就使用缓存中的
        ArrayList<Item> items = (ArrayList<Item>) ACache.get(getActivity()).getAsObject("items");
        if (items != null)
            results.addAll(items);
        else {
            for (int i = 0; i < 1; i++) {
                results.add(new Item(i * 16 + 0, "学校动态", R.mipmap.university));
                results.add(new Item(i * 16 + 1, "学生会", R.mipmap.students));
                results.add(new Item(i * 16 + 2, "社团", R.mipmap.queue));
                results.add(new Item(i * 16 + 3, "学术报告", R.mipmap.schooldirector));
                results.add(new Item(i * 16 + 4, "最新新闻", R.mipmap.news));
                results.add(new Item(i * 16 + 5, "比赛活动", R.mipmap.leaderboard));
                results.add(new Item(i * 16 + 6, "运动会", R.mipmap.exercise));
                results.add(new Item(i * 16 + 7, "科技", R.mipmap.system));
                results.add(new Item(i * 16 + 8, "娱乐", R.mipmap.musical));
                results.add(new Item(i * 16 + 9, "公交", R.mipmap.bus));
                results.add(new Item(i * 16 + 10, "饮食", R.mipmap.porridge));
                results.add(new Item(i * 16 + 11, "健康", R.mipmap.clinic));
                results.add(new Item(i * 16 + 12, "地图", R.mipmap.marker));
                results.add(new Item(i * 16 + 13, "学校美照", R.mipmap.compact));
                results.add(new Item(i * 16 + 14, "热线电话", R.mipmap.phone));
                results.add(new Item(i * 16 + 15, "热线电话", R.mipmap.phone));
            }
        }
        results.remove(results.size() - 1);
        results.add(new Item(results.size(), "更多", R.mipmap.takeout_ic_more));
        ////////////////////////////////////////////////////////
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new RecyclerView(container.getContext());
    }

    private RecyclerView recyclerView;
    private ItemTouchHelper itemTouchHelper;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DragAdapter adapter = new DragAdapter(R.layout.item_drag, results);
        recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        //添加分割线
        recyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity()));

        itemTouchHelper = new ItemTouchHelper(new MyItemTouchCallback(adapter).setOnDragListener(this));
        itemTouchHelper.attachToRecyclerView(recyclerView);

        recyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(recyclerView) {
            @Override
            public void onLongClick(RecyclerView.ViewHolder vh) {
                if (vh.getLayoutPosition() != results.size() - 1) {
                    itemTouchHelper.startDrag(vh);
                    VibratorUtil.Vibrate(getActivity(), 70);   //震动70ms
                }
            }

            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                if (LeftMenu.getViewPager() != null) {
                    LeftMenu.getViewPager().setCurrentItem(1);
                }
            }
        });
    }

    @Override
    public void onFinishDrag() {
        //存入缓存
        ACache.get(getActivity()).put("items", (ArrayList<Item>) results);
    }

}






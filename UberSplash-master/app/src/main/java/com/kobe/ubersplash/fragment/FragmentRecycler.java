package com.kobe.ubersplash.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kobe.ubersplash.R;
import com.kobe.ubersplash.adapter.FragmentRecyclerAdapter;
import com.kobe.ubersplash.utils.OkHttpUtils;
import com.kobe.ubersplash.utils.TeanBeen;
import com.kobe.ubersplash.utils.URLs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2017/2/8.
 */

public class FragmentRecycler extends Fragment {

    private RecyclerView recyclerView;
    private FragmentRecyclerAdapter adapter;
    private List<Integer> images;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recycler_list, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    String url = URLs.grilsURL;

    public void initData() {
        if (images == null) {
            images = new ArrayList<>();
        }
        images.add(R.mipmap.picature_1);
        images.add(R.mipmap.picature_2);
        images.add(R.mipmap.picature_3);
        images.add(R.mipmap.picature_4);
        images.add(R.mipmap.picature_5);
        images.add(R.mipmap.picature_6);
        images.add(R.mipmap.picature_7);
        images.add(R.mipmap.picature_8);
        images.add(R.mipmap.picature_9);
        images.add(R.mipmap.picature_10);
        images.add(R.mipmap.picature_11);
        images.add(R.mipmap.picature_12);
        images.add(R.mipmap.picature_13);
        images.add(R.mipmap.picature_14);
        images.add(R.mipmap.picature_15);
        images.add(R.mipmap.picature_16);
        images.add(R.mipmap.picature_17);
        images.add(R.mipmap.picature_18);
        images.add(R.mipmap.picature_19);
        images.add(R.mipmap.picature_20);
        images.add(R.mipmap.picature_21);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        /*OkHttpUtils.getInstance().getBeanOfOk2(getActivity(), url, TeanBeen.class, new OkHttpUtils.CallBack2<TeanBeen>() {
            @Override
            public void getData(TeanBeen teanBeen) {
                if (teanBeen != null) {
                    initAdapter(teanBeen);
                }
            }
        });*/
        initAdapter(images);
    }

    public void initAdapter(List<Integer> images) {
        adapter = new FragmentRecyclerAdapter(getContext(), images);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


}

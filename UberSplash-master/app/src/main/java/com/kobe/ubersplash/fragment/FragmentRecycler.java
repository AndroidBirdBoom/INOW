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

import java.util.List;

/**
 * Created by Jack on 2017/2/8.
 */

public class FragmentRecycler extends Fragment {

    private RecyclerView recyclerView;
    private FragmentRecyclerAdapter adapter;

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
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        OkHttpUtils.getInstance().getBeanOfOk(getActivity(), url, TeanBeen.class, new OkHttpUtils.CallBack<TeanBeen>() {
            @Override
            public void getData(TeanBeen teanBeen) {
                if (teanBeen != null) {
                    adapter = new FragmentRecyclerAdapter(getContext(), teanBeen.getGirls());
                    recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }


}

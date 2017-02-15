package com.kobe.ubersplash.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kobe.ubersplash.Dialog.UpdateDialog;
import com.kobe.ubersplash.R;
import com.kobe.ubersplash.adapter.FragmentRecyclerAdapter;
import com.kobe.ubersplash.adapter.OrganizationRecyclerAdapter;
import com.kobe.ubersplash.utils.Article;
import com.kobe.ubersplash.utils.MyApplication;
import com.kobe.ubersplash.utils.OkHttpUtils;
import com.kobe.ubersplash.utils.OrganizationArticles;
import com.kobe.ubersplash.utils.OrganizationMessages;
import com.kobe.ubersplash.utils.TeanBeen;
import com.kobe.ubersplash.utils.URLs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2017/2/8.
 */

public class FragmentEasy extends Fragment {

    private RecyclerView organizationRecycler;
    //private List<TeanBeen.PeopleBeen> girlsList;
    //private List<Article> articleList;
    private List<OrganizationArticles.OrArticle> orArticles;
    private ProgressDialog dialog;
    private OrganizationRecyclerAdapter organizationRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.organization_recycler, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    public void initView(View view) {
        //girlsList = new ArrayList<>();
        orArticles = new ArrayList<>();
        organizationRecycler = (RecyclerView) view.findViewById(R.id.recycler_organization);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        organizationRecycler.setLayoutManager(layoutManager);
    }

    public void initData() {

        /*OkHttpUtils.getInstance().getBeanOfOk(getActivity(), URLs.grilsURL, TeanBeen.class, new OkHttpUtils.CallBack<TeanBeen>() {
            @Override
            public void getData(TeanBeen teanBeen) {
                if (teanBeen != null) {
                    girlsList = teanBeen.getGirls();
                    initAdapter();
                }
            }
        });*/

        showDialog();
        OkHttpUtils.getInstance().getBeanOfOk(getActivity(), URLs.sdutURL2, OrganizationArticles.OrArticle.class, new OkHttpUtils.CallBack<OrganizationArticles.OrArticle>() {
            @Override
            public void getData(List<OrganizationArticles.OrArticle> t) {
                closeDialog();
                if (t != null) {
                    orArticles = t;
                    initAdapter();
                }
            }
        });
    }

    public void initAdapter() {
        organizationRecyclerAdapter = new OrganizationRecyclerAdapter(getContext(), orArticles);
        organizationRecycler.setAdapter(organizationRecyclerAdapter);
        organizationRecyclerAdapter.notifyDataSetChanged();
    }

    public void showDialog() {
        if (dialog == null) {
            dialog = new ProgressDialog(getContext());
            dialog.setMessage("正在加载...");
            dialog.setCanceledOnTouchOutside(false);
        }
        dialog.show();
    }

    public void closeDialog() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }
}

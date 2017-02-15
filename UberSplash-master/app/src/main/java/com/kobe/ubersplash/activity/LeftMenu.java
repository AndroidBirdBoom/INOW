package com.kobe.ubersplash.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kobe.ubersplash.R;
import com.kobe.ubersplash.fragment.FragmentApdater;
import com.kobe.ubersplash.fragment.FragmentEasy;
import com.kobe.ubersplash.fragment.FragmentImpro;
import com.kobe.ubersplash.fragment.FragmentRecycler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jack on 2017/2/7.
 */

public class LeftMenu extends AppCompatActivity {

    private TextView userName, gxName;
    private ListView userList;
    private FragmentEasy fragmentEasy;
    private FragmentRecycler fragmentRecycler;
    private FragmentImpro fragmentImpro;

    private TabLayout tabLayout;
    private Toolbar toolbar;
    private static ViewPager viewPager;
    private FragmentApdater fragmentApdater;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        initView();
        initData();
    }

    public void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiprefresh_layout);
    }

    public void initData() {
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        List<String> titleList = new ArrayList<>();
        titleList.add("简单");
        titleList.add("瀑布流");
        titleList.add("优化");
        if (fragmentEasy == null) {
            fragmentEasy = new FragmentEasy();
        }
        if (fragmentRecycler == null) {
            fragmentRecycler = new FragmentRecycler();
        }
        if (fragmentImpro == null) {
            fragmentImpro = new FragmentImpro();
        }
        tabLayout.addTab(tabLayout.newTab().setTag(titleList.get(0)));
        tabLayout.addTab(tabLayout.newTab().setTag(titleList.get(1)));
        tabLayout.addTab(tabLayout.newTab().setTag(titleList.get(2)));

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(fragmentRecycler);
        fragments.add(fragmentEasy);
        fragments.add(fragmentImpro);

        fragmentApdater = new FragmentApdater(getSupportFragmentManager(), titleList, fragments);
        viewPager.setAdapter(fragmentApdater);
        //为tabLayout设置ViewPager
        tabLayout.setupWithViewPager(viewPager);
        //该方法支持点击
        tabLayout.setTabsFromPagerAdapter(fragmentApdater);
        viewPager.setCurrentItem(0);

        //下拉刷新
       /* swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(LeftMenu.this, "刷新中", Toast.LENGTH_SHORT).show();
                swipeRefreshLayout.setRefreshing(false);
            }
        });*/
    }

    public static ViewPager getViewPager() {
        return viewPager;
    }


}

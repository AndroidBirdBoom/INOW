package com.kobe.ubersplash.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kobe.ubersplash.R;
import com.kobe.ubersplash.utils.TeanBeen;
import com.squareup.picasso.Picasso;

/**
 * Created by Jack on 2017/2/9.
 */

public class OrganizationInfoMore extends AppCompatActivity {

    private TextView organizationName;
    private ImageView organizationImageView;
    private CollapsingToolbarLayout titleCollapsing;
    private Toolbar toolbar;
    private FloatingActionButton button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.organizationinfo_act);
        initView();
        initData();
    }

    public void initView() {
        organizationName = (TextView) findViewById(R.id.organization_moreinfo_textView);
        organizationImageView = (ImageView) findViewById(R.id.organization_imageView);
        titleCollapsing = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_more);
        //button = (FloatingActionButton) findViewById(R.id.floatingActionButton);
    }

    public void initData() {
        TeanBeen.PeopleBeen been = (TeanBeen.PeopleBeen) getIntent().getSerializableExtra("PeopleBeen");
        organizationName.setText(been.toString());
        Picasso.with(getApplicationContext())
                .load(been.getImgsrc())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(organizationImageView);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        titleCollapsing.setExpandedTitleColor(Color.WHITE);
        titleCollapsing.setCollapsedTitleTextColor(Color.WHITE);
        titleCollapsing.setTitle(been.getTitle());
       /* Picasso.with(getApplicationContext())
                .load(been.getImgsrc())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(button);*/
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}

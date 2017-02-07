package com.kobe.ubersplash.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.kobe.ubersplash.R;

import java.util.List;

/**
 * Created by Jack on 2017/2/7.
 */

public class LeftMenu extends Activity {

    private TextView userName, gxName;
    private ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }
}

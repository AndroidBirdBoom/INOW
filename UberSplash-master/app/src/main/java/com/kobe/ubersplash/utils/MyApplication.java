package com.kobe.ubersplash.utils;

import android.app.Application;
import android.content.Context;

/**
 * Created by Jack on 2017/2/14.
 */

public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}

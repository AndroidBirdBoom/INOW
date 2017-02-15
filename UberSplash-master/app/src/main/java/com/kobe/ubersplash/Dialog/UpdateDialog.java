package com.kobe.ubersplash.Dialog;

import android.app.Activity;
import android.app.ProgressDialog;

import com.kobe.ubersplash.activity.LeftMenu;
import com.kobe.ubersplash.utils.MyApplication;

/**
 * Created by Jack on 2017/2/14.
 */

public class UpdateDialog {
    private ProgressDialog dialog;
    public void showDialog() {
        if (dialog == null) {
            dialog = new ProgressDialog(MyApplication.getContext());
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

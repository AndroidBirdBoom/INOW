package com.kobe.ubersplash.utils;

import android.app.Activity;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Jack on 2017/2/7.
 */

public class OkHttpUtils {
    private OkHttpClient client;

    private OkHttpUtils() {
        client = new OkHttpClient();
    }

    private static OkHttpUtils utils;

    public static OkHttpUtils getInstance() {
        if (utils == null) {
            synchronized (OkHttpUtils.class) {
                if (utils == null) {
                    utils = new OkHttpUtils();
                    return utils;
                }
            }
        }
        return utils;
    }

    public interface CallBack<T> {
        void getData(List<T> t);
    }

    public interface CallBack2<T> {
        void getData(T t);
    }

    public <T extends Object> void getBeanOfOk(final Activity activity, String url, final Class<T> clazz, final CallBack<T> callback) {
        Request request = new Request.Builder().get().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();

                //final T t = new Gson().fromJson(json, clazz);
                JsonArray array = new JsonParser().parse(json).getAsJsonArray();
                final List<T> TList = new ArrayList<T>();
                for (JsonElement element : array) {
                    TList.add(new Gson().fromJson(element, clazz));
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (TList != null) {
                            callback.getData(TList);
                        }
                    }
                });
            }
        });
    }

    public <T extends Object> void getBeanOfOk2(final Activity activity, String url, final Class<T> clazz, final CallBack2<T> tCallBack) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                final T t = new Gson().fromJson(json, clazz);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (t != null) {
                            tCallBack.getData(t);
                        }
                    }
                });
            }
        });
    }
}

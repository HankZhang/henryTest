package com.zh.test.http;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by zhangheng on 2016/5/11.
 */
public enum  RequestManager {
        INSTANCE;

    private RequestQueue mRequestQueue;

    public void init(Context context){
        mRequestQueue = Volley.newRequestQueue(context,new OkHttpStack());
    }
}

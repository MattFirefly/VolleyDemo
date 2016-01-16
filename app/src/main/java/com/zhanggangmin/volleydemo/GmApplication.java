package com.zhanggangmin.volleydemo;

import android.app.Application;
import android.text.TextUtils;

/**
 * Created by zhanggangmin on 16/1/16.
 */
public class GmApplication extends Application {
    private RequestQueue mRequestQueue;
    private static GmApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        // initialize the singleton
        sInstance = this;
    }

    public static synchronized GmApplication getInstance() {
        return sInstance;
    }

    public RequestQueue getRequestQueue() {
        // lazy initialize the request queue, the queue instance will be
        // created when it is accessed for the first time
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }

    public void addToRequestQueue(Request req, String tag) {
        // set the default tag if tag is empty
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);

        VolleyLog.d("Adding request to queue: %s", req.getUrl());

        getRequestQueue().add(req);
    }
    public void addToRequestQueue(Request req) {
        // set the default tag if tag is empty
        req.setTag(TAG);

        getRequestQueue().add(req);
    }


    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }


}

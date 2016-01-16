package com.zhanggangmin.volleydemo;

import android.app.Application;

/**
 * Created by zhanggangmin on 16/1/16.
 */
public class GmApplication extends Application {

    private static GmApplication sInstance;


    public static synchronized GmApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // initialize the singleton
        sInstance = this;
    }




}
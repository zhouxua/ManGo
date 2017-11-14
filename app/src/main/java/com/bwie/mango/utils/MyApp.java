package com.bwie.mango.utils;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


/**
 * 1. 类的用途
 * 2. @author forever
 * 3. @date 2017/9/8 12:33
 */

public class MyApp extends Application {
    public static MyApp mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        ImageLoaderConfiguration aDefault = ImageLoaderConfiguration.createDefault(getApplicationContext());
        ImageLoader.getInstance().init(aDefault);
    }
    public static MyApp getInstance() {
        return mInstance;
    }
}

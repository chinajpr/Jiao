package com.jpr.jiao;

import android.app.Application;

/**
 * 类描述：App
 * 作者：jiaopeirong on 2019-07-26 23:08
 * 邮箱：chinajpr@163.com
 */
public class App extends Application {
    private static App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static App getInstance(){
        return instance;
    }
}

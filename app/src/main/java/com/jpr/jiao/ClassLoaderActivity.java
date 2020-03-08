package com.jpr.jiao;

import android.app.Activity;
import android.app.Instrumentation;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import dalvik.system.BaseDexClassLoader;

/**
 * 类描述：
 * 作者：jiaopeirong on 2020-02-15 20:25
 * 邮箱：chinajpr@163.com
 */
public class ClassLoaderActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ClassLoader classLoader = getClassLoader();
        while (classLoader != null) {
            Log.d("zhaoxh", classLoader + "");
            classLoader = classLoader.getParent();
        }
        Log.d("zhaoxh", Activity.class.getClassLoader() + "");
        Log.d("zhaoxh", AppCompatActivity.class.getClassLoader() + "");
    }


}

package com.jpr.jiao.customview.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.LruCache;
import android.view.View;

import com.jpr.jiao.R;

/**
 * 类描述：
 * 作者：jiaopeirong on 2019-12-29 21:24
 * 邮箱：chinajpr@163.com
 */
public class ClockActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

    }
}

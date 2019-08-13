package com.jpr.jiao.StatusBar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jpr.jiao.R;

/**
 * 类描述：4.4以上沉浸式状态栏
 * 创建日期：2019/8/13.
 * 作者：jiaopeirog
 */
public class TitleAllActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_all);
    }

    public void status4(View view) {
        intent = new Intent(this, Title4Activity.class);
        startActivity(intent);
    }

    public void status5(View view) {
        intent = new Intent(this, Title5Activity.class);
        startActivity(intent);
    }

    public void status6(View view) {
        intent = new Intent(this, Title6Activity.class);
        startActivity(intent);
    }
}

package com.jpr.jiao.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jpr.jiao.R;

/**
 * 类描述：
 * 创建日期：2019/9/30.
 * 作者：jiaopeirog
 */
public class MyRV extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrv);
    }

    public void recyclerView1(View view) {
        Intent i = new Intent(this , RecyclerView1.class);
        startActivity(i);
    }

    public void recyclerView2(View view) {
        Intent i = new Intent(this , RecyclerView2.class);
        startActivity(i);
    }
}

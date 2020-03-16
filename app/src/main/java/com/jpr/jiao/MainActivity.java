package com.jpr.jiao;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jpr.jiao.StatusBar.TitleAllActivity;
import com.jpr.jiao.customview.view.ClockActivity;
import com.jpr.jiao.customview.viewgroup.MyViewGroupActivity;
import com.jpr.jiao.md.CoordinatorActivity0;
import com.jpr.jiao.md.CoordinatorActivity1;
import com.jpr.jiao.nestedScrolling.NestedActivity;
import com.jpr.jiao.other.StringActivity;
import com.jpr.jiao.recyclerview.MyRV;
import com.jpr.jiao.retrofit.RetrofitActivity;

public class MainActivity extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void coor0(View view) {
        intent = new Intent(this, CoordinatorActivity0.class);
        startActivity(intent);
    }


    public void coor1(View view) {
        intent = new Intent(this , CoordinatorActivity1.class);
        startActivity(intent);
    }

    public void statusBar(View view) {
        intent = new Intent(this , TitleAllActivity.class);
        startActivity(intent);
    }

    public void recyclerView(View view) {
        intent = new Intent(this , MyRV.class);
        startActivity(intent);
    }

    public void nested(View view) {
        intent = new Intent(this, NestedActivity.class);
        startActivity(intent);
    }
    public void myViewGroup(View view) {
        intent = new Intent(this , MyViewGroupActivity.class);
        startActivity(intent);
    }

    public void clock(View view) {
        intent = new Intent(this , ClockActivity.class);
        startActivity(intent);
    }

    public void retrofit(View view) {
        intent = new Intent(this , RetrofitActivity.class);
        startActivity(intent);
    }

    public void classloader(View view) {
        intent = new Intent(this , ClassLoaderActivity.class);
        startActivity(intent);
    }

    public void stringClick(View view) {
        intent = new Intent(this , StringActivity.class);
        startActivity(intent);
    }
}

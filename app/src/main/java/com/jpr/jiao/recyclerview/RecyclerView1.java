package com.jpr.jiao.recyclerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jpr.jiao.R;
import com.jpr.jiao.recyclerview.adapter.Adapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：RecyclerView 系列第一篇：基本使用
 * 创建日期：2019/9/30.
 * 作者：jiaopeirog
 */
public class RecyclerView1 extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview1);
        setRecyclerView();

    }

    private void setRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Adapter1 adapter1 = new Adapter1();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter1);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        adapter1.setData(list);
    }
}

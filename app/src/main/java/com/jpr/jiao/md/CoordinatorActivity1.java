package com.jpr.jiao.md;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jpr.jiao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：CollapsingToolbarLayout 是toolbar的包装器
 * CoordinatorLayout + AppBarLayout + CollapsingToolbarLayout
 * 创建日期：2019/8/10.
 * 作者：jiaopeirog
 */
public class CoordinatorActivity1 extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coor1);
        initView();
    }

    private void initView() {
        Toolbar toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("Title");
//        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.coll);
//        collapsingToolbarLayout.setContentScrimColor(Color.parseColor("#999333"));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        CoorAdapter coorAdapter = new CoorAdapter(this, list);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(coorAdapter);

    }
}

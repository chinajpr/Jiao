package com.jpr.jiao.recyclerview;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jpr.jiao.R;
import com.jpr.jiao.recyclerview.adapter.Adapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：ItemDecoration
 * 创建日期：2019/9/30.
 * 作者：jiaopeirog
 */
public class RecyclerView2 extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview1);
//        setRecyclerView1();
        setRecyclerView2();
    }

    /**
     * 自定义ItemDecoration
     */
    private void setRecyclerView2() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Adapter1 adapter1 = new Adapter1();
        recyclerView.setLayoutManager(new MyLayoutManager());
        recyclerView.setAdapter(adapter1);

        //初始化分隔线、添加分隔线
        MyItemDecoration mDivider = new MyItemDecoration();
        recyclerView.addItemDecoration(mDivider);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        adapter1.setData(list);
    }

    /**
     * 系统定义好的ItemDecoration
     */
    private void setRecyclerView1() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        Adapter1 adapter1 = new Adapter1();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter1);

        //初始化分隔线、添加分隔线
        DividerItemDecoration mDivider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(mDivider);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(String.valueOf(i));
        }
        adapter1.setData(list);
    }

    class MyItemDecoration extends RecyclerView.ItemDecoration{

        Paint mPaint;

        public MyItemDecoration() {
            mPaint = new Paint();
            mPaint.setColor(Color.GREEN);
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDraw(c, parent, state);
            Log.d("rv" , "onDraw");

            int childCount = parent.getChildCount();
            RecyclerView.LayoutManager manager = parent.getLayoutManager();
            for (int i=0;i<childCount;i++){
                View child = parent.getChildAt(i);
                //动态获取outRect的left值
                int left = manager.getLeftDecorationWidth(child);
                int cx = left/2;
                int cy = child.getTop()+child.getHeight()/2;
                c.drawCircle(cx,cy,20,mPaint);
            }
        }

        @Override
        public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
            super.onDrawOver(c, parent, state);
            Log.d("rv" , "onDrawOver");
//            //画蒙版
//            View temp = parent.getChildAt(0);
//            LinearGradient gradient = new LinearGradient(parent.getWidth() / 2, 0, parent.getWidth() / 2, temp.getHeight() * 3,
//                    0xff0000ff, 0x000000ff, Shader.TileMode.CLAMP);
//            mPaint.setShader(gradient);
//            c.drawRect(0, 0, parent.getWidth(), temp.getHeight() * 3, mPaint);
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            Log.d("rv" , "getItemOffsets");
            super.getItemOffsets(outRect, view, parent, state);
            outRect.left=200;
            outRect.bottom=1;
        }
    }
}

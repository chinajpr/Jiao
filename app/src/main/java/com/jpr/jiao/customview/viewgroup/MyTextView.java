package com.jpr.jiao.customview.viewgroup;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * 类描述：
 * 作者：jiaopeirong on 2019-12-28 15:39
 * 邮箱：chinajpr@163.com
 */
@SuppressLint("AppCompatCustomView")
public class MyTextView extends View {

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec , heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        Log.d("jiaopeirong" , "view:onmeasure");
        switch (measureHeightMode) {
            case MeasureSpec.AT_MOST:
                Log.d("jiaopeirong","TextView 的模式是："+ "MeasureSpec.AT_MOST");
                break;
            case MeasureSpec.EXACTLY:
                Log.d("jiaopeirong","TextView 的模式是："+ "MeasureSpec.EXACTLY");
                break;
        }
        Log.d("jiaopeirong", "TextView:::"+measureWidth + "---" + measureHeight );

//        int i = MeasureSpec.makeMeasureSpec(30000000, MeasureSpec.EXACTLY);
//        setMeasuredDimension(i,i);
    }


}

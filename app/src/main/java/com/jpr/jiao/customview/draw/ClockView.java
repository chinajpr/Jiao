package com.jpr.jiao.customview.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.jpr.jiao.utils.ScreenUtils;

import java.util.Calendar;

/**
 * 类描述：时钟
 * 作者：jiaopeirong on 2019-07-26 22:49
 * 邮箱：chinajpr@163.com
 */
public class ClockView extends View {
    private Context context;
    /**
     * 钟表边长
     */
    private int clockSideLength;
    /**
     * 钟表圆心
     */
    private int clockCenterX;
    private int clockCenterY;
    /**
     * 刻度距表盘的距离
     */
    int padding;

    /**
     * 画笔
     */
    private Paint paint;

    public ClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        clockSideLength = w;
        clockCenterX = w / 2;
        clockCenterY = w / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制表盘
        drawDial(canvas);
        //绘制刻度
        drawScale(canvas);
        //绘制表针
        drawHand(canvas);
        //每1s刷新一次
        postInvalidateDelayed(1000);
    }

    /**
     * 绘制表针
     */
    private void drawHand(Canvas canvas) {
        Calendar calendar = Calendar.getInstance();

        //时
        int hour = calendar.get(Calendar.HOUR);
        //分
        int minute = calendar.get(Calendar.MINUTE);
        //秒
        int second = calendar.get(Calendar.SECOND);

        //时针转过的角度
        float h = (hour + (float) minute / 60) * 360 / 12;
        //分针转过的角度
        float m = (minute + (float) second / 60) * 360 / 60;
        //秒针转过的角度
        int s = second * 360 / 60;

        //时针的宽度
        int hw = ScreenUtils.dp2px(10);
        int mw = ScreenUtils.dp2px(7);
        int sw = ScreenUtils.dp2px(4);

        //save,restore:时针，分针，秒针单独旋转角度，否则会错乱。比如，时针旋转5度，分针再旋转5度，如果不实用save,restore的话，分针就会旋转10度，使数据错乱
        //绘制时针
        canvas.save();
        canvas.rotate(h, clockCenterX, clockCenterY);
        paint.setStyle(Paint.Style.FILL);
        RectF rectHour = new RectF(clockCenterX - hw / 2, padding + ScreenUtils.dp2px(25), clockCenterX + hw / 2, clockCenterY + padding + ScreenUtils.dp2px(15));
        canvas.drawRoundRect(rectHour, ScreenUtils.dp2px(5), ScreenUtils.dp2px(5), paint);
        canvas.restore();

        //绘制分针
        canvas.save();
        canvas.rotate(m, clockCenterX, clockCenterY);
        RectF rectM = new RectF(clockCenterX - mw / 2, padding + ScreenUtils.dp2px(15),
                clockCenterX + mw / 2, clockCenterY + padding + ScreenUtils.dp2px(15));
        canvas.drawRoundRect(rectM, ScreenUtils.dp2px(5), ScreenUtils.dp2px(5), paint);
        canvas.restore();

        //绘制秒针
        canvas.save();
        canvas.rotate(s, clockCenterX, clockCenterY);
        RectF rectS = new RectF(clockCenterX - sw / 2, padding, clockCenterX +
                sw / 2, clockCenterY + padding + ScreenUtils.dp2px(15));
        paint.setColor(Color.RED);
        canvas.drawRoundRect(rectS, ScreenUtils.dp2px(5), ScreenUtils.dp2px(5), paint);
        canvas.restore();

        //绘制原点
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(clockCenterX, clockCenterY, ScreenUtils.dp2px(5), paint);
    }

    /**
     * 绘制刻度
     *
     * @param canvas
     */
    private void drawScale(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(ScreenUtils.dp2px(2));
        paint.setColor(Color.BLACK);


        padding = ScreenUtils.dp2px(5);
        //普通刻度的长度
        int s0 = ScreenUtils.dp2px(15);
        //5整点刻度的长度
        int s1 = ScreenUtils.dp2px(20);

        for (int i = 0; i < 60; i++) {
            if (i % 5 == 0) {
                paint.setColor(Color.RED);
                canvas.drawLine(clockSideLength / 2, padding, clockSideLength / 2, padding + s1, paint);
            } else {
                paint.setColor(Color.BLACK);
                canvas.drawLine(clockSideLength / 2, padding, clockSideLength / 2, padding + s0, paint);
            }
            canvas.rotate(360 / 60, clockCenterX, clockCenterY);
        }
    }

    /**
     * 绘制表盘
     *
     * @param canvas
     */
    private void drawDial(Canvas canvas) {
        paint.setColor(Color.WHITE);
        canvas.drawCircle(clockCenterX, clockCenterY, clockSideLength / 2, paint);
    }
}

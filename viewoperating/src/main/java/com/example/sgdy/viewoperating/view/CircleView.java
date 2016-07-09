package com.example.sgdy.viewoperating.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.sgdy.viewoperating.R;

/**
 * Created by sgdy on 16/7/9.
 */
public class CircleView extends View {
    /**
     * 第一圈的颜色
     */
    private int mFirstColor;
    /**
     * 第二圈的颜色
     */
    private int mSecondColor;
    /**
     * 圈的宽度
     */
    private int mCircleWidth;
    /**
     * 当前进度
     */
    private int mProgress;
    /**
     * 速度
     */
    private int mSpeed;
    /**
     * 画笔
     */
    private Paint mPaint;
    /**
     * 是否应该开始下一个
     */
    private boolean isNext;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar,
                defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomProgressBar_firstColor:
                    mFirstColor = a.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.CustomProgressBar_secondColor:
                    mSecondColor = a.getColor(attr, Color.RED);
                    break;
                case R.styleable.CustomProgressBar_circleWidth:
                    mCircleWidth = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 20, getResources().getDisplayMetrics()
                    ));
                    break;
                case R.styleable.CustomProgressBar_speed:
                    mSpeed = a.getInt(attr, 20);
                    break;
            }
        }
        a.recycle();
        mPaint = new Paint();
        new Thread(() -> {
            while (true) {
                mProgress++;
                if (mProgress == 360) {
                    mProgress = 0;
                    isNext = !isNext ? true : false;
                }
                postInvalidate();
                SystemClock.sleep(mSpeed);
            }
        }).start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int center = getWidth() / 2;//获取圆心的x坐标
        int radius = center - mCircleWidth / 2;//半径
        mPaint.setStrokeWidth(mCircleWidth);//设置圆环的宽度
        mPaint.setAntiAlias(true);//消除锯齿
        mPaint.setStyle(Paint.Style.STROKE);//设置空心

        //定义圆弧的形状和大小的界限
        RectF oval = new RectF(center - radius, center - radius, center + radius, center + radius);
        if (!isNext) {
            //第一圈
            mPaint.setColor(mFirstColor);//设置圆环的颜色
            canvas.drawCircle(center, center, radius, mPaint);//画出圆环
            mPaint.setColor(mSecondColor);//设置圆环的颜色
            canvas.drawArc(oval, -90, mProgress, false, mPaint);//根据进度画弧
        } else {
            //第二圈
            mPaint.setColor(mSecondColor);//设置圆环的颜色
            canvas.drawCircle(center, center, radius, mPaint);//画出圆环
            mPaint.setColor(mFirstColor);//设置圆环的颜色
            canvas.drawArc(oval, -90, mProgress, false, mPaint);//根据进度画弧
        }
    }
}

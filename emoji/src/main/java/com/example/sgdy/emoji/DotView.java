package com.example.sgdy.emoji;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sgdy on 16/8/22.
 */
public class DotView extends View {

    private Paint mPaint;
    private float radius;
    private float padding;
    private int mWidth;
    private int totalPage, currentPage;
    private float startX;

    public void initData(int totalPage, int currentPage) {
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        //第一个圆的x坐标
        startX = (mWidth - totalPage * radius * 2 - (totalPage - 1) * padding) / 2 + radius;
        invalidate();
    }

    public void notifyDataChanged(int totalPage, int currentPage) {
        initData(totalPage, currentPage);
    }

    public DotView(Context context) {
        this(context, null);
    }

    public DotView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DotView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        float density = context.getResources().getDisplayMetrics().density;
        //点的半径
        radius = 6 * density;
        padding = 10 * density;

        mWidth = context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        float cx = startX;
        float cy = radius;
        for (int i = 0; i < totalPage; i++) {
            //选中的页码颜色和未选中的页码颜色不同
            if (i == currentPage) {
                mPaint.setColor(Color.parseColor("#8C8C8C"));
            } else {
                mPaint.setColor(Color.parseColor("#BCBCBC"));
            }
            canvas.drawCircle(cx, cy, radius, mPaint);
            startX += radius * 2 + padding;
        }
    }
}

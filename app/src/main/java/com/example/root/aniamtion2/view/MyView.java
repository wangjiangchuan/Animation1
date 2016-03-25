package com.example.root.aniamtion2.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.root.aniamtion2.R;

/**
 * Created by root on 16-3-22.
 */
public class MyView extends ImageView {

    private Paint mPaint;
    private int width, height;
    private int radius;

    public MyView(Context context, AttributeSet attrs){
        super(context, attrs);
        initiation();
    }

    public MyView(Context context){
        super(context);
        initiation();
    }

    private void initiation(){
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.circle));
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(3);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width, height, radius, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }


    public void drawCircle(int x, int y, int rad){
        width = x;
        height = y;
        radius = rad;
        invalidate();
    }
}

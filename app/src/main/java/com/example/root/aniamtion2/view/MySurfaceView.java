package com.example.root.aniamtion2.view;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

import com.example.root.aniamtion2.R;

/**
 * Created by root on 16-3-22.
 */
public class MySurfaceView extends SurfaceView {

    private Paint mPaint;
    public MySurfaceView(Context context){
        super(context);

    }

    public MySurfaceView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    private void initiation(){
        mPaint = new Paint();
        mPaint.setColor(getResources().getColor(R.color.circle));
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(3);
    }


}

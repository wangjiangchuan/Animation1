package com.example.root.aniamtion2.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.root.aniamtion2.R;
import com.example.root.aniamtion2.view.MyView;

public class MainActivity extends Activity {

    private ImageButton imageButton;
    private ImageView imageView2;
    private MyView imageViwe1;
    private Rect rect = new Rect();
    private int radius = 0;
    private ValueAnimator anim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //final
        imageButton = (ImageButton)findViewById(R.id.image_but);
        imageView2 = (ImageView)findViewById(R.id.image_view2);
        imageViwe1 = (MyView)findViewById(R.id.image_view1);

        //点击心形的动画
        final AnimatorSet set1 = new AnimatorSet();
        ObjectAnimator rotate1 = ObjectAnimator.ofFloat(imageButton,"rotation",0f,360f);
        rotate1.setDuration(300);

        final AnimatorSet set2 = new AnimatorSet();

        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX", 0.0f, 1.2f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY", 0.0f, 1.2f);
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofPropertyValuesHolder(imageButton, scaleX, scaleY);

        PropertyValuesHolder scaleX1 = PropertyValuesHolder.ofFloat("scaleX", 1.2f, 1.0f);
        PropertyValuesHolder scaleY1 = PropertyValuesHolder.ofFloat("scaleY", 1.2f, 1.0f);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofPropertyValuesHolder(imageButton, scaleX1, scaleY1);

        set2.setDuration(500);
        set2.play(objectAnimator1).before(objectAnimator2);

        set1.play(rotate1);
        set1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                imageButton.setImageResource(R.drawable.ic_heart_red);
                set2.start();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        //imageButton.setAnimation(rotate);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageButton.setImageResource(R.drawable.ic_heart_outline_grey);
                set1.start();
            }
        });

        anim = ValueAnimator.ofInt(0, 500);
        anim.setInterpolator(new LinearInterpolator());
        //anim.setDuration(500);

        //点击图片的动画
        final AnimatorSet set3 = new AnimatorSet();
        PropertyValuesHolder scaleX2 = PropertyValuesHolder.ofFloat("scaleX", 0.0f, 0.3f);
        PropertyValuesHolder scaleY2 = PropertyValuesHolder.ofFloat("scaleY", 0.0f, 0.3f);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofPropertyValuesHolder(imageView2, scaleX2, scaleY2);
        objectAnimator3.setInterpolator(new DecelerateInterpolator());
        objectAnimator3.setDuration(600);
        PropertyValuesHolder scaleX3 = PropertyValuesHolder.ofFloat("scaleX", 0.3f, 0.0f);
        PropertyValuesHolder scaleY3 = PropertyValuesHolder.ofFloat("scaleY", 0.3f, 0.0f);
        ObjectAnimator objectAnimator4 = ObjectAnimator.ofPropertyValuesHolder(imageView2, scaleX3, scaleY3);
        objectAnimator4.setInterpolator(new AccelerateInterpolator());
        objectAnimator4.setDuration(300);
        set3.play(objectAnimator3).before(objectAnimator4);
        set3.play(objectAnimator3).with(anim);
        set3.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                imageButton.setImageResource(R.drawable.ic_heart_outline_grey);
                set1.start();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });


        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.setImageResource(R.drawable.ic_heart_outline_white);
                set3.start();
            }
        });

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int rate = (Integer) anim.getAnimatedValue();
                Log.e("radiu", String.valueOf(rate));
                if (rate > rect.width() / 2) {
                    anim.cancel();
                    imageViwe1.drawCircle(0, 0, 0);
                } else {
                    imageViwe1.drawCircle(rect.width() / 2, rect.height() / 2, rate);
                }

            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        imageViwe1.getGlobalVisibleRect(rect);
    }

}

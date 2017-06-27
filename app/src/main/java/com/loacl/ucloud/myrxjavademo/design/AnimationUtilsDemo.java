package com.loacl.ucloud.myrxjavademo.design;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.loacl.base.BaseActivity;
import com.loacl.ucloud.myrxjavademo.R;

/**
 * Created by ellen on 2017/2/28.
 * AnimationUtils 测试
 * 5.0后的动画新特性
 */

public class AnimationUtilsDemo extends Activity {
    ImageView mImageView;
    int centerX;
    int centerY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_animationutil_demo);
        mImageView= (ImageView) findViewById(R.id.image);

    }

    public void outToIn(View view){
        centerX = mImageView.getWidth() / 2;//获取组件的宽的一半
        centerY = mImageView.getHeight() / 2;//获取组件的高的一半
        Animator animator = ViewAnimationUtils.createCircularReveal(mImageView, centerX, centerY, mImageView.getWidth(), 0);
        animator.setDuration(3000);
//                animator.setStartDelay(1000);//这里可以设置动画的延迟时间；
        animator.setInterpolator(new LinearOutSlowInInterpolator());//out到in
        animator.start();
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mImageView.setVisibility(View.INVISIBLE);
            }
        });

    }
    public void inToOut(View view){
        int cenX = mImageView.getWidth() / 2;
        int cenY = mImageView.getHeight() / 2;
        Animator an = ViewAnimationUtils.createCircularReveal(mImageView, cenX, cenY, 0, cenX);
        an.setDuration(3000);
        an.start();
        an.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                mImageView.setVisibility(View.VISIBLE);
            }
        });
    }
    public void acrossCorners(View view){
        Animator animator1 = ViewAnimationUtils.createCircularReveal(
                mImageView, 0, 0, 0, (float) Math.hypot(mImageView.getWidth(), mImageView.getHeight()));//宽的平方加上高的平方的根号
        animator1.setInterpolator(new LinearInterpolator());//插补器有没有不影响
        animator1.setDuration(2000);
        animator1.start();

    }
    public  void showImage(View view){
        mImageView.setVisibility(View.VISIBLE);
    }
}

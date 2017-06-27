package com.loacl.ucloud.myrxjavademo.mateiraldesign;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Path;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.widget.CardView;
import android.transition.ChangeImageTransform;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.loacl.base.BaseActivity;
import com.loacl.ucloud.myrxjavademo.R;

/**
 * Created by Aven on 2017/2/20.
 * 定义定制动画
 * 触摸反馈
 * ***适用于按钮的默认触摸动画使用全新 RippleDrawable 类别，以波纹效果实现不同状态间的转换。
 * ****?android:attr/selectableItemBackground 指定有界的波纹
 * ****?android:attr/selectableItemBackgroundBorderless 指定越过视图边界的波纹。 它将由一个非空背景的视图的最近父项所绘制和设定边界
 * 循环揭露
 * ****显示或隐藏一组 UI 元素时，揭露动画可为用户提供视觉连续性。ViewAnimationUtils.createCircularReveal() 方法让 能够为裁剪区域添加动画以揭露或隐藏视图。
 * ****其作用就是可以使控件能够呈现水波一样展开。
 * 操作行为转换 <两种实现方式 <1:java代码里面实现，2:样式里面实现>
 * *****操作行为转换透过通用元素之间的移动和转换提供不同状态之间的视觉连接。 为进入、退出转换以及操作行为之间的共享元素转换指定定制动画。
 * *****[进入]转换将决定操作行为中视图如何进入场景。
 * *****[退出]转换将决定操作行为中应用行为的显示视图如何退出场景。
 * *****[共享元素]转换将决定两个操作行为转换之间共享的视图如何在这些操作行为中转换。
 * 曲线运动
 * 视图状态改变
 */

public class AnimationAct extends BaseActivity {
    View mView;
    int cx, cy;
    boolean ishow;
    Button show;
    CardView mShare;
    final String TAG = "AnimationAct";
    View pathView;
    ImageView imageview;
    @Override
    public int getLayoutId() {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        return R.layout.layout_animation;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mView = findViewById(R.id.view);
        show = (Button) findViewById(R.id.show);
        mShare = (CardView) findViewById(R.id.share);
        pathView= findViewById(R.id.path_view);
         /*矢量改变动画*/
        imageview= (ImageView) findViewById(R.id.imageview);


    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initData() {
        ((AnimatedVectorDrawableCompat) imageview.getDrawable()).start();
        int cx = (mView.getLeft() + mView.getRight()) / 2;
        int cy = (mView.getTop() + mView.getBottom()) / 2;
        if (ishow)
            show.setText("显示View");
        else
            show.setText("隐藏View");

    }

    @Override
    protected void initAction() {

    }

    /**
     * 循环揭露效果
     **/
    public void Show(View view) {

        Animator anim = null;
        if (ishow) {
            show.setText("显示View");
            /**
             * 此效果隐藏之前可见的视图
             * */
            int initialRadius = mView.getWidth();
            anim = ViewAnimationUtils.createCircularReveal(mView, cx, cy, initialRadius, 0);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    mView.setVisibility(View.INVISIBLE);
                }
            });
        } else {
            show.setText("隐藏View");
            /***
             * 此效果揭露之前不可见的视图
             * */
            int finalRadius = Math.max(mView.getWidth(), mView.getHeight());
            anim = ViewAnimationUtils.createCircularReveal(mView, cx, cy, 0, finalRadius);
            mView.setVisibility(View.VISIBLE);
        }
        ishow = !ishow;
        anim.start();
    }

    public void Share(View view) {
        getWindow().setEnterTransition(new Fade().setDuration(2000));
        getWindow().setExitTransition(new Fade().setDuration(2000));
        Intent intent = new Intent(this, JumbAct.class);
        ActivityOptions options = ActivityOptions
                .makeSceneTransitionAnimation(this, mShare, "share");
        startActivity(intent, options.toBundle());
    }

    /**
     * 分解--从场景中心移入或移出视图
     **/
    public void Explode(View view) {
        Log.i(TAG, "分解");

//        getWindow().setExitTransition(new Explode());
        getWindow().setEnterTransition(new Explode().setDuration(2000));
        getWindow().setExitTransition(new Explode().setDuration(2000));
        Intent intent = new Intent(this, JumbAct.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    /***
     * 滑动---从场景边缘移入或移出视图
     */
    public void Slide(View view) {
        Log.i(TAG, "滑动");
//        getWindow().setExitTransition(new Explode());
        getWindow().setEnterTransition(new Slide().setDuration(2000));
        getWindow().setExitTransition(new Slide().setDuration(2000));
        Intent intent = new Intent(this, JumbAct.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    /***
     * 淡入淡出---通过调整透明度在场景中增添或移除视图。
     */
    public void InOut(View view) {
        getWindow().setEnterTransition(new Fade().setDuration(2000));
        getWindow().setExitTransition(new Fade().setDuration(2000));
        Intent intent = new Intent(this, JumbAct.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    /**
     *使用曲线运动
     * 动画利用曲线实现时间内插与空间移动模式。 利用 Android 5.0（API 级别 21）及更高版本，您可为动画定义定制时间曲线以及曲线运动模式。
     * 可以自定义很多动画，加速度减速带动画
     * */
    public void PathInterpolator(View view){
        Path path = new Path();
        path.moveTo(200, 200);

        path.quadTo(200, 200, 200, 800);

        PathInterpolator pathInterpolator = new PathInterpolator(0.33f,0f,0.12f,1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                pathView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
//                l.removeView(imageView);
                pathView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
//                l.removeView(imageView);
                pathView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                pathView.setVisibility(View.VISIBLE);
            }
        });
        ObjectAnimator scalex = ObjectAnimator.ofFloat(pathView, View.SCALE_X, 1.0f, 0.3f);
        ObjectAnimator scaley = ObjectAnimator.ofFloat(pathView, View.SCALE_Y, 1.0f, 0.3f);
        ObjectAnimator traslateAnimator = ObjectAnimator.ofFloat(pathView, "x", "y", path);

        animSet.playTogether(scalex, scaley, traslateAnimator);

        animSet.setInterpolator(pathInterpolator);
        animSet.setDuration(1500);
        animSet.start();

    }
    /**
     * 使用曲线运动
     * 使用xml文件设置动画
     * */
    public void XMLAnimation(View view){
        Log.i(TAG, "视图状态改变添加动画");
        pathView.setVisibility(View.VISIBLE);
        ObjectAnimator animator = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.loop_animation );
        animator.setTarget(pathView);
        animator.start();
    }
}

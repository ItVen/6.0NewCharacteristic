package com.loacl.view;


import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

import com.loacl.ucloud.myrxjavademo.R;

/**
 * Created by ellen on 2017/2/22.
 * 自定义ScrollView
 */

public class MyFadingScrollView extends ScrollView {
    private static String TAG = "-----------MyFadingScrollView----------";
    //渐变view
    private View[]  fadingView;
    //滑动view的高度，如果这里fadingHeightView是一张图片，  那么就是这张图片上滑至完全消失时action bar 完全显示，
    // 过程中透明度不断增加，直至完全显示
    private View fadingHeightView;
    //滑动距离，默认设置滑动500 时完全显示，根据实际需求自己设置
    private int fadingHeight = 500;

    public MyFadingScrollView(Context context) {
        super(context);
    }

    public MyFadingScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFadingScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setFadingView(View[] view){this.fadingView = view;}
    public void setFadingHeightView(View v){this.fadingHeightView = v;}

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(fadingHeightView != null)
            fadingHeight = fadingHeightView.getMeasuredHeight();
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);

        float fading = t>fadingHeight ? fadingHeight : (t > 30 ? t : 0);
        updateActionBarAlpha( fading / fadingHeight);

    }

    void updateActionBarAlpha(float alpha){
        try {
            setActionBarAlpha(alpha);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setActionBarAlpha(float alpha) throws Exception{
        if(fadingView.length==0){
            throw new Exception("fadingView is null...");
        }
        for (View view :fadingView){
            if (view.getId()== R.id.view)
                view.setBackgroundColor(Color.BLACK);
            if (view.getId() == R.id.textView){
                if(alpha==0)
                    view.setBackgroundColor(Color.WHITE);
                else
                    view.setBackgroundColor(Color.YELLOW);
                continue;
            }
            view.setAlpha(alpha);
        }

    }
}

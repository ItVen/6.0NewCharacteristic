package com.loacl.ucloud.myrxjavademo.mateiraldesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;

import com.loacl.base.BaseActivity;
import com.loacl.ucloud.myrxjavademo.R;

/**
 * Created by ellen on 2017/3/6.
 * BottomSheetBehaviors控件，一个底部表,常用在分享或者地图、音乐等app看到的效果
 */

public class BottomSheetBehaviorDemo extends BaseActivity {
    CoordinatorLayout coordinatorLayout;
    @Override
    public int getLayoutId() {
        return R.layout.layout_bottomsheet;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        View bottomSheet = coordinatorLayout.findViewById(R.id.bottom_sheet);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                //这里是bottomSheet 状态的改变，根据slideOffset可以做一些动画
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //这里是拖拽中的回调，根据slideOffset可以做一些动画
            }
        });
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initAction() {

    }
}

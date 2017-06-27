package com.loacl.ucloud.myrxjavademo;

import android.os.Bundle;
import android.view.ViewStub;
import android.widget.TextView;

import com.loacl.base.BaseActivity;

/**
 * Created by Aven on 2017/2/24.
 * 页面布局优化 ViewStub
 */

public class Optimization extends BaseActivity {
    ViewStub subImage,subText;
    TextView tv;
    @Override
    public int getLayoutId() {
        return R.layout.layout_performance_optimization;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        subImage = (ViewStub) findViewById(R.id.sub_image);
        subText = (ViewStub) findViewById(R.id.sub_text);
        subImage.inflate();
        subText.inflate();
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initData() {
        tv = (TextView) findViewById(R.id.tv);
        tv.setText("我说从SubView里面渲染出来的，layout 的性能优化更好");
    }

    @Override
    protected void initAction() {

    }
}

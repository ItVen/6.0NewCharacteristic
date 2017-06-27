package com.loacl.base;

import android.os.Bundle;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;


/**
 * Created by Aven on 2017/2/15.
 * Rxlifecycle 使被用来严格控制由于发布了一个订阅后，由于没有及时取消，导致Activity/Fragment无法销毁导致的内存泄露。
 */

public abstract class BaseActivity extends RxAppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化控件
        initViews(savedInstanceState);
        //初始化ToolBar
        initToolBar();
        initData();
        initAction();
    }

    public abstract int getLayoutId();

    protected abstract void initViews(Bundle savedInstanceState);

    protected abstract void initToolBar();

    protected abstract void initData();

    protected abstract void initAction();
}

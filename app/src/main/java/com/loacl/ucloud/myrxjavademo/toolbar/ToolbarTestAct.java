package com.loacl.ucloud.myrxjavademo.toolbar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.loacl.base.BaseActivity;
import com.loacl.ucloud.myrxjavademo.R;
import com.loacl.ucloud.myrxjavademo.adapter.MyRecyclerViewAdapter;
import com.loacl.view.MyFadingScrollView;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ellen on 2017/2/22.
 * 滑动view的时候顶部的view有渐变效果
 */

public class ToolbarTestAct extends BaseActivity {
    private View layout;
    private MyFadingScrollView fadingScrollView;
    View mView;
    ImageView mImage;
    TextView mTextView;
    RecyclerView mRecyclerView;
    @Override
    public int getLayoutId() {
        return R.layout.layout_toolbartest;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        layout = findViewById(R.id.nac_layout);
        mView = findViewById(R.id.view);
        fadingScrollView = (MyFadingScrollView)findViewById(R.id.nac_root);
        mImage= (ImageView) findViewById(R.id.nac_image);
        mTextView= (TextView) findViewById(R.id.textView);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);


    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initData() {
        layout.setAlpha(0);
        mView.setAlpha(0);
        View[] view ={layout,mView,mTextView};
        fadingScrollView.setFadingView(view);
        fadingScrollView.setFadingHeightView(mImage);

        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }
        mRecyclerView.setAdapter(new MyRecyclerViewAdapter(this, datas));
    }

    @Override
    protected void initAction() {

    }


}

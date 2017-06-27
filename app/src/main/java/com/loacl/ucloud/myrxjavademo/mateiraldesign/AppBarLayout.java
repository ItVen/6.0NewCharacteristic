package com.loacl.ucloud.myrxjavademo.mateiraldesign;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.loacl.base.BaseActivity;
import com.loacl.ucloud.myrxjavademo.R;
import com.loacl.ucloud.myrxjavademo.adapter.MyViewPagerAdapter;
import com.loacl.ucloud.myrxjavademo.fragment.FragmentOne;
import com.loacl.ucloud.myrxjavademo.fragment.Fragment_2;
import com.loacl.ucloud.myrxjavademo.fragment.Fragment_3;
import com.loacl.ucloud.myrxjavademo.fragment.Fragment_4;
import com.loacl.ucloud.myrxjavademo.fragment.Fragment_5;
import com.loacl.ucloud.myrxjavademo.fragment.Fragment_6;

/**
 * Created by ellen on 2017/2/15.
 * 测试appbar tableLayout 的使用
 */

public class AppBarLayout extends BaseActivity {
    Toolbar toolBar;
    TabLayout mTabLayout;
    ViewPager viewPager;
    MyViewPagerAdapter viewPagerAdapter;

    @Override
    public int getLayoutId() {
        return R.layout.layout_appbar;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        mTabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    protected void initToolBar() {
        toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("Toolbar");
        toolBar.setSubtitle("小标题");
        toolBar.setTitleTextColor(Color.WHITE);
    }

    @Override
    protected void initData() {
        viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(FragmentOne.newInstance(), "TabOne");//添加Fragment
        viewPagerAdapter.addFragment(Fragment_2.newInstance(), "TabTwo");
        viewPagerAdapter.addFragment(Fragment_3.newInstance(), "TabThree");
        viewPagerAdapter.addFragment(Fragment_4.newInstance(), "tb_4");
        viewPagerAdapter.addFragment(Fragment_5.newInstance(), "tb_5");
        viewPagerAdapter.addFragment(Fragment_6.newInstance(), "tb_6");

        mTabLayout.addTab(mTabLayout.newTab().setText("TabOne"));//给TabLayout添加Tab
        mTabLayout.addTab(mTabLayout.newTab().setText("TabTwo"));
        mTabLayout.addTab(mTabLayout.newTab().setText("TabThree"));
        mTabLayout.addTab(mTabLayout.newTab().setText("tb_4"));
        mTabLayout.addTab(mTabLayout.newTab().setText("tb_5"));
        mTabLayout.addTab(mTabLayout.newTab().setText("tb_6"));

    }

    @Override
    protected void initAction() {
        viewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(viewPager);//和viewpager关联
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE); //设置可以滑动

    }
}

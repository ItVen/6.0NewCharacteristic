package com.loacl.ucloud.myrxjavademo.toolbar;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.loacl.base.BaseActivity;
import com.loacl.ucloud.myrxjavademo.R;
import com.loacl.ucloud.myrxjavademo.adapter.ViewPageAdapter;
import com.loacl.ucloud.myrxjavademo.fragment.Fragment_4;
import com.loacl.ucloud.myrxjavademo.fragment.Fragment_5;

/**
 * Created by j on 2017/2/22.
 */

public class ToolTableAct extends BaseActivity {
    TabLayout layout;
    ViewPager view;
    Fragment_4 fragmentTwo;
    Fragment_5 fragmentThree;
    @Override
    public int getLayoutId() {
        return R.layout.layout_tabletool;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        layout = (TabLayout) findViewById(R.id.tablayout);
        view = (ViewPager) findViewById(R.id.viewpager);
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initData() {
        fragmentTwo= Fragment_4.newInstance();
        fragmentThree= Fragment_5.newInstance();
        ViewPageAdapter viewPageAdapter =  new ViewPageAdapter(getSupportFragmentManager());

        viewPageAdapter.addFragment(fragmentTwo, "tab1");
        viewPageAdapter.addFragment(fragmentThree, "tab2");
        view.setAdapter(viewPageAdapter);
        layout.addTab(layout.newTab().setText("tab1"));
        layout.addTab(layout.newTab().setText("tab2"));
        layout.setupWithViewPager(view);//和viewpager关联
        //设置可以滑动
        layout.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

    @Override
    protected void initAction() {

    }
}

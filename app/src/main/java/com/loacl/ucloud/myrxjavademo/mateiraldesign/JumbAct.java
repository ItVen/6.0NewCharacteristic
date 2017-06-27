package com.loacl.ucloud.myrxjavademo.mateiraldesign;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.KeyEvent;

import com.loacl.base.BaseActivity;
import com.loacl.ucloud.myrxjavademo.R;

/**
 * Created by j on 2017/2/20.
 * 跳转测试页面
 */

public class JumbAct extends BaseActivity {
    final String TAG="JumbAct";
    CardView view;
    @Override
    public int getLayoutId() {
        return R.layout.layout_jumb_animation;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        view= (CardView) findViewById(R.id.share_view);
        ViewCompat.setTransitionName(view, "share");
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            Log.i(TAG,"back");
            this.finishAfterTransition();
        }
        return super.onKeyDown(keyCode, event);
    }
}

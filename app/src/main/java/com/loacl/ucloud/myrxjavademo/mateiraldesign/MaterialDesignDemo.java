package com.loacl.ucloud.myrxjavademo.mateiraldesign;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.transition.Explode;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.loacl.base.BaseActivity;
import com.loacl.ucloud.myrxjavademo.MainActivity;
import com.loacl.ucloud.myrxjavademo.R;
import com.loacl.ucloud.myrxjavademo.design.DesignList;

import java.util.concurrent.TimeUnit;

import rx.functions.Action1;

/**
 * Created by ellen on 2017/2/15.
 * 测试Material Design
 *
 */

public class MaterialDesignDemo extends BaseActivity {
    private final String TAG="MaterialDesignDemo";
    Button showBottom;
    FloatingActionButton floatbtn;
    Button appBar;
    NavigationView nView;
    @Override
    public int getLayoutId() {
        return R.layout.layout_materila;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        showBottom= (Button) findViewById(R.id.showsheetdailg);
        floatbtn= (FloatingActionButton) findViewById(R.id.fab);
        appBar= (Button) findViewById(R.id.to_appbar);
        nView = (NavigationView) findViewById(R.id.my_navigation_view);
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initAction() {
        RxView.clicks(appBar)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        Log.i(TAG,"to Appbar Page");
                        getWindow().setExitTransition(new Explode());
                        Intent intent= new Intent(MaterialDesignDemo.this,AppBarLayout.class);
                        startActivity(intent,
                                ActivityOptions
                                        .makeSceneTransitionAnimation(MaterialDesignDemo.this).toBundle());
                    }
                });

        RxView.clicks(showBottom)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        Log.i(TAG,"show bottom sheet dilog");
                    }
                });
        RxView.clicks(floatbtn)
                .throttleFirst(500,  TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void aVoid) {
                        Log.i(TAG,"clik floatbtn");
                        Snackbar.make(floatbtn," Hello I'm Snackbar",Snackbar.LENGTH_LONG)
                                .setAction("cancel",new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        //这里的单击事件代表点击消除Action后的响应事件
                                        Log.i(TAG,"clik cancel");

                                    }
                                })
                                .show();
                    }
                });
    }

    public void toAnimation(View view){
        getWindow().setExitTransition(new Explode());
        Intent intent= new Intent(this,AnimationAct.class);
        startActivity(intent,  ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    public void NavigationDrawer(View view){
        Log.i(TAG,"Navigation");
        nView.showContextMenu();
    }
    public void toDesign(View view){
        Intent intent= new Intent(this,DesignList.class);
        startActivity(intent);
    }
    public void toBottomSheet(View view){
        Intent intent= new Intent(this,BottomSheetBehaviorDemo.class);
        startActivity(intent);
    }


}

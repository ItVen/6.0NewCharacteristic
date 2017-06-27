package com.loacl.ucloud.myrxjavademo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Fade;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.loacl.base.BaseActivity;
import com.loacl.other.demo.TestAidlAct;
import com.loacl.ucloud.myrxjavademo.alipay.AliHome;
import com.loacl.ucloud.myrxjavademo.mateiraldesign.JumbAct;
import com.loacl.ucloud.myrxjavademo.mateiraldesign.MaterialDesignDemo;
import com.loacl.ucloud.myrxjavademo.toolbar.ToolTableAct;
import com.loacl.ucloud.myrxjavademo.toolbar.ToolbarTestAct;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action1;
/***
 * 所有测试的总入口
 *
 * */

public class MainActivity extends BaseActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        btn= (Button) findViewById(R.id.to_materila);
    }

    @Override
    protected void initToolBar() {

    }

    @Override
    protected void initData() {
        RxDemo();
    }

    @Override
    protected void initAction() {
        toMaterila();
    }

    /*
    * RxJava测试
    * */
    private void RxDemo(){
        Observable.just("Hello, world!")
//                .map(new Func1<String, Integer>() {
//                    //转码成hashCode int类型
//                    @Override
//                    public Integer call(String s) {
//                        return s.hashCode();
//                    }
//                })
//                .map(new Func1<Integer, String>() {
//                    @Override
//                    public String call(Integer integer) {
//                        //int类型转码成String类型
//                        return ""+integer+"-";
//                    }
//                })
                .subscribe(new Action1<String>() {

                    @Override
                    public void call(String s) {
                        Log.i("MainActivity",s);
                    }
                });
    }

    private void toMaterila(){
        RxView.clicks(btn)
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                .subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                //跳转事件监听
                Intent intent= new Intent(MainActivity.this,MaterialDesignDemo.class);
                startActivity(intent);
                Log.i("MainActivity","clicks");
            }
        });
    }

    public void ToToolbar(View view){
        getWindow().setEnterTransition(new Fade().setDuration(2000));
        getWindow().setExitTransition(new Fade().setDuration(2000));
        Intent intent = new Intent(this, ToolbarTestAct.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void ToToolTable(View view){
        getWindow().setEnterTransition(new Fade().setDuration(2000));
        getWindow().setExitTransition(new Fade().setDuration(2000));
        Intent intent = new Intent(this, ToolTableAct.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    public void onConstraint(View view){
        Intent intent =  new Intent(this,ConstraintAct.class);
        startActivity(intent);
    }

    public void onLayout(View view){
        Intent intent =  new Intent(this,Optimization.class);
        startActivity(intent);
    }
    public void  ToAlipay(View view){
        Intent intent =  new Intent(this,AliHome.class);
        startActivity(intent);
    }
    public void toAidl(View view){
        Intent intent =  new Intent(this,TestAidlAct.class);
        startActivity(intent);
    }

}

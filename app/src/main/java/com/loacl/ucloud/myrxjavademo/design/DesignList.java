package com.loacl.ucloud.myrxjavademo.design;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.loacl.ucloud.myrxjavademo.R;

/**
 * Created by ellen on 2017/2/28.
 */

public class DesignList extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_design_list);
    }

    public void ToAnimationUtil(View view) {
        Intent intent = new Intent (this,AnimationUtilsDemo.class);
        startActivity(intent);
    }


}

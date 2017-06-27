package com.loacl.ucloud.myrxjavademo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loacl.ucloud.myrxjavademo.R;

/**
 * Created by j on 2017/2/16.
 */

public class Fragment_5 extends Fragment {
    private static Fragment_5 instance=null;
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;

    public static Fragment_5 newInstance() {
        if(instance==null){
            instance= new Fragment_5();
        }
        return instance;
    }
    private Fragment_5(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        TextView mTextView = (TextView) view.findViewById(R.id.text);
        mTextView.setText("这是第5个Fragment");
        return view;
    }
}

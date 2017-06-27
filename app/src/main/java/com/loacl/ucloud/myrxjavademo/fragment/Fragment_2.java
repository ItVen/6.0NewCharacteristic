package com.loacl.ucloud.myrxjavademo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loacl.ucloud.myrxjavademo.R;
import com.loacl.ucloud.myrxjavademo.adapter.MyRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 2017/2/16.
 */

public class Fragment_2 extends Fragment {
    private static Fragment_2 instance=null;
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;
    RecyclerView recyclerView;
    MyRecyclerAdapter myRecyclerAdapter;
    private List<String> datas;

    public static Fragment_2 newInstance() {
        if(instance==null){
            instance= new Fragment_2();
        }
        return instance;
    }
    private Fragment_2(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        TextView mTextView = (TextView) view.findViewById(R.id.text);
        mTextView.setText("这是第2个Fragment");
        return view;
    }
}

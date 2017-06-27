package com.loacl.ucloud.myrxjavademo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.loacl.ucloud.myrxjavademo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by j on 2017/2/16.
 */

public class RecycleAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> datas;
    private Context context;
//    private List<Integer> lists;

    public RecycleAdapter(Context context, List<String> datas) {
        this.datas = datas;
        this.context = context;
//        getRandomHeights(datas);
    }

//    private void getRandomHeights(List<String> datas) {
//        lists = new ArrayList<>();
//        for (int i = 0; i < datas.size(); i++) {
//            lists.add((int) (200 + Math.random() * 400));
//        }
//    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycle, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        params.height = 100;//把随机的高度赋予item布局
        holder.itemView.setLayoutParams(params);
        holder.mTextView.setText(position+"");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView mTextView;
    public MyViewHolder(View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.item);
    }
}
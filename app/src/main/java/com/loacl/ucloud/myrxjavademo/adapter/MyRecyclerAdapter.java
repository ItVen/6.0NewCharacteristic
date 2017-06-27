
package com.loacl.ucloud.myrxjavademo.adapter;

import java.util.List;


import android.animation.Animator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;

import com.loacl.ucloud.myrxjavademo.R;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.MyViewHolder> {
	private static Context mcontext;
	private List<String> datas;
	private LayoutInflater mInflater;
	private RecyclerView mRecyclerView = null;

	public MyRecyclerAdapter(Context context, List<String> datas, RecyclerView mRecyclerView) {
		mInflater = LayoutInflater.from(context);
		mcontext = context;
		this.datas = datas;
		this.mRecyclerView = mRecyclerView;
	}

	@Override
	public int getItemCount() {
		return datas.size();
	}


	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
		View view = mInflater.inflate(R.layout.item_frame_3, viewGroup, false);
		MyViewHolder viewHolder = new MyViewHolder(view);
		viewHolder.view =  view.findViewById(R.id.item);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(final MyViewHolder viewHolder, final int position) {
		ViewGroup.LayoutParams params = viewHolder.itemView.getLayoutParams();
		params.height = 100;//把随机的高度赋予item布局
		viewHolder.itemView.setLayoutParams(params);
//		int cx = (viewHolder.view.getLeft() + viewHolder.view.getRight()) / 2;
//		int cy = (viewHolder.view.getTop() + viewHolder.view.getBottom()) / 2;
//
//		int finalRadius = Math.max(viewHolder.view.getWidth(), viewHolder.view.getHeight());
//		Animator anim = ViewAnimationUtils.createCircularReveal(viewHolder.view, cx, cy, 0, finalRadius);
//		viewHolder.view.setVisibility(View.VISIBLE);
//		anim.start();
	}

	public static class MyViewHolder extends RecyclerView.ViewHolder {

		public MyViewHolder(View itemView) {
			super(itemView);
		}

		View view;

	}
}

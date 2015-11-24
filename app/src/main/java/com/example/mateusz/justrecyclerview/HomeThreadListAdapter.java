package com.example.mateusz.justrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomeThreadListAdapter extends BaseRecyclerAdapter<MyItem, MyViewHolder> {

    private final Context mContext;

    public HomeThreadListAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View threadView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_item, parent, false);
        return new MyViewHolder(threadView, mContext);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(mItems, position);
    }
}
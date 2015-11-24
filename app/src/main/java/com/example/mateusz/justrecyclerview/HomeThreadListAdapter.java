package com.example.mateusz.justrecyclerview;

import android.content.Context;
import android.view.ViewGroup;

public class HomeThreadListAdapter extends BaseRecyclerAdapter<MyItem, MyViewHolder> {

    private final Context mContext;

    public HomeThreadListAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(mItems, position);
    }
}
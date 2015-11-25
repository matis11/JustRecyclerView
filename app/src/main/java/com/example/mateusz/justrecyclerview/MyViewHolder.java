package com.example.mateusz.justrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MyViewHolder extends RecyclerView.ViewHolder{
    private final TextView titleView;
    private final TextView contentView;

    public MyViewHolder(View itemView, Context context) {
        super(itemView);

        titleView = (TextView) itemView.findViewById(R.id.title);
        contentView = (TextView) itemView.findViewById(R.id.content);
    }

    public void bind(ArrayList<MyItem> dataSet, int position) {
        titleView.setText(dataSet.get(position).getTitle());
        contentView.setText(dataSet.get(position).getContent());
    }
}

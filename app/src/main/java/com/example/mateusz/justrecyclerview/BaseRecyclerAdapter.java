package com.example.mateusz.justrecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<ItemT, ViewHolderT extends ViewHolder> extends Adapter<ViewHolderT> {

    protected LayoutInflater mInflater;

    protected ArrayList<ItemT> mItems = new ArrayList<>();

    public BaseRecyclerAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public ItemT getItem(int position) {
        return mItems.get(position);
    }

    public void addItem(ItemT item) {
        addItem(mItems.size(), item);
    }

    public void addItem(int position, ItemT item) {
        mItems.add(position, item);
        notifyItemInserted(position);
    }

    public void addAllItems(List<ItemT> items) {
        int startPosition = mItems.size();
        mItems.addAll(items);
        notifyItemRangeInserted(startPosition, items.size());
    }

    public void replaceItems(List<ItemT> items) {
        if (!mItems.equals(items)) {
            mItems.clear();
            mItems.addAll(items);
            notifyDataSetChanged();
        }
    }

    public int getPosition(ItemT item) {
        return mItems.indexOf(item);
    }

    public int getSize() {
        return mItems.size();
    }

    public void clearItems() {
        mItems.clear();
        notifyDataSetChanged();
    }

    public void removeItem(int position) {
        ItemT item = mItems.get(position);
        mItems.remove(item);
        notifyItemRemoved(position);
    }

    public ArrayList<ItemT> getItems() {
        return mItems;
    }

    public boolean isEmpty() {
        return mItems.isEmpty();
    }

    public boolean isItemEnabled(int position) {
        return true;
    }
}
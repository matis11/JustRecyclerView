package com.example.mateusz.justrecyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;

public class FixedGridLayoutManager extends GridLayoutManager {

    private int mItemHeight;

    public FixedGridLayoutManager(Context context, int spanCount) {
        super(context, spanCount);
        Resources res = context.getResources();
        mItemHeight = res.getDisplayMetrics().widthPixels / spanCount;
    }

    @Override
    public int getMinimumHeight() {
        return getRowNumber() * mItemHeight;
    }

    private int getRowNumber() {
        double spanCount = getSpanCount() * 1.00;
        return (int) Math.ceil(getItemCount() / spanCount);
    }
}
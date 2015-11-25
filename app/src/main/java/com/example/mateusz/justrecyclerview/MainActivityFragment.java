package com.example.mateusz.justrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class MainActivityFragment extends BaseRecyclerFragment<HomeThreadListAdapter> {

    public static final String TAG = "Basic Tag";

    public MainActivityFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Override
    protected int getRecyclerViewId() {
        return R.id.recycler_view;
    }

    @Override
    protected HomeThreadListAdapter getAdapter() {
        return new HomeThreadListAdapter(getContext());
    }

    @Override
    protected void onItemClick(View view, int position) {
        Log.d(TAG, "onItemClick() called with: " + "view = [" + view + "], position = [" + position + "]");
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new FixedGridLayoutManager(getActivity(), 1);
    }
}

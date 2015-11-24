package com.example.mateusz.justrecyclerview;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivityFragment extends BaseRecyclerFragment<HomeThreadListAdapter> {

    public static final String TAG = "Basic Tag";

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
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
        return new FixedGridLayoutManager(getActivity(), 5);
    }
}

package com.example.mateusz.justrecyclerview;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivityFragment extends BaseRecyclerFragment<HomeThreadListAdapter> {

    public static final String TAG = "Basic Tag";

    public MainActivityFragment() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        mRecyclerView.setHasFixedSize(true);

//        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
//            @Override
//            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
//                int action = e.getAction();
//                switch (action) {
//                    case MotionEvent.ACTION_MOVE:
//                        rv.getParent().getParent().requestDisallowInterceptTouchEvent(true);
//                        break;
//                }
//                return false;
//            }
//
//            @Override
//            public void onTouchEvent(RecyclerView rv, MotionEvent e) {
//
//            }
//
//            @Override
//            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
//
//            }
//        });
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
        return new MyLinearLayoutManager(getActivity());
//        return new FixedGridLayoutManager(getActivity(), 1);
    }
}

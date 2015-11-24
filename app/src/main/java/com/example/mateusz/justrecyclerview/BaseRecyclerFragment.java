package com.example.mateusz.justrecyclerview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseRecyclerFragment<T extends BaseRecyclerAdapter> extends Fragment
        implements OnItemTouchListener {

    protected RecyclerView mRecyclerView;
    protected T mAdapter;

    private SimpleOnGestureListener mDetector = new SimpleOnGestureListener() {

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            View v = mRecyclerView.findChildViewUnder(e.getX(), e.getY());
            int position = mRecyclerView.getChildPosition(v);
            if (isAdded() && !isRemoving() && position != RecyclerView.NO_POSITION
                    && mAdapter.isItemEnabled(position)) {
                onItemClick(v, position);
            }
            return super.onSingleTapConfirmed(e);
        }

    };

    private GestureDetectorCompat mGestureDetector;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAdapter = getAdapter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(getLayoutId(), container, false);
        mGestureDetector = new GestureDetectorCompat(getActivity(), mDetector);
        mRecyclerView = (RecyclerView) view.findViewById(getRecyclerViewId());
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.addOnItemTouchListener(this);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        if (isAdded() && !isRemoving()) {
            mGestureDetector.onTouchEvent(e);
            return false;
        }

        return true;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        // nop
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        // nop
    }

    protected abstract int getLayoutId();

    protected abstract int getRecyclerViewId();

    protected abstract T getAdapter();

    protected abstract void onItemClick(View view, int position);

    protected abstract RecyclerView.LayoutManager getLayoutManager();

}

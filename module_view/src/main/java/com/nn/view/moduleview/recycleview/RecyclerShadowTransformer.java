package com.nn.view.moduleview.recycleview;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.Log;

import com.nn.view.moduleview.pagerview.ICardAdapter;


public class RecyclerShadowTransformer implements RecyclerViewPageChangeListenerHelper.OnPageChangeListener {
    private static final String TAG = "RecyclerShadow";
    private RecyclerView mRecyclerView;
    private ICardAdapter mAdapter;
    private float mLastOffset;
    private boolean mScalingEnabled;

    public RecyclerShadowTransformer(RecyclerView recyclerView, SnapHelper snapHelper, ICardAdapter adapter) {
        mRecyclerView = recyclerView;
        mRecyclerView.addOnScrollListener(new RecyclerViewPageChangeListenerHelper(snapHelper, this));
        mAdapter = adapter;
    }

    public void enableScaling(boolean enable) {
        Log.i(TAG, "******"+mRecyclerView.getItemDecorationCount());
        CardView currentCard = mAdapter.getCardViewAt(mRecyclerView.getItemDecorationCount());
        if (mScalingEnabled && !enable) {
            // 缩小
            if (currentCard != null) {
                currentCard.animate().scaleY(1.0f);
                currentCard.animate().scaleX(1.0f);
            }
        } else if (!mScalingEnabled && enable) {
            // 放大
            if (currentCard != null) {
                currentCard.animate().scaleY(1.1f);
                currentCard.animate().scaleX(1.1f);
            }
        }

        mScalingEnabled = enable;
    }

    /**
     * bug 162402 临时解决方案，主动放大
     */
    public void scaling(boolean enable) {
        CardView currentCard = mAdapter.getCardViewAt(mRecyclerView.getItemDecorationCount());
        if (currentCard != null && enable) {
            currentCard.animate().scaleY(1.1f).setDuration(0);
            currentCard.animate().scaleX(1.1f).setDuration(0);
        }
    }


    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

    }

    @Override
    public void onPageScrolled(int position, int dx, int dy) {
        int realCurrentPosition;
        int nextPosition;
        float realOffset;
        boolean goingLeft = mLastOffset > dx;
        // If we're going backwards, onPageScrolled receives the last position
        // instead of the current one
        if (goingLeft) {
            realCurrentPosition = position + 1;
            nextPosition = position;
            realOffset = 1 - dx;
        } else {
            nextPosition = position + 1;
            realCurrentPosition = position;
            realOffset = dx;
        }

        // Avoid crash on overscroll
        if (nextPosition > mAdapter.getCount() - 1
                || realCurrentPosition > mAdapter.getCount() - 1) {
            return;
        }

        Log.i(TAG,"******realCurrentPosition="+realCurrentPosition);
        CardView currentCard = mAdapter.getCardViewAt(realCurrentPosition);

        // This might be null if a fragment is being used
        // and the views weren't created yet
        if (currentCard != null) {
            if (mScalingEnabled) {
                currentCard.setScaleX((float)1.1);
                currentCard.setScaleY((float)1.1);
            }
        }

        CardView nextCard = mAdapter.getCardViewAt(nextPosition);

        // We might be scrolling fast enough so that the next (or previous) card
        // was already destroyed or a fragment might not have been created yet
        if (nextCard != null) {
            if (mScalingEnabled) {
                nextCard.setScaleX((float)1.0);
                nextCard.setScaleY((float)1.0);
            }
        }
        mLastOffset = dx;
    }

    @Override
    public void onPageSelected(int position) {

    }
}

package com.nn.view.moduleview.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * ProjectName:ViewProject
 * PackageName:com.nn.view.moduleview.widget
 * Description:
 * <p>
 * CreateTime:2019/4/3
 * Modifier:yangnana
 * ModifyTime:2019/4/3
 *
 * @author yangnana
 */
public class ViewPagerRecyclerView extends RecyclerView {

    private static final String TAG = "ViewPagerRecyclerView";

    public ViewPagerRecyclerView(Context context) {
        super(context);
        init();
    }

    public ViewPagerRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private int position = 0;

    private void init() {
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        this.setLayoutManager(llm);
        SnapHelper snapHelper = new PagerSnapHelper();
        //一次可滑动多个
        //SnapHelper snapHelper = new LinearSnapHelper();
        //居中显示RecyclerView
        snapHelper.attachToRecyclerView(this);
        this.addItemDecoration(new DividerItemDecoration(this.getContext(), DividerItemDecoration.HORIZONTAL));
        this.addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof LinearLayoutManager) {
                    int firs = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
                    if (position != firs) {
                        position = firs;
                        if (onpagerChageListener != null) {
                            onpagerChageListener.onPagerChage(position);
                        }
                    }
                }
            }
        });
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //事件不传递给父布局
        this.requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(ev);
    }

    public void setOnPagerPosition(int position) {
        //        this.position = position;
        RecyclerView.LayoutManager layoutManager = this.getLayoutManager();
        layoutManager.scrollToPosition(position);

    }

    public int getOnPagerPosition() {
        RecyclerView.LayoutManager layoutManager = this.getLayoutManager();
        return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
    }


    public interface onPagerChageListener {
        void onPagerChage(int position);
    }

    private onPagerChageListener onpagerChageListener;

    public void setOnPagerChageListener(onPagerChageListener onpagerChageListener) {
        this.onpagerChageListener = onpagerChageListener;
    }
}

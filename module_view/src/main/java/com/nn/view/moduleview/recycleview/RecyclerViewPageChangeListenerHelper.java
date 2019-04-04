package com.nn.view.moduleview.recycleview;

import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;

/**
 * ProjectName:ViewProject
 * PackageName:com.nn.view.moduleview.recycleview
 * Description:
 * <p>
 * CreateTime:2019/4/3
 * Modifier:yangnana
 * ModifyTime:2019/4/3
 *
 * @author yangnana
 */
public class RecyclerViewPageChangeListenerHelper extends RecyclerView.OnScrollListener {
    private SnapHelper snapHelper;
    private OnPageChangeListener onPageChangeListener;
    private int oldPosition = -1;//防止同一Position多次触发

    public RecyclerViewPageChangeListenerHelper(SnapHelper snapHelper, OnPageChangeListener onPageChangeListener) {
        this.snapHelper = snapHelper;
        this.onPageChangeListener = onPageChangeListener;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if(onPageChangeListener==null){
            return;
        }

        // if (recyclerView.getChildCount() == 0) {
        //     if (this.mFirstLayout) {
        //         return ;
        //     } else {
        //         this.mCalledSuper = false;
        //         onPageChangeListener.onPageScrolled(recyclerView.getItemDecorationCount(), 0, 0);
        //         if (!this.mCalledSuper) {
        //             throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        //         } else {
        //             return ;
        //         }
        //     }
        // } else {
        //     ViewPager.ItemInfo ii = this.infoForCurrentScrollPosition();
        //     int width = this.getClientWidth(recyclerView.getLayoutManager());
        //     int widthWithMargin = width + this.mPageMargin;
        //     float marginOffset = (float) this.mPageMargin / (float) width;
        //     int currentPage = recyclerView;
        //     float pageOffset = ((float) xpos / (float) width - ii.offset) / (ii.widthFactor + marginOffset);
        //     int offsetPixels = (int) (pageOffset * (float) widthWithMargin);
        //     this.mCalledSuper = false;
        //     onPageChangeListener.onPageScrolled(recyclerView.getItemDecorationCount(), pageOffset, offsetPixels);
        //     if (!this.mCalledSuper) {
        //         throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        //     } else {
        //         return ;
        //     }
        // }

        onPageChangeListener.onPageScrolled(recyclerView.getItemDecorationCount(), dx, dy);
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        int position = 0;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        //获取当前选中的itemView
        View view = snapHelper.findSnapView(layoutManager);
        if (view != null) {
            //获取itemView的position
            position = layoutManager.getPosition(view);
        }
        if (onPageChangeListener != null) {
            onPageChangeListener.onScrollStateChanged(recyclerView, newState);
            //newState == RecyclerView.SCROLL_STATE_IDLE 当滚动停止时触发防止在滚动过程中不停触发
            if (newState == RecyclerView.SCROLL_STATE_IDLE && oldPosition != position) {
                oldPosition = position;
                onPageChangeListener.onPageSelected(position);
            }
        }
    }

    private int getClientWidth(RecyclerView.LayoutManager layoutManager) {

        OrientationHelper mHorizontalHelper = OrientationHelper.createHorizontalHelper(layoutManager);
        return mHorizontalHelper.getTotalSpace() - mHorizontalHelper.getStartAfterPadding() - mHorizontalHelper.getEndAfterPadding();
    }


    public interface OnPageChangeListener {
        void onScrollStateChanged(RecyclerView recyclerView, int newState);

        void onScrolled(RecyclerView recyclerView, int dx, int dy);

        void onPageScrolled(int position, int dx, int dy);

        void onPageSelected(int position);
    }

}

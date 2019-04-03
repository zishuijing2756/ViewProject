package com.nn.view.moduleview.pagerview;


import android.support.v7.widget.CardView;

public interface ICardAdapter {

    /**
     * 获取指定位置card
     */
    CardView getCardViewAt(int position);

    /**
     * 获取card总数
     */
    int getCount();
}

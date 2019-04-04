package com.nn.view.moduleview.servicelist.adapter;


import android.support.v7.widget.CardView;

public interface ICardAdapter {

    /**
     * 获取指定位置card
     * @param position
     * @return
     */
    CardView getCardViewAt(int position);

    /**
     * 获取card总数
     * @return
     */
    int getCount();
}

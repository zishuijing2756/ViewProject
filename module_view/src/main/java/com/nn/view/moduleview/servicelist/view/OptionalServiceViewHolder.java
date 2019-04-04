package com.nn.view.moduleview.servicelist.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;

import com.nn.view.moduleview.R;
import com.nn.view.moduleview.servicelist.entity.OptionalServiceInfo;

/**
 * <p>
 * CreateTime:2019/4/1
 * Modifier:yangnana
 * ModifyTime:2019/4/1
 *
 * @author yangnana
 */
public class OptionalServiceViewHolder extends BaseViewHolder<OptionalServiceInfo> {

    private static final String TAG = "OptionalServiceViewHolder";
    private CardView mCardView;

    public OptionalServiceViewHolder(View itemView ) {
        super(itemView);
        //TODO 初始化基础组件
        mCardView=itemView.findViewById(R.id.m_guild_service_item_optinal_cardview);


    }


    @Override
    public void bindView(Context context, OptionalServiceInfo entity) {
        //TODO 设置组件的信息
    }

    @Override
    public CardView getCardView() {
        return mCardView;
    }
}

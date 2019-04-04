package com.nn.view.moduleview.servicelist.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;

import com.guahao.android.wyt.guide.R;
import com.guahao.android.wyt.guide.servicelist.entity.OngoingSimilarServiceInfo;

/**
 * ProjectName:wytmodultguide
 * PackageName:com.guahao.android.wyt.guide.servicelist.view
 * Description:
 * <p>
 * CreateTime:2019/4/1
 * Modifier:yangnana
 * ModifyTime:2019/4/1
 *
 * @author yangnana
 */
public class OngoingSimilarServiceViewHolder extends BaseViewHolder<OngoingSimilarServiceInfo> {
    private static final String TAG = "OngoingSimilarServiceViewHolder";
    private CardView mCardView;

    public OngoingSimilarServiceViewHolder(View itemView) {
        super(itemView);
        //TODO 初始化基础组件
        mCardView=itemView.findViewById(R.id.m_guild_service_item_ongoing_similar_cardview);

    }

    @Override
    public void bindView(Context context, OngoingSimilarServiceInfo entity) {
    }

    @Override
    public CardView getCardView() {
        return mCardView;
    }
}

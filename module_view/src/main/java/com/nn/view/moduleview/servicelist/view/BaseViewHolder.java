package com.nn.view.moduleview.servicelist.view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.View;

import com.nn.view.moduleview.servicelist.entity.BaseServiceInfo;

/**
 * ProjectName:wytmodultguide
 * PackageName:com.guahao.android.wyt.guide.view
 * Description:
 * <p>
 * CreateTime:2019/4/1
 * Modifier:yangnana
 * ModifyTime:2019/4/1
 *
 * @author yangnana
 */
public abstract class BaseViewHolder<T extends BaseServiceInfo> {

    private static final String TAG = "BaseViewHolder";

    public BaseViewHolder(View itemView) {
        //TODO 初始化基础组件

    }

    public abstract void bindView(Context context, T entity);

    public abstract CardView getCardView();
}

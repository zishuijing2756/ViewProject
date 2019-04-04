package com.nn.view.moduleview.recycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.nn.view.moduleview.R;

/**
 * ProjectName:ViewProject
 * PackageName:com.nn.view.module_view.recycleview.view
 * Description:
 * <p>
 * CreateTime:2019/4/1
 * Modifier:yangnana
 * ModifyTime:2019/4/1
 *
 * @author yangnana
 */
public class BaseViewHolder<T extends ServiceInfo> extends RecyclerView.ViewHolder {

    private TextView mTestTv;
    private CardView mCardView;

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        mTestTv=itemView.findViewById(R.id.m_test_tv);
        mCardView=itemView.findViewById(R.id.m_fragmen_recycle_item_cardview);
    }

    public  void setText(String serviceName){
        mTestTv.setText(serviceName);
    }

    public CardView getCardView(){
        return mCardView;
    }

}

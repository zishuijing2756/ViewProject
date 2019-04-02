package com.nn.view.moduleview.recycleview;

import android.support.annotation.NonNull;
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

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
        mTestTv=itemView.findViewById(R.id.m_test_tv);
    }

    public  void setText(String serviceName){
        mTestTv.setText(serviceName);
    }

}

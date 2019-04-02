package com.nn.view.moduleview.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nn.view.moduleview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName:ViewProject
 * PackageName:com.nn.view.module_view
 * Description:
 * <p>
 * CreateTime:2019/4/1
 * Modifier:yangnana
 * ModifyTime:2019/4/1
 *
 * @author yangnana
 */
public class RecycleViewAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<CardView> mCardViews;
    private List<ServiceInfo> mList=new ArrayList<>();


    public RecycleViewAdapter(Context context,List<ServiceInfo> list) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
        mList=list;
        initCardView();
    }

    private void initCardView() {

        if(mCardViews==null){
            mCardViews = new ArrayList<>();

        }
        mCardViews.clear();

        if(mList!=null){
            for (int i = 0; i < mList.size(); i++) {
                mCardViews.add(null);
            }
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new BaseViewHolder(mLayoutInflater.inflate(R.layout.m_recycleview_item, parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

       ServiceInfo serviceInfo= mList.get(i);
       if(viewHolder instanceof  BaseViewHolder){
           ((BaseViewHolder) viewHolder).setText(serviceInfo.serviceName);
       }


    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}

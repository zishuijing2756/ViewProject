package com.nn.view.moduleview.servicelist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nn.view.moduleview.R;
import com.nn.view.moduleview.servicelist.entity.BaseServiceInfo;
import com.nn.view.moduleview.servicelist.view.BaseViewHolder;
import com.nn.view.moduleview.servicelist.view.OngoingSimilarServiceViewHolder;
import com.nn.view.moduleview.servicelist.view.OptionalServiceViewHolder;
import com.nn.view.moduleview.servicelist.view.RestTimeServiceViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName:wytmodultguide
 * PackageName:com.guahao.android.wyt.guide.servicelist.adapter
 * Description: 选择服务页适配
 * <p>
 * CreateTime:2019/4/1
 * Modifier:yangnana
 * ModifyTime:2019/4/1
 *
 * @author yangnana
 */
public class ServiceInfoListAdapter extends PagerAdapter implements ICardAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private List<BaseServiceInfo> mList;
    private List<CardView> mCardViews;

    //可选择的服务类型
    private static final int TYPE_OPTIONAL = 0;
    //正在进行的同类服务类型
    private static final int TYPE_ONGOING_SIMILAR = 1;
    //不在服务时间的服务类型
    private static final int TYPE_REST_TIME = 2;


    public ServiceInfoListAdapter(Context context) {
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(List<BaseServiceInfo> list) {
        this.mList = list;
        initCardViews();
        notifyDataSetChanged();

    }

    private void initCardViews() {
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

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        BaseServiceInfo item = mList.get(position);
        View view;
        BaseViewHolder viewHolder;
        switch (item.type) {
            case TYPE_OPTIONAL:
                Log.i("ServiceInfoListAdapter","******instantiateItem->TYPE_OPTIONAL");
                view = mLayoutInflater.inflate(R.layout.m_service_info_item_optional, container, false);
                container.addView(view);

                viewHolder = new OptionalServiceViewHolder(view);
                break;
            case TYPE_ONGOING_SIMILAR:
                Log.i("ServiceInfoListAdapter","******instantiateItem->TYPE_ONGOING_SIMILAR");
                view = mLayoutInflater.inflate(R.layout.m_service_info_item_ongoing_similar, container, false);
                container.addView(view);

                viewHolder = new OngoingSimilarServiceViewHolder(view);
                break;
            case TYPE_REST_TIME:
            default:
                Log.i("ServiceInfoListAdapter","******instantiateItem->TYPE_REST_TIME");
                view = mLayoutInflater.inflate(R.layout.m_service_info_item_rest_time, container, false);
                container.addView(view);

                viewHolder = new RestTimeServiceViewHolder(view);
                break;
        }

        viewHolder.bindView(mContext, item);

        if (mCardViews!=null) {
            mCardViews.set(position, viewHolder.getCardView());
        }
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
        mCardViews.set(position, null);
    }

    @Override
    public CardView getCardViewAt(int position) {
        if (mCardViews!=null && position >= 0 && position < mCardViews.size()) {
            return mCardViews.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        if (mList!=null) {
            return mList.size();
        }
        return 0;
    }

}


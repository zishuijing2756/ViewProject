package com.nn.view.moduleview.tablayout.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nn.view.moduleview.R;
import com.nn.view.moduleview.tablayout.entity.TestInfo;

import java.util.List;

/**
 * ProjectName:ViewProject
 * PackageName:com.nn.view.moduleview.tablayout.adapter
 * Description:
 * <p>
 * CreateTime:2019/4/9
 * Modifier:yangnana
 * ModifyTime:2019/4/9
 *
 * @author yangnana
 */
public class MyViewPager extends PagerAdapter {

    private static final String TAG = "VideoServiceListAdapter";

    private Context mContext;
    private LayoutInflater mFactory;
    private List<TestInfo> mList;
    private List<String> mTitles;

    public MyViewPager(Context context, List<TestInfo> list, List<String> titles) {

        this.mContext = context;
        this.mList = list;
        this.mTitles = titles;
        mFactory = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (mList!=null) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = mFactory.inflate(R.layout.m_fragment_tablayout_page_content_item, container, false);

        try {
            if (view.getParent() == null) {
                container.addView(view, 0);
            } else {
                container.addView(view, position);
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (mTitles != null && mTitles.size() > 0 && position < mTitles.size()) {
            return mTitles.get(position);
        }
        return "";
    }

}

package com.nn.view.moduleview.tablayout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nn.view.moduleview.R;
import com.nn.view.moduleview.tablayout.adapter.MyViewPager;
import com.nn.view.moduleview.tablayout.entity.TestInfo;
import com.nn.view.moduleview.tablayout.widget.ImageIndicator;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * <p>
 * CreateTime:2019/4/4
 * Modifier:yangnana
 * ModifyTime:2019/4/4
 *
 * @author yangnana
 */
public class TabLayoutPageFragment extends Fragment {

    private static final String TAG = "TabLayoutPageFragment";
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MyViewPager mAdapter;
    private ImageIndicator imageIndicator;

    public static TabLayoutPageFragment getInstance() {
        TabLayoutPageFragment instance = new TabLayoutPageFragment();
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.m_fragment_tablayout_page, container, false);
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPager = view.findViewById(R.id.m_fragment_tablayout_page_vp);
        mTabLayout = view.findViewById(R.id.m_fragment_tablayout_page_tl);
        imageIndicator = view.findViewById(R.id.m_fragment_tablayout_page_tab_item_indicator);

        List<String> titles = new ArrayList<>();
        titles.add("TAB1");
        titles.add("TAB2");
        titles.add("TAB3");
        titles.add("TAB4");

        //测试数据
        List<TestInfo> mList = new ArrayList<>();
        mList.add(new TestInfo());
        mList.add(new TestInfo());
        mList.add(new TestInfo());
        mList.add(new TestInfo());

        mAdapter = new MyViewPager(getContext(), mList, titles);
        mViewPager.setOffscreenPageLimit(mList.size());
        mViewPager.setAdapter(mAdapter);
        mViewPager.setCurrentItem(0);

        //将tabLayout与viewPager关联起来
        mTabLayout.setupWithViewPager(mViewPager, false);
        imageIndicator.setupWithTabLayout(mTabLayout);


        for (int i = 0; i < titles.size(); i++) {
            mTabLayout.addTab(mTabLayout.newTab());
        }

        // TabLayoutUtil.dynamicSetTabLayoutMode(WYCoreUtils.getApp(), mTabLayout);

        setPageChangeListener();
        // setOnTabSelectedListener();
    }

    /**
     * 设置页面切换监听
     */
    private void setPageChangeListener() {

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout) {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                /*
                 * 将滑动偏移量传给Indicator
                 * 说明：positionOffset指的是滑动偏移量相对与父组件的百分比
                 */
                Log.i(TAG,"********onPageScrolled,position="+position+",positionOffset="+positionOffset);

                imageIndicator.setIndicatorPositionFromTabPosition(position, positionOffset);
            }

        });


    }

    /**
     * 设置Tab选择监听
     */
    private void setOnTabSelectedListener() {
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
}

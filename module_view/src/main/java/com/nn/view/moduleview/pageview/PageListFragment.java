package com.nn.view.moduleview.pageview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nn.view.moduleview.BaseFragment;
import com.nn.view.moduleview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName:ViewProject
 * PackageName:com.nn.view.moduleview.pageview
 * Description:
 * <p>
 * CreateTime:2019/4/2
 * Modifier:yangnana
 * ModifyTime:2019/4/2
 *
 * @author yangnana
 */
public class PageListFragment extends BaseFragment {
    private static final String TAG = "PageListFragment";
    private ViewPager mViewPager;
    private PageListAdapter mPageListAdapter;


    public static PageListFragment getInstance() {
        PageListFragment sInstance = new PageListFragment();
        return sInstance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"******onCreateView");

        //注，inflate的第二个参数必须设置成null，否则会出现view已被添加的问题
        return inflater.inflate(R.layout.m_fragment_page_list, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //TODO  初始化组件

        Log.i(TAG,"******onViewCreated");
        List<PageInfo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PageInfo pageInfo = new PageInfo();
            list.add(pageInfo);
        }

        mViewPager = bindView(R.id.m_fragment_container_vp);
        mPageListAdapter = new PageListAdapter(getContext(), list);

        ShadowTransformer shadowTransformer = new ShadowTransformer(mViewPager, mPageListAdapter);

        mViewPager.setAdapter(mPageListAdapter);
        mViewPager.setPageTransformer(false, shadowTransformer);
        shadowTransformer.enableScaling(true);

    }
}


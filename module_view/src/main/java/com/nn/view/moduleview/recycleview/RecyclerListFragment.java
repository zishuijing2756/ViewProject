package com.nn.view.moduleview.recycleview;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nn.view.moduleview.BaseFragment;
import com.nn.view.moduleview.R;
import com.nn.view.moduleview.pagerview.ShadowTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * ProjectName:ViewProject
 * PackageName:com.nn.view.module_view
 * Description:  使用PagerSnapHelper和RecycleView实现ViewPager的效果
 * <p>
 * CreateTime:2019/4/1
 * Modifier:yangnana
 * ModifyTime:2019/4/1
 *
 * @author yangnana
 */
public class RecyclerListFragment extends BaseFragment {

    private static final String TAG = "RecyclerListFragment";
    private RecyclerView mRecyclerView;
    private List<ServiceInfo> mList;
    private RecycleViewAdapter mAdapter;
    private ShadowTransformer mShadowTransformer;

    public static RecyclerListFragment getInstance() {
        RecyclerListFragment instance = new RecyclerListFragment();
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.m_fragment_recycleview_list, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            ServiceInfo serviceInfo = new ServiceInfo();
            serviceInfo.serviceName = "第" + i + "页";
            mList.add(serviceInfo);
        }

        mRecyclerView = bindView(R.id.m_list_container_rv);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);
        //实现ViewPager效果的代码,每次只能滑动一页
        // PagerSnapHelper snapHelper = new PagerSnapHelper();
        // snapHelper.attachToRecyclerView(mRecyclerView);

        //实现ViewPager效果的代码,可快速滑动多个条目
        LinearSnapHelper linearSnapHelper = new LinearSnapHelper();
        linearSnapHelper.attachToRecyclerView(mRecyclerView);

        mAdapter = new RecycleViewAdapter(getContext(), mList);
        mRecyclerView.setAdapter(mAdapter);

    }


}

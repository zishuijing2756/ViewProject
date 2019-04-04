package com.nn.view.moduleview.servicelist;

import android.content.Context;
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
import com.nn.view.moduleview.servicelist.adapter.ServiceInfoListAdapter;
import com.nn.view.moduleview.servicelist.entity.BaseServiceInfo;
import com.nn.view.moduleview.servicelist.entity.OngoingSimilarServiceInfo;
import com.nn.view.moduleview.servicelist.entity.OptionalServiceInfo;
import com.nn.view.moduleview.servicelist.entity.RestTimeServiceInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * CreateTime:2019/4/4
 * Modifier:yangnana
 * ModifyTime:2019/4/4
 *
 * @author yangnana
 */
public class ServiceListFragment extends BaseFragment {

    private static final String TAG = "ServiceListFragment";
    private ViewPager mViewPager;
    private ServiceInfoListAdapter mAdapter;

    public static ServiceListFragment getInstance() {
        ServiceListFragment sInstance = new ServiceListFragment();
        return sInstance;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.m_fragment_service_list, null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPager=bindView(R.id.m_guild_fragment_service_list_viewpager);

        Log.i(TAG,"******onViewCreated1");
        List<BaseServiceInfo> list=new ArrayList<>();
        OptionalServiceInfo i1=new OptionalServiceInfo();
        i1.type=0;
        list.add(i1);
        OngoingSimilarServiceInfo i2=new OngoingSimilarServiceInfo();
        i2.type=1;
        list.add(i2);
        RestTimeServiceInfo i3=new RestTimeServiceInfo();
        i3.type=2;
        list.add(i3);
        //
        mAdapter=new ServiceInfoListAdapter(getContext());
        mAdapter.setData(list);
        mViewPager.setAdapter(mAdapter);
        ShadowTransformer shadowTransformer=new ShadowTransformer(mViewPager,mAdapter);
        mViewPager.setPageTransformer(false,shadowTransformer);
        shadowTransformer.enableScaling(true);

    }
}

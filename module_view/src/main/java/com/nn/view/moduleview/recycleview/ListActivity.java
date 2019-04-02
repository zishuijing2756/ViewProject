package com.nn.view.moduleview.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nn.view.moduleview.R;
import com.nn.view.moduleview.pageview.ShadowTransformer;

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
public class ListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<ServiceInfo> mList;
    private RecycleViewAdapter mAdapter;
    private ShadowTransformer mShadowTransformer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_activity_list);

        mList=new ArrayList<>();

        for(int i=0;i<5 ;i++){
            ServiceInfo serviceInfo=new ServiceInfo();
            serviceInfo.serviceName="test"+i;
            mList.add(serviceInfo);
        }
        mRecyclerView=findViewById(R.id.m_list_container_rv);
        LinearLayoutManager manager=new LinearLayoutManager(getApplicationContext());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);
        mAdapter=new RecycleViewAdapter(getApplicationContext(),mList);
        mRecyclerView.setAdapter(mAdapter);
        // mShadowTransformer=new ShadowTransformer()
    }


}

package com.nn.view.moduleview;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.nn.view.moduleview.pagerview.PageListFragment;
import com.nn.view.moduleview.recycleview.RecyclerListFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private FrameLayout mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = findViewById(R.id.m_fragment_page_container_fl);
        //ViewPager实现水平分页
        // addPagerFragment();
        //RecyclerView实现水平滑动分页
        addRecyclerListFragment();
    }

    private void addPagerFragment() {
        mFragment.removeAllViews();

        FragmentManager mFragmentManager = getSupportFragmentManager();
        PageListFragment pageListFragment = PageListFragment.getInstance();

        Log.i(TAG, "******addPagerFragment");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.m_fragment_page_container_fl, pageListFragment, "PageListFragment");
        transaction.commit();

    }

    private void addRecyclerListFragment() {
        mFragment.removeAllViews();

        FragmentManager mFragmentManager = getSupportFragmentManager();
        RecyclerListFragment mRecyclerListFragment = RecyclerListFragment.getInstance();

        Log.i(TAG, "******addRecyclerListFragment");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.m_fragment_page_container_fl, mRecyclerListFragment, "RecyclerListFragment");
        transaction.commit();

    }

}

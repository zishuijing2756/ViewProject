package com.nn.view.moduleview;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.nn.view.moduleview.pageview.PageListFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private FrameLayout mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFragment = findViewById(R.id.m_fragment_page_container_fl);
        addFragment();
    }

    private void addFragment() {
        mFragment.removeAllViews();

        FragmentManager mFragmentManager = getSupportFragmentManager();
        PageListFragment pageListFragment = PageListFragment.getInstance();

        Log.i(TAG, "******addFragment1");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.m_fragment_page_container_fl, pageListFragment, "PageListFragment");
        transaction.commit();

    }

}

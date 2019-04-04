package com.nn.view.moduleview.servicelist;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.nn.view.moduleview.R;

/**
 * ProjectName:wytmodultguide
 * PackageName:com.guahao.android.wyt.guide.servicelist
 * Description:
 * <p>
 * CreateTime:2019/4/4
 * Modifier:yangnana
 * ModifyTime:2019/4/4
 *
 * @author yangnana
 */
public class ServiceTestActivity extends AppCompatActivity {

    private static final String TAG = "ServiceTestActivity";
    private FrameLayout mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m_activity_service_test);

        mFragment = findViewById(R.id.m_fragment_page_container_fl);
        addPagerFragment();
    }

    private void addPagerFragment() {
        mFragment.removeAllViews();

        FragmentManager mFragmentManager = getSupportFragmentManager();
        ServiceListFragment serviceListFragment = ServiceListFragment.getInstance();

        Log.i(TAG, "******addServiceListFragment");
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.replace(R.id.m_fragment_page_container_fl, serviceListFragment, "ServiceListFragment");
        transaction.commit();

    }


}

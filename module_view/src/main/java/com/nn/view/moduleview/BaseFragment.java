package com.nn.view.moduleview;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * ProjectName:ViewProject
 * PackageName:com.nn.view.moduleview
 * Description:
 * <p>
 * CreateTime:2019/4/2
 * Modifier:yangnana
 * ModifyTime:2019/4/2
 *
 * @author yangnana
 */
public class BaseFragment  extends Fragment {

    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectMembers();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews();
    }

    protected void injectMembers() {
        //空实现
    }

    protected void injectViews() {
        //空实现
    }


    protected <O extends Object> O bindExtra(String key,Boolean optional,O defaultVal){
        O result = null;
        if(getArguments() !=null){
            result = (O) getArguments().get(key);
        }
        return (optional && result == null) ? defaultVal : result;
    }

    protected <V extends View> V bindView(int id){
        return (V)getView().findViewById(id);
    }


}

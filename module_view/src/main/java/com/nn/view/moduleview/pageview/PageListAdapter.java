package com.nn.view.moduleview.pageview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
public class PageListAdapter extends PagerAdapter implements ICardAdapter {
    private Context mContext;
    private List<CardView> mCardViews = new ArrayList<>();
    private List<PageInfo> mList = new ArrayList<>();


    public PageListAdapter(Context context, List<PageInfo> list) {
        this.mContext = context;
        this.mList = list;

        initCardView();
        notifyDataSetChanged();
    }

    private void initCardView() {
        if (mCardViews == null) {
            mCardViews = new ArrayList<>();
        }
        mCardViews.clear();
        if (mList != null && mList.size() > 0) {
            for (int i = 0; i < mList.size(); i++) {
                mCardViews.add(null);
            }
        }
    }

    @Override
    public CardView getCardViewAt(int position) {
        if (mCardViews == null) {
            return null;
        }
        if (position > 0 && position < mCardViews.size()) {
            return mCardViews.get(position);
        }
        return null;
    }

    @Override
    public int getCount() {
        return mList.size();
    }
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.m_fragment_page_list_item, container,false);

        try {
            if(view.getParent()==null) {
                container.addView(view, 0);
            } else{
                // I am new to android, it is strange that the view to be added is already bound to a parent
                // Through trials and error I solve this problem with the following codes
                // Add that the element of mlistviews is listview in pagerview;
                ((ViewGroup) view.getParent()).removeView(view);

                container.addView(view, position);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TextView textView=view.findViewById(R.id.m_fragment_page_item_text_tv);
        textView.setText("测试"+position);
        CardView cardView = view.findViewById(R.id.m_fragmen_page_item_cardview);
        if (cardView != null) {
            mCardViews.set(position, cardView);
        }

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        mCardViews.set(position, null);
    }

}

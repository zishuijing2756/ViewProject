# ViewProject
RecycleView、PagerView 实现横向滑动卡片页面


一、RecyclerView 实现横向列表显示，无tab；
二、PagerView 实现横向列表显示，无tab；
三、TabLayout+ViewPager实现横向滑动页面加，tab；
主要实现了自定义图片滑动指示器的功能；
但是这个指示器目前还有一些问题，当tab较多，出现滑动的时候，指示器与tab会出现不对齐的情况
TabLayout的功能主要看tablayout3里面的功能：
里面自定义了SlidingTabLayout，继承自TabLayout，主要实现了自定义图片的功能。

使用：
1、配置文件
        <!--必须加上
            app:tabMaxWidth="200dp"
            app:tabMinWidth="20dp"这两个设置，padding才能生效-->
        <com.nn.view.moduleview.tablayout3.SlidingTabLayout3
            android:id="@+id/m_fragment_tablayout_page_tl"
            android:layout_width="match_parent"
            android:layout_height="60dp"
            app:tabIndicatorHeight="0dp"
            app:tabMaxWidth="200dp"
            app:tabMinWidth="20dp"
            app:tabMode="scrollable"
            app:tabPaddingEnd="10dp"
            app:tabPaddingStart="10dp"
            app:tabSelectedTextColor="#23CBD6"
            app:tabTextColor="#9AA5BB"/>
2、设置ViewPager的滑动监听，在onPageScrolled方法里面调用：
mTabLayout.setIndicatorPositionFromTabPosition(position, positionOffset);
   
    private void setPageChangeListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                /*
                 * 将滑动偏移量传给Indicator
                 * 说明：positionOffset指的是滑动偏移量相对与父组件的百分比
                 */
                Log.i(TAG, "********onPageScrolled,position=" + position + ",positionOffset=" + positionOffset);
                mTabLayout.setIndicatorPositionFromTabPosition(position, positionOffset);
            }
            @Override
            public void onPageSelected(int i) {
            }
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

    }
    
    3、如果要改变指示器的图片：
    SlidingTabLayout类里面有这个方法：
     public void setmSlideIcon(Bitmap mSlideIcon) {
        this.mSlideIcon = mSlideIcon;
    }
    调用这个方法设置图片即可；

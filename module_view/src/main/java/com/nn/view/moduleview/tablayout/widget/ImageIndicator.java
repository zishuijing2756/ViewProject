package com.nn.view.moduleview.tablayout.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.nn.view.moduleview.R;

import java.lang.reflect.Field;

/**
 * Description:自定义TabLayout图片指示器
 * <p>
 * CreateTime:2019/4/9
 * Modifier:yangnana
 * ModifyTime:2019/4/9
 *
 * @author yangnana
 */
public class ImageIndicator extends View {
    private static final String TAG = "ImageIndicator";

    public ImageIndicator(Context context) {
        super(context);
    }

    public ImageIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    private float mIndicatorLeft = -1;
    private int mIndicatorRight = -1;

    /**
     * 滑动的图片
     */
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.m_indicator);
    private Paint mSelectedIndicatorPaint = new Paint();

    int mSelectedPosition = -1;
    float mSelectionOffset;

    LinearLayout tab;
    TabLayout tabs;

    public void setIndicatorPositionFromTabPosition(int position, float positionOffset) {
        Log.i(TAG, "******setIndicatorPositionFromTabPosition,");
        mSelectedPosition = position;
        mSelectionOffset = positionOffset;
        updateIndicatorPosition();
    }


    public void setupWithTabLayout(TabLayout tabs) {
        Log.i(TAG, "******setupWithTabLayout");

        this.tabs = tabs;
        if (tab == null) {
            tab = getTabStrip();
        }
    }

    /**
     * 计算滑动杆位置
     */
    private void updateIndicatorPosition() {
        Log.i(TAG, "******updateIndicatorPosition");

        if (tab == null) {
            Log.i(TAG, "******updateIndicatorPosition--->tab==null");

            return;
        }
        Log.i(TAG, "******updateIndicatorPosition1");

        final View selectedTitle = tab.getChildAt(mSelectedPosition);
        int left, right;

        if (selectedTitle != null && selectedTitle.getWidth() > 0) {
            Log.i(TAG, "******updateIndicatorPosition2");

            left = selectedTitle.getLeft();
            right = selectedTitle.getRight();
            Log.i(TAG, "******selectedTitle->left=" + left + ",right=" + right);

            if (mSelectionOffset > 0f && mSelectedPosition < tab.getChildCount() - 1) {

                View nextTitle = tab.getChildAt(mSelectedPosition + 1);
                left = (int) (mSelectionOffset * nextTitle.getLeft() +
                        (1.0f - mSelectionOffset) * left);

                right = (int) (mSelectionOffset * nextTitle.getRight() +
                        (1.0f - mSelectionOffset) * right);

                Log.i(TAG, "******nextTitle->left=" + nextTitle.getLeft() + ",right=" + nextTitle.getRight());
            }
        } else {
            Log.i(TAG, "******updateIndicatorPosition3");

            left = right = -1;
        }

        setIndicatorPosition(left, right);
    }


    void setIndicatorPosition(int left, int right) {
        Log.i(TAG, "******setIndicatorPosition");

        if (left != mIndicatorLeft || right != mIndicatorRight) {
            Log.i(TAG, "******mIndicatorLeft=" + left + ",mIndicatorRight=" + right);
            Log.i(TAG, "******mIndicatorlength=" + (right - left));

            mIndicatorLeft = left;
            mIndicatorRight = right;
            /*通知view重绘*/
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*绘制图片*/
        if (mIndicatorLeft >= 0 && mIndicatorRight > mIndicatorLeft) {
            //绘制指示器
            Matrix matrix = new Matrix();
            //设置指示器的长度与tab文字长度相同
            matrix.postScale((mIndicatorRight - mIndicatorLeft) / mBitmap.getWidth(), 1);
            //平移指示器的x坐标，
            matrix.postTranslate(mIndicatorLeft, 0);

            canvas.drawBitmap(mBitmap, matrix, mSelectedIndicatorPaint);

        }
    }

    /**
     * tabs : TabLayout
     * 通过反射TabLayout拿到SlidingTabStrip这个内部类
     * TabLayout.SlidingTabIndicator slidingTabIndicator;
     */
    public LinearLayout getTabStrip() {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            //注：不同API版本，TabLayout内部类名字不一样，
            Log.i(TAG, "******getTabStrip1->sdk-int" + Build.VERSION.SDK_INT);
            int sdkVersion = getContext().getApplicationInfo().targetSdkVersion;
            if (sdkVersion >= Build.VERSION_CODES.P) {
                Log.i(TAG, "******getTabStrip1");

                tabStrip = tabLayout.getDeclaredField("slidingTabIndicator");
            } else {
                Log.i(TAG, "******getTabStrip2");

                tabStrip = tabLayout.getDeclaredField("mTabStrip");
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }


        try {
            if (tabStrip != null) {
                tabStrip.setAccessible(true);
                tab = (LinearLayout) tabStrip.get(tabs);
                return tab;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tab;
    }
}

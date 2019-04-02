package com.nn.view.moduleview;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class BaseAdapter<T, V extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<V> {

    protected List<T> mData;

    public BaseAdapter() {
    }

    public T getItem(int position) {
        if (mData == null || position >= mData.size() || position < 0) {
            return null;
        }
        return mData.get(position);
    }

    /**
     * 实体 t 在列表中的下标
     *
     * @param t
     * @return
     */
    public int indexOf(T t) {
        checkContainer();
        return mData.indexOf(t);
    }

    /**
     * 从数据源尾部加入数据
     *
     * @param t
     */
    public void addItem(T t) {
        checkContainer();
        if (t != null) {
            mData.add(t);
            final int newPos = getItemCount();
            notifyItemInserted(newPos);
        }
    }

    /**
     * 从数据源头部加入数据
     *
     * @param t
     */
    public void addFirst(T t) {
        checkContainer();
        if (t != null) {
            mData.add(0, t);
            notifyItemInserted(0);
        }
    }

    protected void checkContainer() {
        if (mData == null) {
            mData = new ArrayList<>();
        }
    }

    public void setData(List<T> data) {
        checkContainer();
        if (data != null) {
            mData.clear();
            mData.addAll(data);
        }
    }
    //加载更多调用
    public void addAll(Collection<T> list) {
        checkContainer();
        int lastIndex = this.mData.size();
        if (this.mData.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }
    public void clear() {
        if (mData!=null){
            mData.clear();
            notifyDataSetChanged();
        }
    }

    @Override
    public void onBindViewHolder(V holder, int position) {
    }

    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
}
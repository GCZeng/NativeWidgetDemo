package org.widget.adapter.base;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by Nick on 2017/4/12
 */
public abstract class MyBaseAdapter<T extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<T> {
    protected List data = null;

    protected abstract int providerItemLayout();

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    protected Object getData(int position) {
        return data == null ? null : data.get(position);
    }
}

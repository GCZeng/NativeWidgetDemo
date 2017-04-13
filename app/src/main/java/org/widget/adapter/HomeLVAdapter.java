package org.widget.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.widget.R;
import org.widget.adapter.base.MyBaseAdapter;
import org.widget.adapter.base.OnItemClickListener;
import org.widget.utils.TextUtil;
import org.widget.utils.ViewUtil;

import java.util.List;

/**
 * Created by Nick on 2017/4/12
 */
public class HomeLVAdapter extends MyBaseAdapter<HomeLVAdapter.MyViewHolder> implements View.OnClickListener {
    private OnItemClickListener mOnItemClickListener = null;

    public HomeLVAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    protected int providerItemLayout() {
        return R.layout.lv_home_item;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = ViewUtil.loadView(providerItemLayout(), parent);
        MyViewHolder holder = new MyViewHolder(view);

        view.setOnClickListener(this);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextUtil.setText(holder.tv_title, getData(position).toString());

        holder.itemView.setTag(position);
    }

    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title;

        public MyViewHolder(View view) {
            super(view);
            tv_title = (TextView) view.findViewById(R.id.tv_title);
        }
    }

    public void setmOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

}

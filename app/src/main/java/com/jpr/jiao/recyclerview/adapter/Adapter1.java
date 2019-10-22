package com.jpr.jiao.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jpr.jiao.R;

import java.util.Date;
import java.util.List;

/**
 * 类描述：
 * 创建日期：2019/9/30.
 * 作者：jiaopeirog
 */
public class Adapter1 extends RecyclerView.Adapter<Adapter1.ViewHolder> {
    private List<String> list;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_1, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.tv.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void setData(List<String> data) {
        this.list = data;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}

package com.dukang.wang.mycontrolview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dukang.wang.mycontrolview.R;
import com.dukang.wang.mycontrolview.bean.HomeListBean;


import java.util.List;

/**
 * @Author : wdk
 * @Email : a15939582085@126.com
 * created on : 2017/5/3 11:07
 * @Description :首页列表数据的adapter
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeViewHolder> {

    private List<HomeListBean> dataList;
    private LayoutInflater inflater;
    private Context context;

    public HomeAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<HomeListBean> dataList) {
        this.dataList = dataList;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_home_list, parent);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, final int position) {
        TextView view_name = (TextView) holder.itemView.findViewById(R.id.view_name);
        view_name.setText(dataList.get(position).getTitle());
        view_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }
}

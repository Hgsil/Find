package com.hgsil.find.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hgsil.find.R;
import com.hgsil.find.data.Information;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/21 0021.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder>{
    private List<Information> mData;
    private Context mContext;

    public void setData(List<Information> data) {
        mData = data;
    }

    public MainAdapter(List<Information> data, Context context) {
        mData = data;
        mContext = context;
    }

    public MainAdapter(Context context) {
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity_main_recycler,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mInformation = mData.get(position);
        holder.who.setText("发起人:"+holder.mInformation.getWho());
        holder.content.setText("详细描述: "+holder.mInformation.getInformation());
        holder.contact.setText("联系方式:"+holder.mInformation.getPhone());
    }

    @Override
    public int getItemCount() {
        return mData.size();

    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        Information mInformation ;
        TextView who;
        TextView content;
        TextView contact;

        public MyViewHolder(View itemView) {
            super(itemView);
            who = (TextView)itemView.findViewById(R.id.item_main_recycler_name);
            contact = (TextView)itemView.findViewById(R.id.item_main_recycler_contact);
            content= (TextView)itemView.findViewById(R.id.item_main_recycler_content);

        }
    }
}

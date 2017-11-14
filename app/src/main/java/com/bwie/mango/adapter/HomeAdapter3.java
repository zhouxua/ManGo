package com.bwie.mango.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.mango.R;
import com.bwie.mango.utils.SupperClass;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 周旋
 * 2017/10/20  14:04
 */

public class HomeAdapter3 extends RecyclerView.Adapter<HomeAdapter3.MyViewHolder>{
    Context context;
    List<SupperClass.DataBean.ActivityInfoBean.ActivityInfoListBean> list;

    public HomeAdapter3(Context context, List<SupperClass.DataBean.ActivityInfoBean.ActivityInfoListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_home4,parent,false);
        MyViewHolder holder1 = new MyViewHolder(view);
        return holder1;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ImageLoader.getInstance().displayImage(list.get(0).getActivityImg(),holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);

        }
    }
}

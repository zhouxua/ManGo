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
 * 2017/10/20  09:39
 */

public class HomeAdapter2 extends RecyclerView.Adapter<HomeAdapter2.MyViewHolder> {
    Context context;
    List<SupperClass.DataBean.Ad5Bean> list;

    public HomeAdapter2(Context context, List<SupperClass.DataBean.Ad5Bean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_home2,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
         holder.tv.setText(list.get(position).getTitle());
        ImageLoader.getInstance().displayImage(list.get(position).getImage(),holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
       private ImageView img;
        private TextView tv;
        public MyViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            tv = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}

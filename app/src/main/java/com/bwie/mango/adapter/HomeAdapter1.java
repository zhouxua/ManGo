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
 * 2017/10/19  18:45
 */

public class HomeAdapter1 extends RecyclerView.Adapter<HomeAdapter1.MyViewHolder>{
    Context context;
    List<SupperClass.DataBean.DefaultGoodsListBean> list;

    public HomeAdapter1(Context context, List<SupperClass.DataBean.DefaultGoodsListBean> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, null, false);
        final MyViewHolder staggView=new MyViewHolder(view);
        return staggView;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(list.get(position).getGoods_name());
        ImageLoader.getInstance().displayImage(list.get(position).getGoods_img(),holder.img);
        holder.shop_price.setText("￥"+list.get(position).getShop_price());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView shop_price;
        private ImageView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv);
            shop_price = (TextView) itemView.findViewById(R.id.tv2);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}

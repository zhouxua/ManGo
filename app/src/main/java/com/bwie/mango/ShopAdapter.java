package com.bwie.mango;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.mango.utils.ShopBean;
import com.bwie.mango.view.MyView;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 周旋
 * 2017/10/24  09:16
 */

    public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ShopBean.OrderDataBean.CartlistBean> list;

    public ShopAdapter(Context context, List<ShopBean.OrderDataBean.CartlistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof  MyViewHolder){
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.danjia.setText(list.get(position).getPrice()+"");
            Picasso.with(context).load(list.get(position).getDefaultPic()).into(myViewHolder.shopface);
            if(list.get(position).isSelect()){
                if(!myViewHolder.checkbox.isChecked()){
                    myViewHolder.checkbox.setChecked(true);
                }
            } else {
                myViewHolder.checkbox.setChecked(false);
            }

            myViewHolder.checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isChecked = list.get(position).isSelect() ;
                    list.get(position).setSelect(!isChecked);
                    notifyDataSetChanged();
                    if(listener != null){
                        listener.check(!isChecked,position);
                    }

                }
            });
            myViewHolder.customviewid.setListener(new MyView.ChangeListener() {
                @Override
                public void onChange(int count) {
                    list.get(position).setCount(count);
                    notifyDataSetChanged();
                    if(listener != null){
                        listener.check(list.get(position).isSelect(),position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.checkbox)
        CheckBox checkbox;
        @BindView(R.id.shopface)
        ImageView shopface;
        @BindView(R.id.price)
        TextView danjia;
        @BindView(R.id.customviewid)
        MyView customviewid;
        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
    public CheckListener listener;
    public void setCheckListener(CheckListener listener){
        this.listener = listener ;
    }
    public interface CheckListener {
        public void check(boolean check,int position);
    }
}



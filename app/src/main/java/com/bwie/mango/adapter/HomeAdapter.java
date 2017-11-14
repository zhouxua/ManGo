package com.bwie.mango.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.mango.R;
import com.bwie.mango.utils.GlideImageLoader;
import com.bwie.mango.utils.SupperClass;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 周旋
 * 2017/10/19  14:36
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
   Context context;
    SupperClass supperClass;
    LayoutInflater inflater;
    private final  int TYPE_1=0;
    private final  int TYPE_2 = 1;
    private final  int TYPE_3 = 2;
    private final  int TYPE_4 = 3;
    private final  int TYPE_5 = 4;
    private final  int TYPE_6 = 5;
    public HomeAdapter(Context context, SupperClass supperClass) {
        this.context = context;
        this.supperClass = supperClass;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return TYPE_1;
        } else if(position==1){
            return TYPE_2;
        }else if(position==2){
            return TYPE_3;
        }else if(position==3){
            return TYPE_4;
        }else if(position==4){
            return TYPE_5;
        }else{
           return TYPE_6;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       switch (viewType){
           case TYPE_1:
               View view1=inflater.inflate(R.layout.item_banner,parent,false);
               MyViewHolder1 myViewHolder1 = new MyViewHolder1(view1);
               return myViewHolder1;
           case TYPE_2:
               View view2=inflater.inflate(R.layout.item_home2,parent,false);
               MyViewHolder2 myViewHolder2 = new MyViewHolder2(view2);
               return myViewHolder2;
           case TYPE_3:
               View view3 = inflater.inflate(R.layout.item_home3,parent,false);
               MyViewHolder4 myViewHolder3=new MyViewHolder4(view3);
               return myViewHolder3;
           case TYPE_4:
               View view4 = inflater.inflate(R.layout.item_home4,parent,false);
               MyViewHolder4 myViewHolder4=new MyViewHolder4(view4);
               return myViewHolder4;
           case TYPE_5:
               View view5 = inflater.inflate(R.layout.item_home4,parent,false);
               MyViewHolder4 myViewHolder5=new MyViewHolder4(view5);
               return myViewHolder5;
           case TYPE_6:
               View view = inflater.inflate(R.layout.item_home_home,parent,false);
               MyViewHolder6 myViewHolder6 = new MyViewHolder6(view);
               return myViewHolder6;

       }
      return  null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int type = getItemViewType(position);
        switch (type){
            case TYPE_1:
                MyViewHolder1 myViewHolder = (MyViewHolder1) holder;
                myViewHolder.banner.setImageLoader(new GlideImageLoader());
                List<String> bannerList = new ArrayList<>();
                for (int i = 0; i < supperClass.getData().getAd1().size(); i++) {
                    bannerList.add(supperClass.getData().getAd1().get(i).getImage());
                }
                myViewHolder.banner.setImages(bannerList);
                myViewHolder.banner.start();
                break;
            case TYPE_2:
                MyViewHolder2 myViewHolder2= (MyViewHolder2) holder;
                myViewHolder2.mRecyclerView2.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
                HomeAdapter2 adapter2 = new HomeAdapter2(context, supperClass.getData().getAd5());
                myViewHolder2.mRecyclerView2.setAdapter(adapter2);
                break;
            case TYPE_3:
                MyViewHolder4 myViewHolder3 = (MyViewHolder4) holder;
                myViewHolder3.mRecyclerView4.setLayoutManager(new StaggeredGridLayoutManager(1,
                        StaggeredGridLayoutManager.HORIZONTAL));
                LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(context);
                linearLayoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
                myViewHolder3.mRecyclerView4.setLayoutManager(linearLayoutManager2);

                HomeAdapter3 homeAdapter3 = new HomeAdapter3(context,supperClass.getData().getActivityInfo().getActivityInfoList());
                myViewHolder3.mRecyclerView4.setAdapter(homeAdapter3);
                break;
            case TYPE_4:
                MyViewHolder4 myViewHolder4 = (MyViewHolder4) holder;
                myViewHolder4.mRecyclerView4.setLayoutManager(new StaggeredGridLayoutManager(1,
                        StaggeredGridLayoutManager.HORIZONTAL));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                myViewHolder4.mRecyclerView4.setLayoutManager(linearLayoutManager);

                HomeAdapter4 homeAdapter4 = new HomeAdapter4(context,supperClass.getData().getSubjects());
                myViewHolder4.mRecyclerView4.setAdapter(homeAdapter4);
                break;
            case TYPE_5:
                MyViewHolder4 myViewHolder5 = (MyViewHolder4) holder;
                myViewHolder5.mRecyclerView4.setLayoutManager(new StaggeredGridLayoutManager(1,
                        StaggeredGridLayoutManager.HORIZONTAL));
                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(context);
                linearLayoutManager1.setOrientation(LinearLayoutManager.HORIZONTAL);
                myViewHolder5.mRecyclerView4.setLayoutManager(linearLayoutManager1);

                HomeAdapter5 homeAdapter5 = new HomeAdapter5(context,supperClass.getData().getSubjects());
                myViewHolder5.mRecyclerView4.setAdapter(homeAdapter5);
                break;
            case TYPE_6:
                MyViewHolder6 myViewHolder6 = (MyViewHolder6) holder;
                myViewHolder6.mRecyclerview.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
                HomeAdapter1 homeAdapter1 = new HomeAdapter1(context, supperClass.getData().getDefaultGoodsList());
                myViewHolder6.mRecyclerview.setAdapter(homeAdapter1);
                break;
        }
          }

    @Override
    public int getItemCount() {

        return 6;
    }

    class MyViewHolder6 extends RecyclerView.ViewHolder{
        private TextView cainixihuan;
       private RecyclerView mRecyclerview;
        public MyViewHolder6(View itemView) {
            super(itemView);
            cainixihuan = (TextView) itemView.findViewById(R.id.cainixihuan);
            mRecyclerview = (RecyclerView) itemView.findViewById(R.id.mRecyclerView);

        }
    }
    class MyViewHolder1 extends RecyclerView.ViewHolder{
       private Banner banner;
        public MyViewHolder1(View itemView) {
            super(itemView);
           banner = (Banner) itemView.findViewById(R.id.banner);
        }
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder{
       private RecyclerView mRecyclerView2;
        public MyViewHolder2(View itemView) {
            super(itemView);
           mRecyclerView2 = (RecyclerView) itemView.findViewById(R.id.mRecyclerView2);
        }
    }
    class MyViewHolder4 extends RecyclerView.ViewHolder{
       private RecyclerView mRecyclerView4;
        public MyViewHolder4(View itemView) {
            super(itemView);
           mRecyclerView4 = (RecyclerView) itemView.findViewById(R.id.mRecyclerView4);
        }
    }
    class MyViewHolder5 extends RecyclerView.ViewHolder{
       private RecyclerView mRecyclerView4;
        public MyViewHolder5(View itemView) {
            super(itemView);
           mRecyclerView4 = (RecyclerView) itemView.findViewById(R.id.mRecyclerView4);
        }
    }
    class MyViewHolder3 extends RecyclerView.ViewHolder{
       private RecyclerView mRecyclerView4;
        public MyViewHolder3(View itemView) {
            super(itemView);
           mRecyclerView4 = (RecyclerView) itemView.findViewById(R.id.mRecyclerView4);
        }
    }
}

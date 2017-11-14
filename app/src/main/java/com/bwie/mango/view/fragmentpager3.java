package com.bwie.mango.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwie.mango.R;
import com.bwie.mango.ShopAdapter;
import com.bwie.mango.utils.ShopBean;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 周旋
 * 2017/10/11  08:55
 */

public class fragmentpager3 extends Fragment {

    List<ShopBean.OrderDataBean.CartlistBean> list = new ArrayList<ShopBean.OrderDataBean.CartlistBean>();
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.checkbox)
    CheckBox checkbox;
    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.bt)
    Button bt;
    Unbinder unbinder;
    private LinearLayoutManager manager;
    private ShopAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentpager3, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //上面可以使用网络请求数据，进行解析
        try {
            InputStream inputStream = getActivity().getAssets().open("shop.json");
            String data = convertStreamToString(inputStream);
            Gson gson = new Gson();
            ShopBean shopBean = gson.fromJson(data, ShopBean.class);
            for (int i = 0; i < shopBean.getOrderData().size(); i++) {
                int length = shopBean.getOrderData().get(i).getCartlist().size();
                for (int j = 0; j < length; j++) {
                    list.add(shopBean.getOrderData().get(i).getCartlist().get(j));
                }
            }
            //设置线性布局
            manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            rv.setLayoutManager(manager);
            //进行适配
            adapter = new ShopAdapter(getActivity(), list);
            rv.setAdapter(adapter);
            adapter.setCheckListener(new ShopAdapter.CheckListener() {
                @Override
                public void check(boolean check, int position) {
                    boolean allCheck = true;
                    float price = 0;
                    int count = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isSelect()) {
                            price += list.get(i).getPrice() * list.get(i).getCount();
                            count++;
                        }
                    }
                    for (int i = 0; i < list.size(); i++) {
                        if (!list.get(i).isSelect()) {
                            allCheck = false;
                            break;
                        }
                    }
                    tv.setText(price + "元");
                    bt.setText("结算（" + count + ")");
                    if (allCheck) {
                        checkbox.setChecked(true);
                    } else {
                        checkbox.setChecked(false);
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.checkbox, R.id.bt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.checkbox:
                boolean check = checkbox.isChecked();
                float price = 0;
                int count = 0;
                for (int i = 0; i < list.size(); i++) {
                    list.get(i).setSelect(check);
                    if (check) {
                        if (list.get(i).isSelect()) {
                            price += list.get(i).getPrice() * list.get(i).getCount();
                            count++;
                        }
                    }
                }
                adapter.notifyDataSetChanged();
                tv.setText("￥" + price);
                bt.setText("结算（" + count + ")");
                break;
            case R.id.bt:
                break;
        }
    }

    public String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

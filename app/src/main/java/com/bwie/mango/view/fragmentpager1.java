package com.bwie.mango.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.mango.MainActivity;
import com.bwie.mango.R;
import com.bwie.mango.adapter.HomeAdapter;
import com.bwie.mango.utils.GlideImageLoader;
import com.bwie.mango.utils.GsonObjectCallback;
import com.bwie.mango.utils.OkHttp3Utils;
import com.bwie.mango.utils.SupperClass;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.xys.libzxing.zxing.activity.CaptureActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

/**
 * 周旋
 * 2017/10/10  19:48
 */

public class fragmentpager1 extends Fragment {
    @BindView(R.id.erweima)
    ImageView erweima;
    @BindView(R.id.sousuokuang)
    EditText sousuokuang;
    @BindView(R.id.xiaoxi)
    ImageView xiaoxi;
    Unbinder unbinder;



    private RecyclerView mRecyclerView;




//    String mpath="http://result.eolinker.com/umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage";
    String mpath="http://m.yunifang.com/yunifang/mobile/home";
    private HomeAdapter homeAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.fragment_layout, null);
        unbinder = ButterKnife.bind(this, view);

        initData();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;

    }

    //销毁视图
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    //点击事件
    @OnClick({R.id.erweima, R.id.sousuokuang, R.id.xiaoxi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.erweima:
                startActivityForResult(new Intent(getActivity(), CaptureActivity.class), 0);
                Toast.makeText(getActivity(), "123", Toast.LENGTH_SHORT).show();
                break;
            case R.id.sousuokuang:
                Toast.makeText(getActivity(), "456", Toast.LENGTH_SHORT).show();
                break;
            case R.id.xiaoxi:
                Toast.makeText(getActivity(), "789", Toast.LENGTH_SHORT).show();
                break;
        }
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            Toast.makeText(getActivity(), result, Toast.LENGTH_SHORT).show();
        } else if (resultCode == RESULT_CANCELED) {
            Toast.makeText(getActivity(), "扫描出错", Toast.LENGTH_SHORT).show();
        }
    }


    protected void initData() {
       OkHttp3Utils.getInstance().doGet(mpath, new GsonObjectCallback<SupperClass>() {
           @Override
           public void onUi(SupperClass supperClass) {
               homeAdapter = new HomeAdapter(getActivity(), supperClass);
               mRecyclerView.setAdapter(homeAdapter);
           }

           @Override
           public void onFailed(Call call, IOException e) {

           }
       });

    }
}

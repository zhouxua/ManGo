package com.bwie.mango.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.mango.R;
import com.bwie.mango.nsg.login_activity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 周旋
 * 2017/10/11  08:58
 */

public class fragmentpager4 extends Fragment {

    @BindView(R.id.login)
    ImageView login;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentpager4, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        Intent intent = new Intent(getActivity(), login_activity.class);
        startActivity(intent);

    }
}

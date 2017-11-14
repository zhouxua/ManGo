package com.bwie.mango;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import com.bwie.mango.view.fragmentpager1;
import com.bwie.mango.view.fragmentpager2;
import com.bwie.mango.view.fragmentpager3;
import com.bwie.mango.view.fragmentpager4;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class MainActivity extends AppCompatActivity {
    FragmentManager fm;
    fragmentpager1 fragmentpager1;
    fragmentpager2 fragmentpager2;
    fragmentpager3 fragmentpager3;
    fragmentpager4 fragmentpager4;

    @BindView(R.id.rbtn1)
    RadioButton rbtn1;
    @BindView(R.id.rbtn2)
    RadioButton rbtn2;
    @BindView(R.id.rbtn3)
    RadioButton rbtn3;
    @BindView(R.id.rbtn4)
    RadioButton rbtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //设置底部图片的大小
        Drawable button1 = getResources().getDrawable(R.drawable.button_image1);
        button1.setBounds(0,0,80,80);
        rbtn1.setCompoundDrawables(null,button1,null,null);

        Drawable button2 = getResources().getDrawable(R.drawable.button_image2);
        button2.setBounds(0,0,80,80);
        rbtn2.setCompoundDrawables(null,button2,null,null);

        Drawable button3 = getResources().getDrawable(R.drawable.button_image3);
        button3.setBounds(0,0,80,80);
        rbtn3.setCompoundDrawables(null,button3,null,null);

        Drawable button4 = getResources().getDrawable(R.drawable.button_image4);
        button4.setBounds(0,0,80,80);
        rbtn4.setCompoundDrawables(null,button4,null,null);

         fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
         fragmentpager1 = new fragmentpager1();
         fragmentpager2 = new fragmentpager2();
         fragmentpager3 = new fragmentpager3();
         fragmentpager4 = new fragmentpager4();
        transaction.add(R.id.fragment_layout,fragmentpager1);
        transaction.show(fragmentpager1);
        transaction.commit();
        rbtn1.setChecked(true);
    }

    @OnClick({R.id.rbtn1, R.id.rbtn2, R.id.rbtn3, R.id.rbtn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbtn1:
                fm.beginTransaction().replace(R.id.fragment_layout,fragmentpager1).commit();
                break;
            case R.id.rbtn2:
                fm.beginTransaction().replace(R.id.fragment_layout,fragmentpager2).commit();
                break;
            case R.id.rbtn3:
                fm.beginTransaction().replace(R.id.fragment_layout,fragmentpager3).commit();
                break;
            case R.id.rbtn4:
                fm.beginTransaction().replace(R.id.fragment_layout,fragmentpager4).commit();
                break;
        }
    }
}

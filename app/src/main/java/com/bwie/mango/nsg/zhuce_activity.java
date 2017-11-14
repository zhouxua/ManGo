package com.bwie.mango.nsg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.mango.R;
import com.bwie.mango.utils.GsonObjectCallback;
import com.bwie.mango.utils.OkHttp3Utils;
import com.bwie.mango.utils.Zhuce_zh;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class zhuce_activity extends AppCompatActivity {
    String code;

    String mpath = "http://120.27.23.105/user/reg";
    @BindView(R.id.reg_back)
    TextView regBack;
    @BindView(R.id.user_user)
    EditText userUser;
    @BindView(R.id.user_pass)
    EditText userPass;
    @BindView(R.id.user_passtwo)
    EditText userPasstwo;
    @BindView(R.id.user_email)
    EditText userEmail;
    @BindView(R.id.zh_btn)
    Button zhBtn;
    private Map<String, String> map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce_activity);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.zh_btn)
    public void onViewClicked() {
        String user=userUser.getText().toString();
        String pass=userPass.getText().toString();
        String passtwo=userPasstwo.getText().toString();
        String email=userEmail.getText().toString();
        map = new HashMap<>();
        map.put("mobile", user);
        map.put("password", pass);

        if (user==null||user.equals("")||pass==null||pass.equals("")||passtwo==null||passtwo.equals("")||email==null||email.equals("")){
            Toast.makeText(zhuce_activity.this, "注册信息不能为空!", Toast.LENGTH_SHORT).show();
    }else {
            OkHttp3Utils.getInstance().doPost(mpath, map, new GsonObjectCallback<Zhuce_zh>() {

                @Override
                public void onUi(Zhuce_zh zhuce_zh) {
                    String code = zhuce_zh.getCode();
                    Toast.makeText(zhuce_activity.this, code, Toast.LENGTH_SHORT).show();
                    if (code.equals("0")) {
                        Toast.makeText(zhuce_activity.this, "注册成功!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(zhuce_activity.this, "注册失败!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailed(Call call, IOException e) {

                }
            });
        }}
}

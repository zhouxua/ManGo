package com.bwie.mango.nsg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.mango.R;
import com.bwie.mango.utils.GsonObjectCallback;
import com.bwie.mango.utils.OkHttp3Utils;
import com.bwie.mango.utils.login_lg;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

public class login_activity extends AppCompatActivity {

    @BindView(R.id.user_login)
    EditText userLogin;
    @BindView(R.id.user_password)
    EditText userPassword;
    @BindView(R.id.tiaozhuan)
    TextView tiaozhuan;
    @BindView(R.id.login1)
    Button login1;
    @BindView(R.id.activity_login_activity)
    RelativeLayout activityLoginActivity;
    String mpath="http://120.27.23.105/user/login";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.tiaozhuan, R.id.login1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tiaozhuan:
                Intent intent = new Intent(login_activity.this, zhuce_activity.class);
                startActivity(intent);
                break;
            case R.id.login1:
                String user_login=userLogin.getText().toString();
                String user_password=userPassword.getText().toString();
                Map<String, String> loginMap = new HashMap<>();
                loginMap.put("mobile",user_login);
                loginMap.put("password",user_password);
                OkHttp3Utils.getInstance().doPost(mpath, loginMap, new GsonObjectCallback<login_lg>() {
                    @Override
                    public void onUi(login_lg login_lg) {
                        String code = login_lg.getCode();
                        Toast.makeText(login_activity.this,code,Toast.LENGTH_LONG).show();
                        if (code.equals("0")){
                            Toast.makeText(login_activity.this,"登录成功",Toast.LENGTH_LONG).show();
                            finish();
                        }else{
                            Toast.makeText(login_activity.this,"您输入的内容有误，请重新输入",Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailed(Call call, IOException e) {

                    }
                });
                break;
        }
    }
}

package com.hgsil.find;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hgsil.find.data.User;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private TextView login;
    private TextView toCreate;
    private TextView forgetPassword;
    private EditText password;
    private EditText id;
    private Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        initListener();
    }

    private void initView(){
        login = (TextView) findViewById(R.id.login_card_confirm);
        toCreate = (TextView)findViewById(R.id.login_tocreate);
        forgetPassword = (TextView)findViewById(R.id.login_forgetpassword);
        password = (EditText) findViewById(R.id.login_password_edit);
        id = (EditText) findViewById(R.id.login_number_edit);
    }
    public void initListener(){
        toCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,CreateActivity.class));
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
                List<User> user = DataSupport.where("number=?",id.getText().toString()).find(User.class);
                if (user.size()==0)
                    Toast.makeText(mContext,"无效的用户名！",Toast.LENGTH_SHORT).show();
                else{
                    if (user.get(0).getPassword().equals(password.getText().toString())) {
                        Toast.makeText(mContext, "登录成功！", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("user",user.get(0));
                        startActivity(intent);
                        finish();
                    }else
                        Toast.makeText(mContext,"密码错误！",Toast.LENGTH_SHORT).show();
                }
            }
        });


        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ForgetPasswordActivity.class));
            }
        });
    }
}

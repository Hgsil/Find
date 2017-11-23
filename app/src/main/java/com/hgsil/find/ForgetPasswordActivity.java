package com.hgsil.find;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hgsil.find.data.User;

import org.litepal.crud.DataSupport;

import java.util.List;

public class ForgetPasswordActivity extends AppCompatActivity {
    private TextView forget;
    private EditText number;
    private EditText name;
    private ImageView back ;
    private Context mContext = this ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        initView();
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<User> users = DataSupport.where("name=? and number=?",
                        name.getText().toString(),number.getText().toString()).find(User.class);
                if (users.size() == 0){
                    Toast.makeText(mContext,"请正确输入或没有用户",Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(mContext,"密码:"+users.get(0).getPassword(),Toast.LENGTH_SHORT).show();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void initView(){
        forget = (TextView) findViewById(R.id.forget_confirm);
        number = (EditText) findViewById(R.id.forget_number_edit);
        name = (EditText) findViewById(R.id.forget_name_edit);
        back = (ImageView)findViewById(R.id.forget_back);
    }
}

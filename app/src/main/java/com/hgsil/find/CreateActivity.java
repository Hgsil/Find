package com.hgsil.find;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hgsil.find.data.MyDatabaseHelper;
import com.hgsil.find.data.User;

import org.litepal.tablemanager.Connector;

public class CreateActivity extends AppCompatActivity {
    private TextView create;
    private EditText number;
    private EditText name;
    private EditText password;
    private ImageView back ;
    private Context mContext = this;
    private MyDatabaseHelper mMyDatabaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        initView();
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
                if (password.getText().length()<6||name.getText().length()==0){
                    Toast.makeText(mContext,"密码过短!",Toast.LENGTH_SHORT).show();
                }
                else {
                    User user = new User(number.getText().toString(),name.getText().toString(),password.getText().toString());
                    user.save();
                    Toast.makeText(mContext,"注册成功",Toast.LENGTH_SHORT).show();
                    finish();
                }
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
        create = (TextView) findViewById(R.id.create_confirm);
        password = (EditText) findViewById(R.id.create_password_edit);
        number = (EditText) findViewById(R.id.create_number_edit);
        name = (EditText) findViewById(R.id.create_name_edit);
        back = (ImageView)findViewById(R.id.create_back);
    }
}

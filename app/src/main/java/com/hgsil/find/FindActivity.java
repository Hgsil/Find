package com.hgsil.find;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hgsil.find.data.Information;

public class FindActivity extends AppCompatActivity {
    private TextView find;
    private EditText information;
    private EditText phone;
    private String name,number;
    private ImageView back;
    private Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        initView();
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (phone.getText().length()!=11)
                    Toast.makeText(mContext,"请输入正确的电话",Toast.LENGTH_SHORT).show();
                else if (information.getText().length()==0)
                    Toast.makeText(mContext,"请输入正确的描述",Toast.LENGTH_SHORT).show();
                else{
                    Information info = new Information(name,information.getText().toString()
                    ,phone.getText().toString(),number);
                    info.save();
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
        find = (TextView)findViewById(R.id.find_confirm);
        back = (ImageView)findViewById(R.id.find_back);
        number = getIntent().getStringExtra("number");
        name =  getIntent().getStringExtra("name");
        information = (EditText)findViewById(R.id.find_what_edit);
        phone = (EditText)findViewById(R.id.find_contact_edit);
    }
}

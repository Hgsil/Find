package com.hgsil.find;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hgsil.find.adapter.MainAdapter;
import com.hgsil.find.data.Information;

import org.litepal.crud.DataSupport;

import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private String name,number;
    private TextView nameText;
    private TextView tips ;
    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;
    private Context mContext = this;
    private List<Information> mInformations;
    private ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        mInformations = DataSupport.where("number=?",number).find(Information.class);
        if (mInformations.size()==0){
            tips.setVisibility(View.VISIBLE);
            mAdapter = new MainAdapter(mContext);
        }else{
            tips.setVisibility(View.GONE);
            mAdapter = new MainAdapter(mInformations,mContext);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mAdapter);
        }


    }
    public void initView(){
        tips = (TextView)findViewById(R.id.history_tips);
        nameText = (TextView)findViewById(R.id.history_name);
        number = getIntent().getStringExtra("number");
        name =  getIntent().getStringExtra("name");
        nameText.setText(name);
        mRecyclerView = (RecyclerView)findViewById(R.id.history_recycler);
        back = (ImageView)findViewById(R.id.history_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

package com.hgsil.find;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hgsil.find.adapter.MainAdapter;
import com.hgsil.find.data.Information;
import com.hgsil.find.data.User;

import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Information> mInformations ;
    private TextView tips;
    private TextView history;
    private FloatingActionButton add;
    private MainAdapter mAdapter;
    private Context mContext = this;
    private User mUser;
    private RecyclerView mRecyclerView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mUser = (User)getIntent().getSerializableExtra("user");
        mInformations = DataSupport.findAll(Information.class);

        if (mInformations.size()==0){
            tips.setVisibility(View.VISIBLE);
            mAdapter = new MainAdapter(mContext);
        }else{
            tips.setVisibility(View.GONE);
            mAdapter = new MainAdapter(mInformations,mContext);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mAdapter);
        }

        initListener();

    }
    public void initView(){
        tips = (TextView)findViewById(R.id.main_tips);
        history = (TextView)findViewById(R.id.main_history);
        add = (FloatingActionButton)findViewById(R.id.main_add);
        mRecyclerView = (RecyclerView)findViewById(R.id.main_recycler);
    }
    public void initListener(){
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,HistoryActivity.class);
                intent.putExtra("number",mUser.getNumber());
                intent.putExtra("name",mUser.getName());
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FindActivity.class);
                intent.putExtra("number",mUser.getNumber());
                intent.putExtra("name",mUser.getName());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mInformations = DataSupport.findAll(Information.class);
        if (mInformations.size()!=0){
            tips.setVisibility(View.GONE);
            mAdapter.setData(mInformations);
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        }

}
}

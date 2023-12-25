package com.dreamtank.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dreamtank.chapter03.util.DateUtil;

public class ActReceiveActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView tv_receive;
    private Button bt_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_receive);
        tv_receive = findViewById(R.id.tv_receive);
        bt_back = findViewById(R.id.bt_back);
        bt_back.setOnClickListener(this);
        Bundle bundle = getIntent().getExtras();
        String request_time = bundle.getString("request_time");
        String request_content = bundle.getString("request_content");
        String desc = String.format("リクエストメッセージの受信： \nリクエスト時刻:%s\nリクエスト内容:%s", request_time, request_content);
        tv_receive.setText(desc);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bt_back){
            finish();
        }
    }
}
package com.dreamtank.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dreamtank.chapter03.util.DateUtil;

public class ActSendActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView tv_send;
    private Button bt_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_send);
        tv_send = findViewById(R.id.tv_send);
        bt_send = findViewById(R.id.bt_send);
        bt_send.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ActReceiveActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("request_time", DateUtil.getNowTime());
        bundle.putString("request_content", tv_send.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
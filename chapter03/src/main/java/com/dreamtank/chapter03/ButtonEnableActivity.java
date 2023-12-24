package com.dreamtank.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamtank.chapter03.util.DateUtil;

public class ButtonEnableActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_test;
    private Button bt_off;
    private Button bt_on;
    private TextView tv_result;
    private ImageView iv_ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_enable);
        bt_on = findViewById(R.id.bt_on);
        bt_off = findViewById(R.id.bt_off);
        bt_test = findViewById(R.id.bt_test);
        tv_result = findViewById(R.id.tv_result);
        iv_ds = findViewById(R.id.iv_ds);
        bt_on.setOnClickListener(this);
        bt_test.setOnClickListener(this);
        bt_off.setOnClickListener(this);
        iv_ds.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.bt_on){
            bt_test.setEnabled(true);
        }else if (id == R.id.bt_off){
            bt_test.setEnabled(false);
            tv_result.setText(R.string.result);
            iv_ds.setVisibility(View.GONE);
        } else if (id == R.id.bt_test) {
            String desc = String.format("%s ボタンを押しました: %s", DateUtil.getNowTime(),((Button)view).getText());
            tv_result.setText(desc);
            iv_ds.setVisibility(View.VISIBLE);
        } else if (id == R.id.iv_ds) {
            startActivity(new Intent(view.getContext(), TurnActivity.class));
        }
    }
}
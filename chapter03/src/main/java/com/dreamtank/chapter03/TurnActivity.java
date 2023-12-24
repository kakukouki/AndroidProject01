package com.dreamtank.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class TurnActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn);
        findViewById(R.id.iv_fh).setOnClickListener(this);
        findViewById(R.id.bt_wc).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.iv_fh || view.getId() == R.id.bt_wc){
            finish();
        }
    }
}
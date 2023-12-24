package com.dreamtank.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dreamtank.chapter03.util.DateUtil;

public class ButtonActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        textView = findViewById(R.id.time);

    }

    public void doClick(View view){
        String desc = String.format("%s ボタンを押しました： %s", DateUtil.getNowTime(), ((Button) view).getText());
        textView.setText(desc);
    }
}
package com.dreamtank.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EditActivity extends AppCompatActivity implements View.OnFocusChangeListener, View.OnClickListener {

    private Button bt_login;
    private EditText et_phone;
    private EditText et_password;
    private TextView tv_alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        et_phone = findViewById(R.id.et_phone);
        et_password = findViewById(R.id.et_password);
        bt_login = findViewById(R.id.bt_login);
        tv_alert = findViewById(R.id.tv_alert);

        et_password.setOnFocusChangeListener(this);
        bt_login.setOnClickListener(this);

    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            String phone = et_phone.getText().toString();
            if (TextUtils.isEmpty(phone) || phone.length() < 11){
                et_phone.requestFocus();
                Toast.makeText(this, "11桁の携帯電話番号を入力してください", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("尊敬的お客様");
        builder.setMessage("いつもをご利用いただき、ありがとうございます。\nアンインストールしてもよろしいでしょうか？");
        builder.setPositiveButton("アンインストール", (dialogInterface, i) -> {
            tv_alert.setText("さようなら👋");
        });
        builder.setNegativeButton("キャンセル", (dialogInterface, i) -> {
            tv_alert.setText("ありがとう😊");
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
package com.dreamtank.chapter03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ViewUtils;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.dreamtank.chapter03.util.ViewUtil;

import java.util.Random;

public class LoginMainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private TextView tv_password;
    private EditText et_password;
    private Button bt_forget;
    private CheckBox ck_remember;
    private EditText et_phone;
    private RadioGroup rb_login;
    private RadioButton rb_password;
    private RadioButton rb_verifycode;
    private ActivityResultLauncher<Intent> register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        rb_login = findViewById(R.id.rg_login);
        tv_password = findViewById(R.id.tv_password);
        et_password = findViewById(R.id.et_password);
        et_phone = findViewById(R.id.et_phone);
        bt_forget = findViewById(R.id.bt_forget);
        ck_remember = findViewById(R.id.ck_remember);
        rb_password = findViewById(R.id.rb_password);
        rb_verifycode = findViewById(R.id.rb_verifycode);

        rb_login.setOnCheckedChangeListener(this);
        bt_forget.setOnClickListener(this);
        et_phone.addTextChangedListener(new HideTextWatcher(et_phone, 11));
        et_password.addTextChangedListener(new HideTextWatcher(et_password, 6));

        register = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {

            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.rb_password){
            tv_password.setText(getString(R.string.password));
            et_password.setHint(getString(R.string.input_password));
            bt_forget.setText(getString(R.string.forget_password));
            ck_remember.setVisibility(View.VISIBLE);
        }else if (i == R.id.rb_verifycode){
            tv_password.setText(getString(R.string.verifycode));
            et_password.setHint(getString(R.string.input_verifycode));
            bt_forget.setText(getString(R.string.get_verifycode));
            ck_remember.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        String phone = et_phone.getText().toString();
        int id = view.getId();
        if (id == R.id.bt_forget) {
            if (phone.length() < 11) {
                Toast.makeText(this, "有効な電話番号を入力してください",Toast.LENGTH_SHORT).show();
            }else if (rb_password.isChecked()) {
                Intent intent = new Intent(this, ButtonEnableActivity.class);
                intent.putExtra("phone", phone);
                register.launch(intent);
            }else if(rb_verifycode.isChecked()) {
                String verifyCode = String.format("%06d", new Random().nextInt(999999));
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("認証コードを忘れないように");
                builder.setMessage("電話番号" + phone + ",今回の認証コードは" + verifyCode + ",認証コードを入力してください");
                builder.setPositiveButton("はい", null);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        }
    }


    private class HideTextWatcher implements TextWatcher {
        private EditText mView;
        private int mMaxLength;
        public HideTextWatcher(EditText v, int maxLength) {
            this.mView = v;
            this.mMaxLength = maxLength;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            if (editable.toString().length() == mMaxLength){
                ViewUtil.hideOneInputMethod(LoginMainActivity.this, mView);
            }
        }
    }
}
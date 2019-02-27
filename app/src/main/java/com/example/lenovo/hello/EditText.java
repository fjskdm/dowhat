package com.example.lenovo.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EditText extends AppCompatActivity {
    private Button login_in;
    private android.widget.EditText setin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        login_in = findViewById(R.id.login_Button);
        login_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //监听登录按钮事件
                Toast.makeText(EditText.this,"登录中",Toast.LENGTH_SHORT).show();
            }
        });
        setin = findViewById(R.id.ET_1);
        setin.addTextChangedListener(new TextWatcher() {
            //监听用户名输入事件
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e("输入前的方法",s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e("变化时的方法",s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e("输入完成的方法",s.toString());
            }
        });

    }
}

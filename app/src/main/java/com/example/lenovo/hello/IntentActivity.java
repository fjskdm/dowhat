package com.example.lenovo.hello;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class IntentActivity extends AppCompatActivity {

    private Button btn_1,btn_2,btn_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        btn_1 = findViewById(R.id.BTN_1);
        btn_2 = findViewById(R.id.BTN_2);
        btn_3 = findViewById(R.id.BTN_3);
        setOnClickListener();
    }

    private void setOnClickListener(){
        btn_1.setOnClickListener(l);
        btn_2.setOnClickListener(l);
        btn_3.setOnClickListener(l);
    }
//    通过action属性可以调用系统的某些属性
//    通过category可以对调用的程序进行描述
    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            Button btn = (Button) v;
            switch (btn.getId()){
                case R.id.BTN_1:
                    intent.setAction(intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:15983831991"));
                    break;
                case R.id.BTN_2:
                    intent.setAction(intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("smsto:15983831991"));
                    intent.putExtra("sms_body","这是默认的发送信息");
                    break;
                case R.id.BTN_3:
                    intent.setAction(intent.ACTION_MAIN);
                    intent.addCategory(intent.CATEGORY_HOME);
                    break;
            }
            startActivity(intent);
        }
    };
}

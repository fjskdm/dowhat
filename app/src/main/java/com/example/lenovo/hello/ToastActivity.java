package com.example.lenovo.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.hello.util.ToastUtil;

public class ToastActivity extends AppCompatActivity {
    private Button bu_1,bu_2,bu_3,bu_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        bu_1 = findViewById(R.id.toast_1);
        bu_2 = findViewById(R.id.toast_2);
        bu_3 = findViewById(R.id.toast_3);
        bu_4 = findViewById(R.id.toast_4);
        Onclick onclick = new Onclick();
        bu_1.setOnClickListener(onclick);
        bu_2.setOnClickListener(onclick);
        bu_3.setOnClickListener(onclick);
        bu_4.setOnClickListener(onclick);
    }

    class Onclick implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.toast_1:
                    Toast.makeText(getApplicationContext(),"Toast",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.toast_2:
                    Toast toastCenter = Toast.makeText(getApplicationContext(),"ToastCenter",Toast.LENGTH_SHORT);
                    toastCenter.setGravity(Gravity.CENTER,0,0);
                    toastCenter.show();
                    break;
                case R.id.toast_3:
                    Toast toastCustom = new Toast(getApplicationContext());
                    LayoutInflater inflater = LayoutInflater.from(ToastActivity.this);
                    View view = inflater.inflate(R.layout.layout_toast,null);
                    ImageView imageView = view.findViewById(R.id.iv_1);
                    TextView textView = view.findViewById(R.id.tv_1);
                    imageView.setImageResource(R.drawable.icon);
                    textView.setText("show toast");
                    toastCustom.setView(view);
                    toastCustom.show();
                    break;
                case R.id.toast_4:
                    ToastUtil.showMsg(getApplicationContext(),"show it");
                    break;
            }
        }
    }
}

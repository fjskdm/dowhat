package com.example.lenovo.hello;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class test extends AppCompatActivity {
    private TextView tv_1;
    private TextView tv_4;
    private TextView tv_5;
    private TextView tv_6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        tv_1 = findViewById(R.id.TV_1);
        //中划线
        tv_4 = findViewById(R.id.TV_4);
        tv_4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv_4.getPaint().setAntiAlias(true);
        //下划线
        tv_5 = findViewById(R.id.TV_5);
        tv_5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        //另一种方法的下划线
        tv_6 = findViewById(R.id.TV_6);
        tv_6.setText(Html.fromHtml("<u>test it</u>"));

    }
}

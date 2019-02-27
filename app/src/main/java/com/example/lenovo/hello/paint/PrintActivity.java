package com.example.lenovo.hello.paint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.lenovo.hello.R;

public class PrintActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_print);
        FrameLayout frameLayout = findViewById(R.id.FL_1);
        frameLayout.addView(new MyViewPaint(this));
    }
}

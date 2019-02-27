package com.example.lenovo.hello.TouchActivity;

import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.hello.R;

public class TouchActivity extends AppCompatActivity implements View.OnTouchListener{

    private TextView tv_x,tv_y;
    private LinearLayout ll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tv_x = findViewById(R.id.touch_x);
        tv_y = findViewById(R.id.touch_y);
        ll = findViewById(R.id.LL);
        ll.setOnTouchListener(this);
    }




    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                tv_x.setText("x"+(int) event.getX());
                tv_y.setText("y"+(int) event.getY());
                break;
            case MotionEvent.ACTION_UP:
                tv_x.setText("x"+(int) event.getX());
                tv_y.setText("y"+(int) event.getY());
                break;
        }
        return true;
    }
}

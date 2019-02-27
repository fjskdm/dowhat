package com.example.lenovo.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.example.lenovo.hello.MyView.MyownView;


public class MyViewActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_view);
        FrameLayout frameLayout = findViewById(R.id.MyLayout);
        final MyownView own = new MyownView(MyViewActivity.this);
        own.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                own.bitmapX = event.getX();
                own.bitmapY = event.getY();
                own.invalidate();
                return true;
            }
        });
        frameLayout.addView(own);
    }
}

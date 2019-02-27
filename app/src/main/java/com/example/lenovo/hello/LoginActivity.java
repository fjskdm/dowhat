package com.example.lenovo.hello;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

import java.lang.reflect.Method;

public class LoginActivity extends AppCompatActivity {

    private ProgressBar mProgressbar,pb_1;
    private Button btn_1;
    private Handler mHandler,mHandler1;
    private int mProgerss = 0;
    private int mProgress1 = 0;
    private int set1 = 0;
    private SeekBar sk_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏显示
        mProgressbar = findViewById(R.id.progressbar);
        btn_1 = findViewById(R.id.Btn_1);
        sk_1 = findViewById(R.id.SB_1);
        pb_1 = findViewById(R.id.PB_1);
        mHandler1 = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0x111){
                pb_1.setProgress(mProgress1);}
            }
        };


        sk_1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mProgress1 = progress;
                final Thread thread1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message m = new Message();
                        m.what = 0x111;
                        mHandler1.sendMessage(m);

                    }
                });
                thread1.start();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0x11){
                    mProgressbar.setProgress(mProgerss);
                }else{
                    mProgressbar.setVisibility(View.GONE);
                }
            }
        };
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    mProgerss  = dowork();
                    Message m = new Message();
                    if(mProgerss <100){
                        m.what = 0x11;
                        mHandler.sendMessage(m);
                    }else {
                        m.what = 0x10;
                        mHandler.sendMessage(m);
                        break;
                    }
                }
            }
        });

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread.start();
            }
        });
    }

    private int dowork(){
        mProgerss += Math.random()*10;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return mProgerss;
    }

}

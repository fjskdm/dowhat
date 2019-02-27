package com.example.lenovo.hello;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class HandlerActivity extends AppCompatActivity {

    private ProgressBar pb_1,pb_2;
    private Button bt_1,bt_2;
    private TextView tv_1;
    final int time = 30;
    private int mProgressStatus = 0;
//    handler是Android中的一种消息处理机制
//    这种机制可以在任意进程中发送信息
//    在主线程中获取并处理子线程发送的消息
//    在子线程中使用sendMessage等方法来发送消息
//    在handler中识别消息并改变主线程中的控件
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        bt_1 = findViewById(R.id.BT_1);
        bt_2 = findViewById(R.id.BT_2);
        tv_1 = findViewById(R.id.TV_1);
        pb_1 = findViewById(R.id.PB_1);
        pb_2 = findViewById(R.id.PB_2);
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if(msg.what == 0x01){
                    tv_1.setText("这是点击线程中的文字");
                }
            }
        };
        handler1.sendEmptyMessage(0x02);
        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                创建一个线程
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
//                  不允许在子线程中直接更新主线程的组件
//                    tv_1.setText("这是点击线程中的文字");
//                    handler.sendMessage();//发送消息
                    handler.sendEmptyMessage(0x01);//发送空消息，what是用来识别信息的
//                    handler.sendMessageDelayed();//延迟发送消息
//                    handler.sendEmptyMessageDelayed();
                    }
                });
                thread.start();
            }
        });
        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tv_1.setText("这是第二个点击改变的文字");
                    }
                });
            }
        });
    }
    Handler handler1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(time - mProgressStatus >0){
                mProgressStatus++;
                pb_1.setProgress(time-mProgressStatus);
                handler1.sendEmptyMessageDelayed(0x02,1000);
            }else{
                Toast.makeText(HandlerActivity.this,"进度条到底",Toast.LENGTH_SHORT).show();
            }
        }
    };
}

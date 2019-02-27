package com.example.lenovo.hello;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoticeActivity extends AppCompatActivity {

    private Button btn_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        btn_1 = findViewById(R.id.BTN_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NoticeActivity.this,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(NoticeActivity.this,0,intent,0);
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification.Builder builder = new Notification.Builder(NoticeActivity.this);
                        builder.setContentTitle("这是一个标题")//设置标题
                        .setContentText("这是内容,点击后返回主界面")//设置内容,内容和图片不能同时显示
                        .setSmallIcon(R.mipmap.ic_launcher)//设置小标志
                        .setAutoCancel(true)//设置点击后默认关闭
                        .setContentIntent(pendingIntent)//设置点击事件
                        .setStyle(new Notification.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.cg1)))//设置一张大图片
                        .setDefaults(Notification.DEFAULT_ALL);
                 Notification notification = builder.build();
                manager.notify(1,notification);
            }
        });
    }
}

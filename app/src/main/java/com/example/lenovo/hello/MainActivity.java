package com.example.lenovo.hello;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.example.lenovo.hello.Bluetooth.Bluetooth;
import com.example.lenovo.hello.GridView.GridViewActivity;
import com.example.lenovo.hello.RecyclerView.RecylerViewActivity;
import com.example.lenovo.hello.Sensor.SeneorActivity;
import com.example.lenovo.hello.Service.ServiceActivity;
import com.example.lenovo.hello.TouchActivity.TouchActivity;
import com.example.lenovo.hello.WebView.WebViewMainActivity;
import com.example.lenovo.hello.jump.JumpActivity;
import com.example.lenovo.hello.listview.ListViewActivity;
import com.example.lenovo.hello.paint.PrintActivity;

public class MainActivity extends AppCompatActivity {
    private Button mB_1,mB_2,mB_3,mB_4,mB_5,mB_6,mB_7,mB_8,mB_9,mB_10,mB_11,mB_12,mB_13,mB_14,mB_15,
            mB_16,mB_17,mB_18,mB_19,mB_20,mB_21,mB_22,mB_23,mB_24,mB_25,mB_26,mB_27,mB_28,mB_29,mB_30,
            mB_31,mB_32,mB_33;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setLogo(R.drawable.icon);
        actionBar.setDisplayUseLogoEnabled(true);

        setContentView(R.layout.activity_main);
        mB_1 = findViewById(R.id.Text);
        mB_2 = findViewById(R.id.Butt);
        mB_3 = findViewById(R.id.Edit);
        mB_4 = findViewById(R.id.Radio);
        mB_5 = findViewById(R.id.check);
        mB_6 = findViewById(R.id.imageview);
        mB_7 = findViewById(R.id.listview);
        mB_8 = findViewById(R.id.gridview);
        mB_9 = findViewById(R.id.recyclerview);
        mB_10 = findViewById(R.id.webview);
        mB_11 = findViewById(R.id.toast);
        mB_12 = findViewById(R.id.alertdialog);
        mB_13 = findViewById(R.id.dialog);
        mB_14 = findViewById(R.id.popup);
        mB_15 = findViewById(R.id.jump);
        mB_16 = findViewById(R.id.fragment);
        mB_17 = findViewById(R.id.touch);
        mB_18 = findViewById(R.id.mysql);
        mB_19 = findViewById(R.id.bluetooth);
        mB_20 = findViewById(R.id.handler);
        mB_21 = findViewById(R.id.framelayout);
        mB_22 = findViewById(R.id.progressbar);
        mB_23 = findViewById(R.id.ratingbar);
        mB_24 = findViewById(R.id.intentTest);
        mB_25 = findViewById(R.id.myView);
        mB_26 = findViewById(R.id.Store);
        mB_27 = findViewById(R.id.ServiceTest);
        mB_28 = findViewById(R.id.Paint);
        mB_29 = findViewById(R.id.sensor);
        mB_30 = findViewById(R.id.baidumap);
        mB_31 = findViewById(R.id.action_bar);
        mB_32 = findViewById(R.id.notice);
        mB_33 = findViewById(R.id.toolbar);
        setlistener();
    }

    private void setlistener(){
        OnClick onClick = new OnClick();
        mB_1.setOnClickListener(onClick);
        mB_2.setOnClickListener(onClick);
        mB_3.setOnClickListener(onClick);
        mB_4.setOnClickListener(onClick);
        mB_5.setOnClickListener(onClick);
        mB_6.setOnClickListener(onClick);
        mB_7.setOnClickListener(onClick);
        mB_8.setOnClickListener(onClick);
        mB_9.setOnClickListener(onClick);
        mB_10.setOnClickListener(onClick);
        mB_11.setOnClickListener(onClick);
        mB_12.setOnClickListener(onClick);
        mB_13.setOnClickListener(onClick);
        mB_14.setOnClickListener(onClick);
        mB_15.setOnClickListener(onClick);
        mB_16.setOnClickListener(onClick);
        mB_17.setOnClickListener(onClick);
        mB_18.setOnClickListener(onClick);
        mB_19.setOnClickListener(onClick);
        mB_20.setOnClickListener(onClick);
        mB_21.setOnClickListener(onClick);
        mB_22.setOnClickListener(onClick);
        mB_23.setOnClickListener(onClick);
        mB_24.setOnClickListener(onClick);
        mB_25.setOnClickListener(onClick);
        mB_26.setOnClickListener(onClick);
        mB_27.setOnClickListener(onClick);
        mB_28.setOnClickListener(onClick);
        mB_29.setOnClickListener(onClick);
        mB_30.setOnClickListener(onClick);
        mB_31.setOnClickListener(onClick);
        mB_32.setOnClickListener(onClick);
        mB_33.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener{
        Intent intent=null;
        @Override
        public void onClick(View v){
            switch (v.getId()) {
                case R.id.Text:
                    intent = new Intent(MainActivity.this, test.class);
                    break;
                case R.id.Butt:
                    intent = new Intent(MainActivity.this, Buttontext.class);
                    break;
                case R.id.Edit:
                    intent = new Intent(MainActivity.this, EditText.class);
                    break;
                case R.id.Radio:
                    intent = new Intent(MainActivity.this, RadioActivity.class);
                    break;
                case R.id.check:
                    intent = new Intent(MainActivity.this, CheckBox.class);
                    break;
                case R.id.imageview:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.listview:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.gridview:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.recyclerview:
                    intent = new Intent(MainActivity.this, RecylerViewActivity.class);
                    break;
                case R.id.webview:
                    intent = new Intent(MainActivity.this, WebViewMainActivity.class);
                    break;
                case R.id.toast:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.alertdialog:
                    intent = new Intent(MainActivity.this, AlertDialogActivity.class);
                    break;
                case R.id.dialog:
                    intent = new Intent(MainActivity.this, DialogActivity.class);
                    break;
                case R.id.popup:
                    intent = new Intent(MainActivity.this, PopupActivity.class);
                    break;
                case R.id.jump:
                    intent = new Intent(MainActivity.this, JumpActivity.class);
                    break;
                case R.id.fragment:
                    intent = new Intent(MainActivity.this, com.example.lenovo.hello.fragment.FragmentActivity.class);
                    break;
                case R.id.touch:
                    intent = new Intent(MainActivity.this, TouchActivity.class);
                    break;
                case R.id.mysql:
                    intent = new Intent(MainActivity.this, MySQLActivity.class);
                    break;
                case R.id.bluetooth:
                    intent = new Intent(MainActivity.this, Bluetooth.class);
                    break;
                case R.id.handler:
                    intent = new Intent(MainActivity.this, HandlerActivity.class);
                    break;
                case R.id.framelayout:
                    intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
                    break;
                case R.id.progressbar:
                    intent = new Intent(MainActivity.this, LoginActivity.class);
                    break;
                case R.id.ratingbar:
                    intent = new Intent(MainActivity.this, RatingActivity.class);
                    break;
                case R.id.intentTest:
                    intent = new Intent(MainActivity.this, IntentActivity.class);
                    break;
                case R.id.myView:
                    intent = new Intent(MainActivity.this, MyViewActivity.class);
                    break;
                case R.id.Store:
                    intent = new Intent(MainActivity.this, StoreActivity.class);
                    break;
                case R.id.ServiceTest:
                    intent = new Intent(MainActivity.this, ServiceActivity.class);
                    break;
                case R.id.Paint:
                    intent = new Intent(MainActivity.this, PrintActivity.class);
                    break;
                case R.id.sensor:
                    intent = new Intent(MainActivity.this, SeneorActivity.class);
                    break;
                case R.id.baidumap:
                    intent = new Intent(MainActivity.this, MapSDKActivity.class);
                    break;
                case R.id.action_bar:
                    intent = new Intent(MainActivity.this, ActionBarActivity.class);
                    break;
                case R.id.notice:
                    intent = new Intent(MainActivity.this, NoticeActivity.class);
                    break;
                case R.id.toolbar:
                    intent = new Intent(MainActivity.this, ToolBarActivity.class);
                    break;
            }
            startActivity(intent);
            }
    }

}

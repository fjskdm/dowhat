package com.example.lenovo.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.hello.CustomRes.CustomDialog;
import com.example.lenovo.hello.util.ToastUtil;

public class DialogActivity extends AppCompatActivity {

    private Button btn_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        btn_1 = findViewById(R.id.btn);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialog customDialog = new CustomDialog(DialogActivity.this);
                customDialog.setTitle("标题").setMessage("内容")
                        .setCancel("取消", new CustomDialog.IOncancelListener() {
                            @Override
                            public void onCancel(CustomDialog dialog) {
                                ToastUtil.showMsg(DialogActivity.this,"取消成功");
                            }
                        }).setConfirm("确认", new CustomDialog.IOnconfirmListener() {
                    @Override
                    public void onConfirm(CustomDialog dialog) {
                        ToastUtil.showMsg(DialogActivity.this,"确认");
                    }
                }).show();
            }
        });
    }
}

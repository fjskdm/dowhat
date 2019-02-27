package com.example.lenovo.hello.CustomRes;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.lenovo.hello.R;

public class CustomDialog extends Dialog implements View.OnClickListener{

    private TextView tv_cancel;
    private TextView tv_confirm;
    private TextView tv_title;
    private TextView tv_message;
    private String title;
    private String message;
    private String cancel;
    private String confirm;
    private IOncancelListener iOncancelListener;
    private IOnconfirmListener iOnconfirmListener;


    public CustomDialog setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setCancel(String cancel,IOncancelListener listener) {
        this.cancel = cancel;
        this.iOncancelListener = listener;
        return this;
    }

    public CustomDialog setConfirm(String confirm,IOnconfirmListener listener) {
        this.confirm = confirm;
        this.iOnconfirmListener = listener;
        return this;
    }


    public CustomDialog(@NonNull Context context) {
        super(context);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog_myself);
        //设置长宽
        WindowManager m =getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        //宽度
        //p.width = (int) (size.x*0.8);
        //高度
        p.height = (int) (size.y*0.3);
        getWindow().setAttributes(p);

        tv_cancel = findViewById(R.id.cancel);
        tv_confirm = findViewById(R.id.confirm);
        tv_title = findViewById(R.id.tv_title);
        tv_message = findViewById(R.id.tv_message);
        if(!TextUtils.isEmpty(title)){
            tv_title.setText(title);
        }
        if(!TextUtils.isEmpty(message)){
            tv_message.setText(message);
        }
        if(!TextUtils.isEmpty(cancel)){
            tv_cancel.setText(cancel);
        }
        if(!TextUtils.isEmpty(confirm)){
            tv_confirm.setText(confirm);
        }
        tv_cancel.setOnClickListener(this);
        tv_confirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.cancel:
                if(iOncancelListener != null){
                    iOncancelListener.onCancel(this);
                }
                dismiss();
                break;
            case R.id.confirm:
                if(iOnconfirmListener != null){
                    iOnconfirmListener.onConfirm(this);
                }
                dismiss();
                break;
        }
    }

    public interface IOncancelListener{
        void onCancel(CustomDialog dialog);
    }

    public interface IOnconfirmListener{
        void onConfirm(CustomDialog dialog);
    }
}

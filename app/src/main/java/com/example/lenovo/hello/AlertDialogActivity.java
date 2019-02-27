package com.example.lenovo.hello;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lenovo.hello.util.ToastUtil;

public class AlertDialogActivity extends AppCompatActivity {

    private Button btn_1,btn_2,btn_3,btn_4,btn_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        btn_1 = findViewById(R.id.Btn_1);
        btn_2 = findViewById(R.id.Btn_2);
        btn_3 = findViewById(R.id.Btn_3);
        btn_4 = findViewById(R.id.Btn_4);
        btn_5 = findViewById(R.id.Btn_5);
        Onclick onclick = new Onclick();
        btn_1.setOnClickListener(onclick);
        btn_2.setOnClickListener(onclick);
        btn_3.setOnClickListener(onclick);
        btn_4.setOnClickListener(onclick);
        btn_5.setOnClickListener(onclick);
    }

    class Onclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case (R.id.Btn_1):
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder.setTitle("show the question").setMessage("show the message")
                            .setIcon(R.drawable.icon)
                            .setPositiveButton("good", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ToastUtil.showMsg(AlertDialogActivity.this,"show good");
                                }
                            }).setNeutralButton("just so so", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"show just");
                        }
                    }).setNegativeButton("bad", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,"show bad");
                        }
                    }).show();
                    break;
                case (R.id.Btn_2):
                    final String[] show2 = new String[]{"1","2","3","4"};
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder2.setTitle("choose").setItems(show2, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,show2[which]);
                        }
                    }).show();
                    break;
                case (R.id.Btn_3):
                    final String[] show3 = new String[]{"1","2","3","4"};
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder3.setTitle("choose").setSingleChoiceItems(show3, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ToastUtil.showMsg(AlertDialogActivity.this,show3[which]);
                            dialog.dismiss();
                        }
                    }).setCancelable(false).show();
                    break;
                case (R.id.Btn_4):
                    final String[] show4 = new String[]{"1","2","3","4"};
                    boolean[] chooseone = new boolean[]{false,false,true,false};
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    builder4.setTitle("choose").setMultiChoiceItems(show4, chooseone, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                            ToastUtil.showMsg(AlertDialogActivity.this,show4[which]+":"+isChecked);
                        }
                    }).show();
                    break;
                case (R.id.Btn_5):
                    final AlertDialog.Builder builder5 = new AlertDialog.Builder(AlertDialogActivity.this);
                    View view = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.activity_edit_text,null);
                    EditText etUsername = view.findViewById(R.id.ET_1);
                    EditText etPassword = view.findViewById(R.id.ET_2);
                    Button bt = view.findViewById(R.id.login_Button);
                    final AlertDialog alertDialog = builder5.setTitle("login").setView(view).show();
                    bt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss();
                            ToastUtil.showMsg(AlertDialogActivity.this,"show login");
                        }
                    });
                    break;
            }
        }

    }
}

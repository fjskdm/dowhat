package com.example.lenovo.hello;


import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.lenovo.hello.MySQLUse.SQLUtil;
import com.example.lenovo.hello.util.ToastUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public class MySQLActivity extends Activity {

    private static final String URL = "jdbc:mysql://119.29.230.33/test?serverTimezone=GMT&useSSL=false";
    private static final String USER = "bigartist";
    private static final String PASSWORD = "bigartist";

    private ListView lv_1;
    private Button btn_1,btn_2;
    private Connection conn;
    private Thread thread,thread1;
    private ArrayList<Map<String,String>> resultList = new ArrayList<Map<String,String>>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sql);
        btn_1 = findViewById(R.id.Btn_1);
        btn_2 = findViewById(R.id.Btn_2);
        lv_1 = findViewById(R.id.LV_1);



        /**
         *  点击一次后崩溃
         */
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                conn = SQLUtil.openConnection(URL,USER,PASSWORD);
                System.out.println("All users info:");
                resultList = SQLUtil.query(conn, "select * from do");
            }
        });


        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        conn = SQLUtil.openConnection(URL,USER,PASSWORD);
                        System.out.println("All users info:");
                        resultList = SQLUtil.query(conn, "select * from do");
                    }
                });
                thread.start();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (resultList == null || resultList.size() == 0) {
                        ToastUtil.showMsg(MySQLActivity.this, "没有结果");
                    } else {
                        SimpleAdapter simpleAdapter = new SimpleAdapter(MySQLActivity.this, resultList,
                                R.layout.layout_list_item,
                                new String[]{"id", "name"}, new int[]{
                                R.id.tv_title, R.id.tv_show});
                        lv_1.setAdapter(simpleAdapter);
                    }
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //弹出一个AlertDialog
                final AlertDialog.Builder builder5 = new AlertDialog.Builder(MySQLActivity.this);
                View view = LayoutInflater.from(MySQLActivity.this).inflate(R.layout.activity_edit_text,null);
                final android.widget.EditText etUsername1 = view.findViewById(R.id.ET_1);
                final EditText etPassword1 = view.findViewById(R.id.ET_2);
                Button bt1 = view.findViewById(R.id.login_Button);
                final AlertDialog alertDialog = builder5.setTitle("login").setView(view).show();

                final String[] name = {null};
                final String[] pass = {null};

                bt1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                name[0] = etUsername1.getText().toString();
                                pass[0] = etPassword1.getText().toString();
                                conn = SQLUtil.openConnection(URL,USER,PASSWORD);
                                System.out.print("正在创建新用户");
                                SQLUtil.creatNew(conn, name[0],pass[0]);
                            }
                        });
                        thread.start();
                        alertDialog.dismiss();
                    }
                });

            }
        });

    }

    public void onTest1(View view) {
//        这个按钮的实现方式可以点击无数次
    }

    public void onTest2(View view) {
        thread1.start();
//        这个按钮的实现方式只能点击一次
//        因为这个方法的线程没有被关闭
    }

    public void onUpdate(View view) {
        String sql = "update do set name='lilei' where name='hanmeimei'";
        SQLUtil.execSQL(conn, sql);
    }

//    public void onQuery() {
////        System.out.println("All users info:");
////        SQLUtil.query(conn, "select * from do");
//        thread.start();
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                conn = null;
            } finally {
                conn = null;
            }
        }
    }

}

package com.example.lenovo.hello;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ShareActionProvider;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.lenovo.hello.util.DBOpenUtil;
import com.example.lenovo.hello.util.ToastUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StoreActivity extends AppCompatActivity {

    private Button btn_1,btn_2,btn_3,btn_4;
    private ListView listView;
    private DBOpenUtil dbOpenUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        btn_1 = findViewById(R.id.Btn_1);
        btn_2 = findViewById(R.id.Btn_2);
        btn_3 = findViewById(R.id.Btn_3);
        btn_4 = findViewById(R.id.Btn_4);
        dbOpenUtil = new DBOpenUtil(StoreActivity.this,"db_main",null,1);//实例化一个Helper类来创建SQLite数据库
        listView = findViewById(R.id.LV_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder5 = new AlertDialog.Builder(StoreActivity.this);
                View view = LayoutInflater.from(StoreActivity.this).inflate(R.layout.activity_edit_text2,null);
                final android.widget.EditText etUsername = view.findViewById(R.id.ET_1);
                final EditText etPassword = view.findViewById(R.id.ET_2);
                Button bt = view.findViewById(R.id.login_Button);
                final SharedPreferences sp = getSharedPreferences("mysoft",MODE_PRIVATE);//获取shared preferences对象,name参数的名称是可以改的，不同的name读到的是不同的文件

                final AlertDialog alertDialog = builder5.setTitle("admin 密码：admin").setView(view).show(); //设置弹出一个AlertDialog
                    /********************************实现自动登录功能*********************************/
                String username = sp.getString("username",null);
                String password = sp.getString("password",null);
                if(username != null && password != null){
                    if(username.equals("admin")&&password.equals("admin")){//判断是否有保存的密码，这里可以使用其他的方法获得用户名和密码，之后放到equals里就行了
                        //这里是自动登录后执行的东西
                        ToastUtil.showMsg(StoreActivity.this,"已经自动登录admin");
                    }
                }else {
                    /***************************实现手动登录并存储账号密码****************************/
                    bt.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String in_username = etUsername.getText().toString();
                            String in_password = etPassword.getText().toString();
                            SharedPreferences.Editor editor = sp.edit();
                            if(in_username.equals("admin") && in_password.equals("admin")){//这里是判断账号密码是否正确，正确的话就继续运行
                                //上面那个判断可以使用不同的方法去获得账号密码，然后放到equals里面就行了
                                //下面的代码是保存到本地的SharedPreferences中
                                editor.putString("username",in_username);
                                editor.putString("password",in_password);
                                editor.commit();
                                ToastUtil.showMsg(StoreActivity.this,"已经保存账号密码");
                            }else{
                                ToastUtil.showMsg(StoreActivity.this,"账号或密码错误");
                            }
                            alertDialog.dismiss();//关闭AlertDialog
                            ToastUtil.showMsg(StoreActivity.this,"show login");
                        }
                    });
                }
            }
        });

        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final SharedPreferences sp = getSharedPreferences("mysoft",MODE_PRIVATE);//获取shared preferences对象
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username",null);
                editor.putString("password",null);
                editor.commit();
            }
        });

        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder5 = new AlertDialog.Builder(StoreActivity.this);
                View view = LayoutInflater.from(StoreActivity.this).inflate(R.layout.activity_edit_text1,null);
                final android.widget.EditText etUsername = view.findViewById(R.id.ET_1);
                Button bt = view.findViewById(R.id.login_Button);
                final AlertDialog alertDialog = builder5.setTitle("login").setView(view).show(); //设置弹出一个AlertDialog


                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = etUsername.getText().toString();
                        Cursor cursor = dbOpenUtil.getReadableDatabase().query("tb_main",null,"name=?",new String[]{name},null,null,null);
                        ArrayList<Map<String,String>> resultList = new ArrayList<Map<String,String>>();
                        while (cursor.moveToNext()){
                            Map<String,String> map = new HashMap<String, String>();
                            map.put("name",cursor.getString(1));
                            map.put("pass",cursor.getString(2));
                            resultList.add(map);
                        }
                        if(resultList == null || resultList.size() == 0){
                            ToastUtil.showMsg(StoreActivity.this,"没有记录");
                        }else {
                            SimpleAdapter simpleAdapter = new SimpleAdapter(StoreActivity.this,resultList,
                                    R.layout.layout_list_item,
                                    new String[]{"name","pass"},new int[]{
                                    R.id.tv_title,R.id.tv_show
                            });
                            alertDialog.dismiss();
                            listView.setAdapter(simpleAdapter);
                        }
                    }
                });
            }
        });

        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder5 = new AlertDialog.Builder(StoreActivity.this);
                View view = LayoutInflater.from(StoreActivity.this).inflate(R.layout.activity_edit_text,null);
                final android.widget.EditText etUsername = view.findViewById(R.id.ET_1);
                final EditText etPassword = view.findViewById(R.id.ET_2);
                Button bt = view.findViewById(R.id.login_Button);
                final AlertDialog alertDialog = builder5.setTitle("注册").setView(view).show(); //设置弹出一个AlertDialog

                bt.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = etUsername.getText().toString();
                        String pass = etPassword.getText().toString();
                        if(name.equals("") || pass.equals("")){
                            ToastUtil.showMsg(StoreActivity.this,"用户名或密码为空");
                        }else {
                            insertData(dbOpenUtil.getReadableDatabase(),name,pass);
                            ToastUtil.showMsg(StoreActivity.this,"注册成功");
                            alertDialog.dismiss();
                        }
                    }
                });
            }
        });
    }

    private void insertData (SQLiteDatabase sqLiteDatabase,String name,String pass){
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("pass",pass);//前面引号中的与数据表中一样
        sqLiteDatabase.insert("tb_main",null,contentValues);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(dbOpenUtil != null){
            dbOpenUtil.close();
        }
    }
}

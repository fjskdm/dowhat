package com.example.lenovo.hello;

import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class ActionBarActivity extends AppCompatActivity {

    private Button btn_1,btn_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar);
        final ActionBar actionBar = getSupportActionBar();
        btn_1 = findViewById(R.id.Btn_1);
        btn_2 = findViewById(R.id.Btn_2);
        actionBar.setTitle("Action Bar");
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionBar.show();
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionBar.hide();
            }
        });

        //判断父Activity是否为空
        if(NavUtils.getParentActivityName(ActionBarActivity.this) != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);//解析菜单文件
        return super.onCreateOptionsMenu(menu);
    }
}

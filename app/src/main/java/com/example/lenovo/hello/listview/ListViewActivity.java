package com.example.lenovo.hello.listview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lenovo.hello.R;

import java.util.ArrayList;

public class ListViewActivity extends Activity {
    private ListView lv_1;
    private String[] data={"4","2","3","4"};


    private ArrayList list = new ArrayList();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv_1 = findViewById(R.id.LV_1);
        lv_1.setAdapter(new MyListAdapter(ListViewActivity.this,data));
        lv_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"click"+position,Toast.LENGTH_SHORT).show();
            }
        });
        lv_1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this,"pressing"+position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}

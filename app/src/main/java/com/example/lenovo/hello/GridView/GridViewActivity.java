package com.example.lenovo.hello.GridView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.lenovo.hello.R;

public class GridViewActivity extends AppCompatActivity {
    private GridView gv_1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        gv_1 = findViewById(R.id.GV_1);
        gv_1.setAdapter(new MyGridAdapter(GridViewActivity.this));
        gv_1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"click"+position,Toast.LENGTH_SHORT).show();
            }
        });
        gv_1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this,"press"+position,Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}

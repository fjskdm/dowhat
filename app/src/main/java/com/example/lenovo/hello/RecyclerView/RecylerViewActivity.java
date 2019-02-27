package com.example.lenovo.hello.RecyclerView;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.hello.GridView.GridViewActivity;
import com.example.lenovo.hello.R;

public class RecylerViewActivity extends AppCompatActivity {
    private Button btn_1,btn_2,btn_3,btn_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);
        btn_1 = findViewById(R.id.btn_linear);
        btn_2 = findViewById(R.id.btn_hor);
        btn_3 = findViewById(R.id.btn_grid);
        btn_4 = findViewById(R.id.btn_pu);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecylerViewActivity.this,LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecylerViewActivity.this,HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecylerViewActivity.this,GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecylerViewActivity.this,PuRecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }
}

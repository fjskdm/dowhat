package com.example.lenovo.hello.RecyclerView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.lenovo.hello.R;

public class PuRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvpu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pu_recycler_view);
        mRvpu = findViewById(R.id.rv_pu);
        mRvpu.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRvpu.setAdapter(new PuAdapter(PuRecyclerViewActivity.this));
    }
}

package com.example.lenovo.hello.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Toast;

import com.example.lenovo.hello.R;

public class LinearRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_recycler_view);
        mRecycler = findViewById(R.id.RV_main);
        mRecycler.setLayoutManager(new LinearLayoutManager(LinearRecyclerViewActivity.this));
        mRecycler.addItemDecoration(new MyDecoration());
        mRecycler.setAdapter(new LinearAdapter(LinearRecyclerViewActivity.this));
    }

    class MyDecoration extends RecyclerView.ItemDecoration{
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,0,5);
        }
    }
}

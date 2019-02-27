package com.example.lenovo.hello;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBox extends AppCompatActivity {
    private android.widget.CheckBox cb_1,cb_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        cb_1 = findViewById(R.id.CB_5);
        cb_2 = findViewById(R.id.CB_6);
        cb_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBox.this,isChecked?"5选中":"5未选中",Toast.LENGTH_SHORT).show();
            }
        });
        cb_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBox.this,isChecked?"6选中":"6未选中",Toast.LENGTH_SHORT).show();
            }
        });
    }
}

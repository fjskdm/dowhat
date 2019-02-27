package com.example.lenovo.hello.jump;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.hello.R;

public class Jump2Activity extends AppCompatActivity {
    private TextView tv;
    private Button bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump2);
        tv = findViewById(R.id.tv_1);
        bt = findViewById(R.id.Btn_1);

        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("name");
        int num = bundle.getInt("number");
        tv.setText(name+","+num);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                Bundle bundle1 = new Bundle();
                bundle1.putString("title","come back");
                intent.putExtras(bundle1);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}

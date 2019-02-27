package com.example.lenovo.hello.jump;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lenovo.hello.R;

public class JumpActivity extends AppCompatActivity {
    private Button btn_1;
    private TextView tv_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        btn_1 = findViewById(R.id.Btn_jump);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //显式1
                Intent intent = new Intent(JumpActivity.this,Jump2Activity.class);
                Bundle bundle = new Bundle();
                bundle.putString("name","my name");
                bundle.putInt("number",15);
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent,0);
                //显式2
//                Intent intent = new Intent();
//                intent.setClass(JumpActivity.this,Jump2Activity.class);
//                startActivity(intent);
                //显式3
//                Intent intent = new Intent();
//                intent.setComponent(new ComponentName(JumpActivity.this,"com.example.lenovo.hello.jump.Jump2Activity"));
//                startActivity(intent);
                //显式4
//                Intent intent = new Intent();
//                intent.setClassName(JumpActivity.this,"com.example.lenovo.hello.jump.Jump2Activity");
//                startActivity(intent);
                //隐式1
//                Intent intent = new Intent();
//                intent.setAction("com.test");
//                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        tv_1 = findViewById(R.id.tv);
        String title = data.getExtras().getString("title");
        tv_1.setText(title);
    }
}

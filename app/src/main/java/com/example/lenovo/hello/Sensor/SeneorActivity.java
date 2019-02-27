package com.example.lenovo.hello.Sensor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lenovo.hello.R;

public class SeneorActivity extends AppCompatActivity {

    private Button btn_1,btn_2,btn_3,btn_4,btn_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seneor);
        btn_1 = findViewById(R.id.Btn_1);
        btn_2 = findViewById(R.id.Btn_2);
        btn_3 = findViewById(R.id.Btn_3);
        btn_4 = findViewById(R.id.Btn_4);
        btn_5 = findViewById(R.id.Btn_5);
        setListener();
    }

    private void setListener(){
        Listener listener = new Listener();
        btn_1.setOnClickListener(listener);
        btn_2.setOnClickListener(listener);
        btn_3.setOnClickListener(listener);
        btn_4.setOnClickListener(listener);
        btn_5.setOnClickListener(listener);
    }

    private class Listener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()){
                case R.id.Btn_1:
                    intent = new Intent(SeneorActivity.this,LocationActivity.class);
                    break;
                case R.id.Btn_2:
                    intent = new Intent(SeneorActivity.this,LightActivity.class);
                    break;
                case R.id.Btn_3:
                    intent = new Intent(SeneorActivity.this,MagneticActivity.class);
                    break;
                case R.id.Btn_4:
                    intent = new Intent(SeneorActivity.this,SpeedActivity.class);
                    break;
                case R.id.Btn_5:
                    intent = new Intent(SeneorActivity.this,OrientationActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }
}

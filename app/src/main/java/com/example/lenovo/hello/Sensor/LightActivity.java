package com.example.lenovo.hello.Sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lenovo.hello.EditText;
import com.example.lenovo.hello.R;

public class LightActivity extends AppCompatActivity implements SensorEventListener{

    private android.widget.EditText et_1;
    private SensorManager sensorManager;

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),SensorManager.SENSOR_DELAY_GAME);//2.获取传感器监听器3.设置获取的频率
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light);
        et_1 = findViewById(R.id.ET_1);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {//传感器的值变化时回调
        float[] values = event.values;
        int sensorType = event.sensor.getType();
        StringBuilder stringBuilder = null;
        if(sensorType == Sensor.TYPE_LIGHT){
            stringBuilder = new StringBuilder();
            stringBuilder.append("光的强度值:");
            stringBuilder.append(values[0]);
            et_1.setText(stringBuilder.toString());
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {//传感器精度改变时回调

    }
}

package com.example.lenovo.hello.Sensor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.lenovo.hello.R;

public class SpiritlevelView extends View implements SensorEventListener{
    private int MAX_ANGLE = 30;//最大倾斜角度
    private int bubble_x,bubble_y;
    private Bitmap bubble;
    float[] accelerometerValues = new float[3];
    float[] magneticValues = new float[3];
    public SpiritlevelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),SensorManager.SENSOR_DELAY_GAME);
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_GAME);
        bubble = BitmapFactory.decodeResource(getResources(), R.drawable.icon);

        }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            accelerometerValues = event.values.clone();
        }else if(event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
            magneticValues = event.values.clone();
        }
        float[] R = new float[9];//保存旋转数据
        float[] values = new float[3];
        SensorManager.getRotationMatrix(R,null,accelerometerValues,magneticValues);//获得一个包含旋转矩阵的R数组
        SensorManager.getOrientation(R,values);//获取方向值
        float xAngle = (float) Math.toDegrees(values[1]);
        float yAngle = (float) Math.toDegrees(values[2]);
        getPosition(xAngle,yAngle);
        super.postInvalidate();
    }

    private void getPosition(float xAngle, float yAngle) {
        int x = (super.getWidth() - bubble.getWidth())/2;
        int y = (super.getHeight() - bubble.getHeight())/2;

        if(Math.abs(yAngle) <= MAX_ANGLE){
            int deltaX = (int) ((super.getWidth() - bubble.getWidth())/2*yAngle / MAX_ANGLE);
            x -= deltaX;
        }else if(yAngle > MAX_ANGLE){
            x = 0;
        }else {
            x = super.getWidth() - bubble.getWidth();
        }

        if(Math.abs(xAngle) <= MAX_ANGLE){
            int deltaY = (int) ((super.getWidth() - bubble.getWidth())/2*xAngle / MAX_ANGLE);
            y += deltaY;
        }else if(xAngle > MAX_ANGLE){
            y = 0;
        }else {
            y = super.getWidth() - bubble.getWidth();
        }
        bubble_x = x;
        bubble_y = y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bubble,bubble_x,bubble_y,new Paint());
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

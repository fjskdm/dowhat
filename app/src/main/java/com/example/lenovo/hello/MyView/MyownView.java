package com.example.lenovo.hello.MyView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.example.lenovo.hello.MyViewActivity;
import com.example.lenovo.hello.R;

public class MyownView extends View {
    public float bitmapX,bitmapY;
    public MyownView(Context context) {
        super(context);
        bitmapX = 50;
        bitmapY = 50;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(MyownView.this.getResources(), R.drawable.icon);
        canvas.drawBitmap(bitmap,bitmapX,bitmapY,paint);
        if(bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}

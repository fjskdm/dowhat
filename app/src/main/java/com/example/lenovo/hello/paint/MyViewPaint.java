package com.example.lenovo.hello.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class MyViewPaint extends View {
    public MyViewPaint(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /**************************绘制一个安卓机器人****************************/
        Paint paint = new Paint();   //定义一个画笔
        paint.setAntiAlias(true);//抗锯齿
        paint.setColor(0xffa4c739);//前两位设置透明度，后六位rgb取色

        RectF rectF = new RectF(10,10,100,100);//定义外轮廓
        rectF.offset(90,20);//调整位置
        canvas.drawArc(rectF,-10,-160,false,paint);//绘制弧,1.指定图形的外轮廓 2.起始角度 3.圆弧扫过的角度 4.是否包括圆心 5.画笔

        paint.setColor(0xa0ffffff);
        canvas.drawCircle(165,53,4,paint);//1.2.圆心的位置,3.半径，4.画笔
        canvas.drawCircle(125,53,4,paint);

        paint.setColor(0xffa4c739);
        paint.setStrokeWidth(2);//设置笔触宽度
        canvas.drawLine(110,15,125,35,paint);//1.2.起始点，3.4.终止点
        canvas.drawLine(180,15,165,35,paint);

        canvas.drawRect(100,75,190,150,paint);//1.2.左上，3.4.右下
        RectF rectF1 = new RectF(100,140,190,160);
        canvas.drawRoundRect(rectF1,10,10,paint);//1.外轮廓 2.x轴的圆角半径 3.y轴的圆角半径

        RectF rectF_arm = new RectF(75,75,95,140);
        canvas.drawRoundRect(rectF_arm,10,10,paint);
        rectF_arm.offset(120,0);
        canvas.drawRoundRect(rectF_arm,10,10,paint);

        RectF rectF_leg = new RectF(115,150,135,200);
        canvas.drawRoundRect(rectF_leg,10,10,paint);
        rectF_leg.offset(40,0);
        canvas.drawRoundRect(rectF_leg,10,10,paint);


        /*******************************绘制对白********************************/
        paint.setColor(0xff000000);
        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(50);

        canvas.drawText("这是一段文字",250,200,paint);

        /******************************绘制位图**********************************/
        /*
        * BitmapFactory 可以通过图片文件创建；通过输入流创建
        * Bitmap 挖取一块图像创建；将源位图缩放生成；使用颜色数组创建
        * */

    }
}

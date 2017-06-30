package com.dukang.wang.mycontrolview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Author : wdk
 * @Email : a15939582085@126.com
 * created on : 2017/6/30 11:00
 * @Description :第一个自定义控件
 */

public class FirstView extends View {

    Context context;

    public FirstView(Context context) {
        this(context, null);
    }

    public FirstView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FirstView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        String text = "风萧萧兮，易水寒，壮士一去兮，不复还。";

        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
//        paint.setShadowLayer(30, 150, 150, Color.GRAY);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(3);
        paint.setTextSize(30);

        canvas.drawRGB(255, 255, 255);

        Paint paint2 = new Paint();
        paint2.setColor(Color.BLUE);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setShadowLayer(30, 150, 150, Color.GRAY);
        paint2.setAntiAlias(true);
        paint2.setStrokeWidth(5);
        paint2.setTextSize(25);


        /**
         * 画圆
         */
//        canvas.drawCircle(150, 150, 100, paint);

        /**
         * 画线
         */
//        canvas.drawLine(150,150,250,360,paint);
//        float[] pts = {150, 150, 250, 360, 250, 360, 690, 569};
//        canvas.drawLines(pts, paint);

        RectF rectF = new RectF(150, 200, 400, 300);
//        canvas.drawRoundRect(rectF,20,10,paint);
//        canvas.drawText("圆角矩形",275,250,paint2);

        /**
         * 画椭圆
         */
//        canvas.drawOval(rectF,paint);

//        canvas.drawArc(rectF,0,90,true,paint);


        /**
         * 按照路径绘制图形
         */
        Path path=new Path();
        path.moveTo(100,100);
        path.lineTo(100,200);
        path.lineTo(500,200);
        path.close();
        canvas.drawPath(path,paint);


//        Path ccwRectPath=new Path();
//        ccwRectPath.addRect(rectF, Path.Direction.CCW);//逆时针
//        canvas.drawPath(ccwRectPath,paint);
//        canvas.drawTextOnPath(text,ccwRectPath,0,0,paint2);


//        Path cwRectPath=new Path();
//        cwRectPath.addRect(rectF, Path.Direction.CW);//顺时针
//        canvas.drawPath(cwRectPath,paint);
//        canvas.drawTextOnPath(text,cwRectPath,0,-15,paint2);

//        paint.setStrikeThruText(true);//文字添加删除线
//        paint.setTextSkewX(0.25f);//设置文字倾斜
//        paint2.setTextSkewX(-0.25f);
//        canvas.drawText(text, 10, 100, paint);
//        canvas.drawText(text, 10, 200, paint2);
    }
}

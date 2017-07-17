package com.dukang.wang.mycontrolview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.dukang.wang.mycontrolview.R;

import java.util.Random;

/**
 * @Author : wdk
 * @Email : a15939582085@126.com
 * created on : 2017/6/30 11:00
 * @Description :第二个自定义控件
 */

public class SecondView extends View {
    private static final String TAG = "SecondView";

    private Context context;
    private Path path;
    private float preX, preY;
    private Paint paint;
    private int itemWaveLength = 800;
    private int dx;

    private Path path_tow;
    private float preX_tow, preY_tow;
    private Paint paint_tow;
    private int itemWaveLength_tow = 800;
    private int dx_tow;

    private Path path_rec;
    private Paint paint_rec;

    public SecondView(Context context) {
        this(context, null);
    }

    public SecondView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SecondView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        this.context = context;
        path = new Path();
        paint = new Paint();
        paint.setStrokeWidth(5f);
        paint.setAntiAlias(true);
        paint.setColor(getResources().getColor(R.color.rgb_aa_255_192_203));
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        path_tow = new Path();
        paint_tow = new Paint();
        paint_tow.setStrokeWidth(5f);
        paint_tow.setAntiAlias(true);
        paint_tow.setColor(getResources().getColor(R.color.rgb_255_192_203));
        paint_tow.setStyle(Paint.Style.FILL_AND_STROKE);

        path_rec = new Path();
        paint_rec = new Paint();
        paint_rec.setAntiAlias(true);
        paint_rec.setColor(getResources().getColor(R.color.rgb_255_192_203));
        paint_rec.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                preX = event.getX();
                preY = event.getY();
                path.moveTo(event.getX(), event.getY());
                Log.e(TAG, "onTouchEvent: " + event.getX() + "," + event.getY());
                return true;
            }

            case MotionEvent.ACTION_MOVE:
//                path.lineTo(event.getX(),event.getY());
                float endX = (preX + event.getX()) / 2;
                float endY = (preY + event.getY()) / 2;
                path.quadTo(preX, preY, endX, endY);
                preX = event.getX();
                preY = event.getY();
                Log.e(TAG, "onTouchEvent: " + event.getX() + ",move," + event.getY());
                postInvalidate();//重新绘制
                break;
            default:
                break;
        }


        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        path_tow.reset();
        int originY = 100;
        int halfWave = itemWaveLength / 2;

        path.moveTo(-itemWaveLength + dx, originY);
        for (int i = 0; i <= getWidth() / itemWaveLength + 1; i++) {
            path.rQuadTo(halfWave / 2, 50, halfWave, 0);
            path.rQuadTo(halfWave / 2, -50, halfWave, 0);
        }
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        path.close();
//
//        Path path = new Path();
//        path.moveTo(100, 300);//曲线的起点
//        path.quadTo(200, 200, 300, 300);//前面的坐标  200，200 是控制点  300,300是结束点
//        path.quadTo(400, 400, 500, 300);
        canvas.drawPath(path, paint);

        int originY_two = 100;
        int halfWave_two = itemWaveLength_tow / 2;
        path_tow.moveTo(-itemWaveLength_tow + dx_tow, originY_two);
        for (int i = 0; i <= getWidth() / itemWaveLength_tow + 1; i++) {
            path_tow.rQuadTo(halfWave_two / 2, 40, halfWave_two, 0);
            path_tow.rQuadTo(halfWave_two / 2, -40, halfWave_two, 0);
        }
        path_tow.lineTo(getWidth(), getHeight());
        path_tow.lineTo(0, getHeight());
        path_tow.close();
        canvas.drawPath(path_tow, paint_tow);

        canvas.drawRect(0, 140, getWidth(), 200, paint_rec);
    }

    public void startAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0, itemWaveLength);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e(TAG, "onAnimationUpdate: RepeatCount::"+animation.getCurrentPlayTime());
                dx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
        startAnim_two();
    }

    Random random = new Random(10);

    public int getRandom() {
        int a = 0;
        a = random.nextInt(10);

        Log.e(TAG, "getRandom: aaa:" + a);
        return a;
    }


    public void startAnim_two() {
        ValueAnimator animator = ValueAnimator.ofInt(0, itemWaveLength_tow);
        animator.setDuration(1500);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx_tow = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}

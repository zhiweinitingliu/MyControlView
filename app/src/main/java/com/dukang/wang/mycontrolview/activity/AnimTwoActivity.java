package com.dukang.wang.mycontrolview.activity;

import android.animation.ValueAnimator;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ViewTreeObserver;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;

import com.dukang.wang.mycontrolview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author : wdk
 * @Email : a15939582085@126.com
 * created on : 2017/6/29 15:04
 * @Description :动画第二篇
 */

public class AnimTwoActivity extends AppCompatActivity {
    private static final String TAG = "AnimTwoActivity";

    @BindView(R.id.imageView)
    ImageView imageView;
    int imageHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_tow);
        ButterKnife.bind(this);
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                imageHeight=imageView.getTop();
                Log.e(TAG, "onGlobalLayout: "+imageHeight);
            }
        });
    }

    @OnClick(R.id.btn_star)
    public void startAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 600);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) animation.getAnimatedValue();

                /**
                 * 控件的上下左右坐标
                 * *@param l Left position, relative to parent
                 * @param t Top position, relative to parent
                 * @param r Right position, relative to parent
                 * @param b Bottom position, relative to parent
                 */
                imageView.layout(imageView.getLeft(), imageHeight + curValue, imageView.getRight(), imageHeight + curValue + imageView.getHeight());
            }
        });
        valueAnimator.setDuration(1500);
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();
    }

}



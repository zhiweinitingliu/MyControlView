package com.dukang.wang.mycontrolview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.dukang.wang.mycontrolview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Author : wdk
 * @Email : a15939582085@126.com
 * created on : 2017/6/28 15:00
 * @Description :
 */

public class ViewOneActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewone);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.rb_scale)
    public void setScale() {
//        Animation scaleAnimation= AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1500);
        scaleAnimation.setFillBefore(true);
        scaleAnimation.setInterpolator(new BounceInterpolator());
        imageView.startAnimation(scaleAnimation);
    }

    @OnClick(R.id.rb_alpha)
    public void setAlpha() {
//        Animation alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1500);
        alphaAnimation.setInterpolator(new BounceInterpolator());
        alphaAnimation.setFillBefore(true);
        imageView.startAnimation(alphaAnimation);
    }

    @OnClick(R.id.rb_translate)
    public void setTranslate() {
        Animation translateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
        imageView.startAnimation(translateAnimation);
    }

    @OnClick(R.id.rb_roate)
    public void setRoate() {
        Animation rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_roate);
        imageView.startAnimation(rotateAnimation);
    }

    @OnClick(R.id.anim_set)
    public void setAnimSet() {
//        Animation setAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);

        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        scaleAnimation.setDuration(1500);
//        scaleAnimation.setFillBefore(true);
        scaleAnimation.setInterpolator(new BounceInterpolator());

        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//        alphaAnimation.setDuration(1500);
        alphaAnimation.setInterpolator(new BounceInterpolator());
//        alphaAnimation.setFillBefore(true);

        AnimationSet animationSet=new AnimationSet(true);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(1500);
        animationSet.setFillBefore(true);
        imageView.startAnimation(animationSet);
    }
}

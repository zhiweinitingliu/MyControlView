package com.dukang.wang.mycontrolview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.dukang.wang.mycontrolview.R;
import com.dukang.wang.mycontrolview.view.SecondView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @Author : wdk
 * @Email : a15939582085@126.com
 * created on : 2017/6/30 11:06
 * @Description :
 */

public class ViewSecondActivity extends AppCompatActivity {

    @BindView(R.id.secondView)
    SecondView secondView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_view);
        ButterKnife.bind(this);
        secondView.startAnim();
    }

}

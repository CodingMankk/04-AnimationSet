package com.oztaking.www.myanimation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

/**
 * @function:
 */

public class MyAnimationCodeImpl01 extends Activity implements View.OnClickListener{


    private Button mBtnacceleratedecelerate;
    private Button mBtnaccelerate;
    private Button mBtnanticipate;
    private Button mBtnbounce;
    private Button mBtnanticipateovershoot;
    private Button mBtncycle;
    private Button mBtndecelerate;
    private Button mBtnlinear;
    private Button mBtnovershoot;
    private TextView mTextView;
    private TranslateAnimation translateAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_interpolator_layout);

        initView();
    }

    private void initView() {
        mBtnacceleratedecelerate = (Button) findViewById(R.id.btn_accelerate_decelerate);
        mBtnaccelerate = (Button) findViewById(R.id.btn_accelerate);
        mBtnanticipate = (Button) findViewById(R.id.btn_anticipate);
        mBtnbounce = (Button) findViewById(R.id.btn_bounce);
        mBtnanticipateovershoot = (Button) findViewById(R.id.btn_anticipate_overshoot);
        mBtncycle = (Button) findViewById(R.id.btn_cycle);
        mBtndecelerate = (Button) findViewById(R.id.btn_decelerate);
        mBtnlinear = (Button) findViewById(R.id.btn_linear);
        mBtnovershoot = (Button) findViewById(R.id.btn_overshoot);

        mTextView = (TextView)findViewById(R.id.tv_textview);

        mBtnacceleratedecelerate.setOnClickListener(this);
        mBtnaccelerate.setOnClickListener(this);
        mBtnanticipate.setOnClickListener(this);
        mBtnbounce.setOnClickListener(this);
        mBtnanticipateovershoot.setOnClickListener(this);
        mBtncycle.setOnClickListener(this);
        mBtndecelerate.setOnClickListener(this);
        mBtnlinear.setOnClickListener(this);
        mBtnovershoot.setOnClickListener(this);

        translateAnimation = new TranslateAnimation(
                Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE,
                -80, Animation.ABSOLUTE,
                0, Animation.ABSOLUTE, -80);
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatCount(2);
        translateAnimation.setFillAfter(true);
        translateAnimation.setRepeatMode(Animation.RESTART);

    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btn_accelerate_decelerate:
                translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                mTextView.startAnimation(translateAnimation);
                break;
            case R.id.btn_accelerate:
                translateAnimation.setInterpolator(new AccelerateInterpolator());
                mTextView.startAnimation(translateAnimation);
                break;
            case R.id.btn_anticipate:
                translateAnimation.setInterpolator(new AnticipateInterpolator());
                mTextView.startAnimation(translateAnimation);
                break;
            case R.id.btn_bounce:
                translateAnimation.setInterpolator(new BounceInterpolator());
                mTextView.startAnimation(translateAnimation);
                break;
            case R.id.btn_anticipate_overshoot:
                translateAnimation.setInterpolator(new AnticipateInterpolator());
                mTextView.startAnimation(translateAnimation);
                break;

            case R.id.btn_cycle:
                translateAnimation.setInterpolator(new CycleInterpolator(3));
                mTextView.startAnimation(translateAnimation);
                break;
            case R.id.btn_decelerate:
                translateAnimation.setInterpolator(new DecelerateInterpolator());
                mTextView.startAnimation(translateAnimation);
                break;
            case R.id.btn_linear:
                translateAnimation.setInterpolator(new LinearInterpolator());
                mTextView.startAnimation(translateAnimation);
                break;

            case R.id.btn_overshoot:
                translateAnimation.setInterpolator(new OvershootInterpolator());
                mTextView.startAnimation(translateAnimation);
                break;
            default:
                break;
        }

    }
}

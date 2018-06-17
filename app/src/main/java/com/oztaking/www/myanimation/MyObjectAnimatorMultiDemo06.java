package com.oztaking.www.myanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MyObjectAnimatorMultiDemo06 extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnalpha;

    private Button mBtntranslateX;
    private Button mBtntranslateY;

    private Button mBtnrote;
    private Button mBtnroteX;
    private Button mBtnroteY;


    private Button mBtnscaleX;
    private Button mBtnscaleY;

    private TextView mTextView;

    private ImageView mImageView;

    private ObjectAnimator mAlphaTextView;
    private ObjectAnimator mAlphaImageView;

    private ObjectAnimator mRotationTextView;
    private ObjectAnimator mRotationImageView;
    private ObjectAnimator rotationXTV;
    private ObjectAnimator rotationXImageView;
    private ObjectAnimator rotationYTextView;
    private ObjectAnimator rotationYImageView;
    private ObjectAnimator translationXTextView;
    private ObjectAnimator translationXImageView;
    private ObjectAnimator translationYTextView;
    private ObjectAnimator translationYImageView;
    private ObjectAnimator scaleXTextView;
    private ObjectAnimator scaleXImageView;
    private ObjectAnimator scaleYTextView;
    private ObjectAnimator scaleYImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_objectanimatordemo_layout);

        initView();
    }

    private void initView() {
        mBtnalpha = (Button) findViewById(R.id.btn_alpha);

        mBtntranslateX = (Button) findViewById(R.id.btn_translateX);
        mBtntranslateY = (Button) findViewById(R.id.btn_translateY);

        mBtnrote = (Button) findViewById(R.id.btn_rote);
        mBtnroteX = (Button) findViewById(R.id.btn_roteX);
        mBtnroteY = (Button) findViewById(R.id.btn_roteY);

        mBtnscaleX = (Button) findViewById(R.id.btn_scaleX);
        mBtnscaleY = (Button) findViewById(R.id.btn_scaleY);


        mTextView = (TextView) findViewById(R.id.tv_textview);
        mImageView = (ImageView) findViewById(R.id.iv_performance);


        mBtnalpha.setOnClickListener(this);
        mBtntranslateX.setOnClickListener(this);
        mBtntranslateY.setOnClickListener(this);
        mBtnrote.setOnClickListener(this);
        mBtnroteX.setOnClickListener(this);
        mBtnroteY.setOnClickListener(this);
        mBtnscaleX.setOnClickListener(this);
        mBtnscaleY.setOnClickListener(this);


        //alpha的变化动画
        mAlphaTextView = ObjectAnimator.ofFloat(mTextView, "alpha", 1, 0, 1);
        mAlphaTextView.setDuration(2000);
        mAlphaTextView.setRepeatCount(3);
        mAlphaImageView = ObjectAnimator.ofFloat(mImageView, "alpha", 1, 0, 1);
        mAlphaImageView.setDuration(2000);
        mAlphaImageView.setRepeatCount(3);

        //rote的变化动画
        mRotationTextView = ObjectAnimator.ofFloat(mTextView, "rotation", 0, 360, 0);
        mRotationTextView.setDuration(2000);
        mRotationTextView.setRepeatCount(3);
        mRotationImageView = ObjectAnimator.ofFloat(mImageView, "rotation", 0, 360, 0);
        mRotationImageView.setDuration(2000);
        mRotationImageView.setRepeatCount(3);

        //roteX的变化动画
        rotationXTV = ObjectAnimator.ofFloat(mTextView, "rotationX", 0, 360, 0);
        rotationXTV.setDuration(2000);
        rotationXTV.setRepeatCount(3);
        rotationXImageView = ObjectAnimator.ofFloat(mImageView, "rotationX", 0, 360, 0);
        rotationXImageView.setDuration(2000);
        rotationXImageView.setRepeatCount(3);

        //roteY的变化动画
        rotationYTextView = ObjectAnimator.ofFloat(mTextView, "rotationY", 0, 180);
        rotationYTextView.setDuration(5000);
        rotationYTextView.setRepeatCount(-1);

        rotationYImageView = ObjectAnimator.ofFloat(mImageView, "rotationY", 0, 180);
        rotationYImageView.setDuration(1000);
        rotationYImageView.setRepeatCount(-1);
        rotationYImageView.setInterpolator(new AccelerateDecelerateInterpolator());
        rotationYImageView.setRepeatMode(ValueAnimator.REVERSE);

        //translate的变化动画
        translationXTextView = ObjectAnimator.ofFloat(mTextView, "translationX", 0, 300, -300, 0);
        translationXTextView.setDuration(2000);
        translationXTextView.setRepeatCount(3);
        translationXImageView = ObjectAnimator.ofFloat(mImageView, "translationX",0, 300, -300, 0);
        translationXImageView.setDuration(2000);
        translationXImageView.setRepeatCount(3);


        //translate的变化动画
        translationYTextView = ObjectAnimator.ofFloat(mTextView, "translationY", 0, 300, -300, 0);
        translationXTextView.setDuration(2000);
        translationYTextView.setRepeatCount(3);
        translationYImageView = ObjectAnimator.ofFloat(mImageView, "translationY", 0, 300, -300, 0);
        translationXImageView.setDuration(2000);
        translationYImageView.setRepeatCount(3);


        //scaleX的变化动画
        scaleXTextView = ObjectAnimator.ofFloat(mTextView, "scaleX", 0, 3, 1, 5);
        scaleXTextView.setDuration(2000);
        scaleXTextView.setRepeatCount(3);
        scaleXImageView = ObjectAnimator.ofFloat(mImageView, "scaleX", 0, 3, 1, 5);
        scaleXImageView.setDuration(2000);
        scaleXImageView.setRepeatCount(3);


        //scaleY的变化动画
        scaleYTextView = ObjectAnimator.ofFloat(mTextView, "scaleY", 0, 3, 1, 5);
        scaleYTextView.setDuration(2000);
        scaleYTextView.setRepeatCount(3);
        scaleYImageView = ObjectAnimator.ofFloat(mImageView, "scaleY",0, 3, 1, 5);
        scaleYImageView.setDuration(2000);
        scaleYImageView.setRepeatCount(3);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_alpha:
                mAlphaTextView.start();
                mAlphaImageView.start();
                break;
            case R.id.btn_translateX:
                translationXTextView.start();
                translationXImageView.start();
                break;
            case R.id.btn_translateY:
                translationYTextView.start();
                translationYImageView.start();
                break;
            case R.id.btn_rote:
                mRotationTextView.start();
                mRotationImageView.start();
                break;
            case R.id.btn_roteX:
                rotationXTV.start();
                rotationXImageView.start();
                break;
            case R.id.btn_roteY:
                rotationYTextView.start();
                rotationYImageView.start();
                break;
            case R.id.btn_scaleX:
                scaleXTextView.start();
                scaleXImageView.start();
                break;
            case R.id.btn_scaleY:
                scaleYTextView.start();
                scaleYImageView.start();
                break;

            default:
                break;
        }

    }
}

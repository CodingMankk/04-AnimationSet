package com.oztaking.www.myanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

/**
 * @function:
 */

public class MyViewCircleMenu09 extends Activity implements View.OnClickListener {

    private Button mBtnCircle1;
    private Button mBtnCircle2;
    private Button mBtnCircle3;
    private Button mBtnCircle4;
    private Button mBtnCircle5;
    private Button mBtnMenu;

    private boolean isMenuPressed = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_myviewcirclemenu_layout);
        initView();
    }

    private void initView() {
        mBtnCircle1 = (Button) findViewById(R.id.btn_circle1);
        mBtnCircle2 = (Button) findViewById(R.id.btn_circle2);
        mBtnCircle3 = (Button) findViewById(R.id.btn_circle3);
        mBtnCircle4 = (Button) findViewById(R.id.btn_circle4);
        mBtnCircle5 = (Button) findViewById(R.id.btn_circle5);
        mBtnMenu = (Button) findViewById(R.id.btn_menu);

        mBtnCircle1.setOnClickListener(this);
        mBtnCircle2.setOnClickListener(this);
        mBtnCircle3.setOnClickListener(this);
        mBtnCircle4.setOnClickListener(this);
        mBtnCircle5.setOnClickListener(this);
        mBtnMenu.setOnClickListener(this);

    }

    private void doStartAnimator(View v, int index, int total) {

        if (v.getVisibility() != View.VISIBLE) {
            v.setVisibility(View.VISIBLE);
        }
        float radius = 300;

        float degree = (float) (Math.toRadians(90) / (total - 1) * index);
        float transX = -(float) (radius * Math.sin(degree));
        float transY = -(float) (radius * Math.cos(degree));

        ObjectAnimator translationXView = ObjectAnimator.ofFloat(v, "translationX", 0,
                transX);
        ObjectAnimator translationYView = ObjectAnimator.ofFloat(v, "translationY", 0,
                transY);
        ObjectAnimator scaleXView = ObjectAnimator.ofFloat(v, "scaleX", 0, 1);
        ObjectAnimator scaleYView = ObjectAnimator.ofFloat(v, "scaleY", 0, 1);
        ObjectAnimator alphaView = ObjectAnimator.ofFloat(v, "alpha", 0, 1);

        AnimatorSet set = new AnimatorSet();
        set.play(translationXView)
                .with(translationYView)
                .with(scaleXView)
                .with(scaleYView)
                .with(alphaView);

        set.setDuration(500);
        set.setInterpolator(new AccelerateInterpolator());
        set.start();


    }

    private void doCloseAnimator(final View v, int index, int total) {

        if (v.getVisibility() != View.VISIBLE) {
            v.setVisibility(View.VISIBLE);
        }

        float radius = 300;
        //        float degree = (float) (Math.toRadians(90)/(total - 1) * index);

        float degree = (float) (Math.PI * index / ((total - 1) * 2));

        float transX = -(float) (radius * Math.sin(degree));
        float transY = -(float) (radius * Math.cos(degree));

        ObjectAnimator translationXView = ObjectAnimator.ofFloat(v, "translationX",
                transX, 0);
        ObjectAnimator translationYView = ObjectAnimator.ofFloat(v, "translationY",
                transY, 0);
//        ObjectAnimator scaleXView = ObjectAnimator.ofFloat(v, "scaleX", 1f, 0f);
//        ObjectAnimator scaleYView = ObjectAnimator.ofFloat(v, "scaleY", 1f, 0f);

        ObjectAnimator scaleXView = ObjectAnimator.ofFloat(v, "scaleX", 1f, 0.1f);
        ObjectAnimator scaleYView = ObjectAnimator.ofFloat(v, "scaleY", 1f, 0.1f);

        ObjectAnimator alphaView = ObjectAnimator.ofFloat(v, "alpha", 1f, 0f);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(
                translationXView,
                translationYView,
                scaleXView,
                scaleYView,
                alphaView);

        set.setDuration(500);
        set.setInterpolator(new AccelerateInterpolator());
        set.start();

        set.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                v.setScaleX(1.0f);
                v.setScaleY(1.0f);
            }

            @Override
            public void onAnimationCancel(Animator animation) {


            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_menu:
                Toast.makeText(getApplicationContext(), "btn_menu", Toast.LENGTH_SHORT).show();
                if (!isMenuPressed) {
                    isMenuPressed = true;
                    doStartAnimator(mBtnCircle1, 0, 5);
                    doStartAnimator(mBtnCircle2, 1, 5);
                    doStartAnimator(mBtnCircle3, 2, 5);
                    doStartAnimator(mBtnCircle4, 3, 5);
                    doStartAnimator(mBtnCircle5, 4, 5);
                } else {
                    isMenuPressed = false;
                    doCloseAnimator(mBtnCircle1, 0, 5);
                    doCloseAnimator(mBtnCircle2, 1, 5);
                    doCloseAnimator(mBtnCircle3, 2, 5);
                    doCloseAnimator(mBtnCircle4, 3, 5);
                    doCloseAnimator(mBtnCircle5, 4, 5);
                }
                break;

            case R.id.btn_circle1:
                Toast.makeText(getApplicationContext(), "btn_circle1", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_circle2:
                Toast.makeText(getApplicationContext(), "btn_circle2", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_circle3:
                Toast.makeText(getApplicationContext(), "btn_circle3", Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_circle4:
                Toast.makeText(getApplicationContext(), "btn_circle4", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn_circle5:
                Toast.makeText(getApplicationContext(), "btn_circle5", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }
}

package com.oztaking.www.myanimation.myponitcustomclassobject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.oztaking.www.myanimation.R;

/**
 * @function:
 */

public class MyViewLinearMenu09 extends Activity implements View.OnClickListener {

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

        setContentView(R.layout.activity_myviewlinearmenu_layout);
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

        int lenght = 750;
        int transY = -(lenght / total -1) * index;

        ObjectAnimator translationYView = ObjectAnimator.ofFloat(v, "translationY", 0,
                transY);
        ObjectAnimator scaleXView = ObjectAnimator.ofFloat(v, "scaleX", 0, 1);
        ObjectAnimator scaleYView = ObjectAnimator.ofFloat(v, "scaleY", 0, 1);
        ObjectAnimator alphaView = ObjectAnimator.ofFloat(v, "alpha", 0, 1);

        AnimatorSet set = new AnimatorSet();
        set.play(translationYView)
                .with(scaleXView)
                .with(scaleYView)
                .with(alphaView);

        set.setDuration(300);
        set.setInterpolator(new AccelerateInterpolator());
        set.start();

    }

    private void doCloseAnimator(View v, int index, int total) {

        if (v.getVisibility() != View.VISIBLE) {
            v.setVisibility(View.VISIBLE);
        }

        int lenght = 750;
        int transY = -(lenght / total -1) * index;

        ObjectAnimator translationYView = ObjectAnimator.ofFloat(v, "translationY",
                transY,0);
        ObjectAnimator scaleXView = ObjectAnimator.ofFloat(v, "scaleX", 1, 0);
        ObjectAnimator scaleYView = ObjectAnimator.ofFloat(v, "scaleY",1,0);
        ObjectAnimator alphaView = ObjectAnimator.ofFloat(v, "alpha", 1,0);

        AnimatorSet set = new AnimatorSet();
        set.play(translationYView)
                .with(scaleXView)
                .with(scaleYView)
                .with(alphaView);

        set.setDuration(300);
        set.setInterpolator(new AccelerateInterpolator());
        set.start();

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_menu:
                Toast.makeText(getApplicationContext(), "btn_menu", Toast.LENGTH_SHORT).show();
                if (!isMenuPressed) {
                    isMenuPressed = true;
                    doStartAnimator(mBtnCircle1, 1, 5);
                    doStartAnimator(mBtnCircle2, 2, 5);
                    doStartAnimator(mBtnCircle3, 3, 5);
                    doStartAnimator(mBtnCircle4, 4, 5);
                    doStartAnimator(mBtnCircle5, 5, 5);
                } else {
                    isMenuPressed = false;
                    doCloseAnimator(mBtnCircle1, 1, 5);
                    doCloseAnimator(mBtnCircle2, 2, 5);
                    doCloseAnimator(mBtnCircle3, 3, 5);
                    doCloseAnimator(mBtnCircle4, 4, 5);
                    doCloseAnimator(mBtnCircle5, 5, 5);
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

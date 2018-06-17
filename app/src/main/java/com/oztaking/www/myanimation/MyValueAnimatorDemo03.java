package com.oztaking.www.myanimation;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @function:https://blog.csdn.net/harvic880925/article/details/50525521
 */

public class MyValueAnimatorDemo03 extends Activity implements View.OnClickListener{

    private TextView mTvPerformance;
    private Button mBtnStart;
    private Button mBtnCancle;

    private ValueAnimator mValueAnimator;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tweenanimationlcationdemo_layout);

        initView();
    }

    private void initView() {
        mBtnStart = (Button) findViewById(R.id.btn_startTweenAnimation);
        mBtnCancle = (Button) findViewById(R.id.btn_cancelTweenAnimation);
        mTvPerformance = (TextView) findViewById(R.id.tv_animationPerformance);
        mBtnCancle.setOnClickListener(this);
        mBtnStart.setOnClickListener(this);



        //文本的点击监听
        mTvPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击文本了",Toast.LENGTH_SHORT).show();
            }
        });

        mValueAnimator = ValueAnimator.ofInt(0, 400);
        mValueAnimator.setDuration(5000);
        mValueAnimator.setRepeatCount(5);
        mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);

        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();

                mTvPerformance.layout(
                        currentValue,
                        currentValue,
                        currentValue+mTvPerformance.getWidth(),
                        currentValue+mTvPerformance.getHeight());
            }
        });



        mValueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("Demo03","onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("Demo03","onAnimationEnd");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("Demo03","onAnimationCancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("Demo03","onAnimationRepeat");
            }
        });

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
             case R.id.btn_startTweenAnimation:
//                 mValueAnimator.start();
                 mValueAnimator.setStartDelay(2000);
                 mValueAnimator.start();
                  break;

            case R.id.btn_cancelTweenAnimation:
                mValueAnimator.cancel();
//                mValueAnimator.removeAllListeners();
//                mValueAnimator.removeAllUpdateListeners();
                  break;
             default:
                  break;
        }
    }
}

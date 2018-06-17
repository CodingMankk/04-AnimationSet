package com.oztaking.www.myanimation;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

/**
 * @function:https://blog.csdn.net/harvic880925/article/details/50549385
 * 实现一个textView动态切换显示：a-z,速度不断的变快；
 */

public class MyValueAnimatorOfobjectDemo04 extends Activity implements View.OnClickListener{

    private TextView mTvPerformance;
    private Button mBtnStart;
    private Button mBtnCancle;

    private ValueAnimator mValueAnimator;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ofobjectdemo_layout);

        initView();
    }

    private void initView() {
        mBtnStart = (Button) findViewById(R.id.btn_startAnimation);
        mBtnCancle = (Button) findViewById(R.id.btn_cancelAnimation);
        mTvPerformance = (TextView) findViewById(R.id.tv_animationPerformance);
        mBtnCancle.setOnClickListener(this);
        mBtnStart.setOnClickListener(this);

        mValueAnimator = ValueAnimator.ofObject(
                new CharacterEvlator(),
                new Character('a'),
                new Character('z'));

        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char value = (char) animation.getAnimatedValue();
                mTvPerformance.setText(String.valueOf(value));
            }
        });
        mValueAnimator.setDuration(5000);
        //设置加速器
        mValueAnimator.setInterpolator(new AccelerateInterpolator());
    }


    private  class CharacterEvlator implements TypeEvaluator<Character>{

        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            //需要将字符串变换为int，然后再将int转换为char;
            int tempStartValue = (int)startValue;
            int tempEndValue = (int)endValue;
            return (char)(tempStartValue + (tempEndValue-tempStartValue)*fraction);
        }

    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
             case R.id.btn_startAnimation:
                 mValueAnimator.start();
                  break;

            case R.id.btn_cancelAnimation:
                mValueAnimator.cancel();
                mValueAnimator.removeAllListeners();
                mValueAnimator.removeAllUpdateListeners();
                  break;
             default:
                  break;
        }
    }
}

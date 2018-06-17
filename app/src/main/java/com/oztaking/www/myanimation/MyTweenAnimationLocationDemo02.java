package com.oztaking.www.myanimation;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @function:
 */

public class MyTweenAnimationLocationDemo02 extends Activity implements View.OnClickListener{


    private TextView mTvPerformance;
    private Button mBtnStart;
    private Button mBtnCancle;
    private TranslateAnimation animation;

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

        animation = new TranslateAnimation(
                Animation.ABSOLUTE, 0,
                Animation.ABSOLUTE,-80,
                Animation.ABSOLUTE,0,
                Animation.ABSOLUTE, -80

                );
        animation.setRepeatCount(3);
        animation.setDuration(1000);
        animation.setFillAfter(true);

        //文本的点击监听
        mTvPerformance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"点击文本了",Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
             case R.id.btn_startTweenAnimation:

                 mTvPerformance.startAnimation(animation);
                  break;

            case R.id.btn_cancelTweenAnimation:
                  break;
             default:
                  break;
        }
    }
}

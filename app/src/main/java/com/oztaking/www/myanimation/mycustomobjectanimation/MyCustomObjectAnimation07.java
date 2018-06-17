package com.oztaking.www.myanimation.mycustomobjectanimation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.oztaking.www.myanimation.R;

/**
 * @function:
 */

public class MyCustomObjectAnimation07 extends Activity implements View.OnClickListener {

    private Button mBtnStart;
    private Button mBtnCancle;
    private PointView mPointView;
    private ObjectAnimator mPointRadiusAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_myobjectainimatorcustomobjectanimation_layout);

        initView();
    }


    private void initView() {
        mBtnStart = (Button) findViewById(R.id.btn_startAnimation);
        mBtnCancle = (Button) findViewById(R.id.btn_cancelAnimation);
        mPointView = (PointView) findViewById(R.id.ponitView);

        mBtnCancle.setOnClickListener(this);
        mBtnStart.setOnClickListener(this);

        mPointRadiusAnimator = ObjectAnimator.ofInt(mPointView, "PointRadius", 50,200,100,50,0);
        mPointRadiusAnimator.setDuration(5000);
        mPointRadiusAnimator.setRepeatCount(3);
        mPointRadiusAnimator.setRepeatMode(ValueAnimator.REVERSE);


    }


    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btn_startAnimation:
                mPointRadiusAnimator.start();
                break;

            case R.id.btn_cancelAnimation:
                mPointRadiusAnimator.cancel();
                break;
            default:
                break;
        }
    }
}

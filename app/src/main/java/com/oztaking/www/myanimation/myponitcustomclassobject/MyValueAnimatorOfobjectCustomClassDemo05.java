package com.oztaking.www.myanimation.myponitcustomclassobject;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.oztaking.www.myanimation.R;

/**
 * @function:https://blog.csdn.net/harvic880925/article/details/50549385
 * 实现一个圆形的bounce效果；
 */

public class MyValueAnimatorOfobjectCustomClassDemo05 extends Activity implements View.OnClickListener{

    private Button mBtnStart;
    private Button mBtnCancle;

    private PointView mPointView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_ofobjectcustomclassdemo_layout);

        initView();
    }

    private void initView() {
        mBtnStart = (Button) findViewById(R.id.btn_startAnimation);
        mBtnCancle = (Button) findViewById(R.id.btn_cancelAnimation);
        mPointView = (PointView) findViewById(R.id.ponitView);

        mBtnCancle.setOnClickListener(this);
        mBtnStart.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
             case R.id.btn_startAnimation:
                 mPointView.startAnimator();
                  break;

            case R.id.btn_cancelAnimation:
               mPointView.cancelAnimator();
                  break;
             default:
                  break;
        }
    }


}

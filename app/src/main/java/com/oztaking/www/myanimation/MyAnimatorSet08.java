package com.oztaking.www.myanimation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @function:https://blog.csdn.net/harvic880925/article/details/50759059
 * 自定义控件三部曲之动画篇(九)——联合动画的代码实现
 *
 *
 */

public class MyAnimatorSet08 extends Activity implements View.OnClickListener{

    private Button mBtnStart;
    private Button mBtnCancle;

    private TextView mTv1;
    private TextView mTv2;
    private AnimatorSet mSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_myanimatorset_layout);

        initView();
    }


    private void initView() {
        mBtnStart = (Button) findViewById(R.id.btn_startAnimation);
        mBtnCancle = (Button) findViewById(R.id.btn_cancelAnimation);

        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);


        mBtnCancle.setOnClickListener(this);
        mBtnStart.setOnClickListener(this);


//        setPlaySequentilallyAnimator();
//        setPlayTogetherAnimator();

        setBuilderAnimator();




    }


    //顺序动画
    private void setPlaySequentilallyAnimator(){
        ObjectAnimator animator1Color = ObjectAnimator.ofInt(mTv1,"BackgroundColor",0xffff00ff, 0xffffff00, 0xffff00ff);

        ObjectAnimator animator1TransY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 500,0);
        animator1TransY.setRepeatCount(-1);
        ObjectAnimator animator2TransY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 500,0);

        mSet = new AnimatorSet();
        //        mSet.play(animator1Color).with(animator1TransY).with(animator2TransY);
        mSet.playSequentially(animator1Color,animator1TransY,animator2TransY);
        mSet.setDuration(1000);
    }

    //一起动画
    private void setPlayTogetherAnimator(){
        ObjectAnimator animator1Color = ObjectAnimator.ofInt(mTv1,"BackgroundColor",0xffff00ff, 0xffffff00, 0xffff00ff);
        animator1Color.setRepeatCount(-1);
        ObjectAnimator animator1TransY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 500,0);
        animator1TransY.setRepeatCount(-1);
        ObjectAnimator animator2TransY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 500,0);
        animator2TransY.setRepeatCount(-1);
        mSet = new AnimatorSet();
        //        mSet.play(animator1Color).with(animator1TransY).with(animator2TransY);
        mSet.playTogether(animator1Color,animator1TransY,animator2TransY);
        mSet.setDuration(1000);
    }

    //自由组合动画
    private void setBuilderAnimator(){
        ObjectAnimator animator1Color = ObjectAnimator.ofInt(mTv1,"BackgroundColor",0xffff00ff, 0xffffff00, 0xffff00ff);
        animator1Color.setRepeatCount(2);

        ObjectAnimator animator1TransY = ObjectAnimator.ofFloat(mTv1, "translationY", 0, 500,0);
        animator1TransY.setRepeatCount(1);
        animator1TransY.setStartDelay(2000);
        ObjectAnimator animator2TransY = ObjectAnimator.ofFloat(mTv2, "translationY", 0, 500,0);
        animator2TransY.setRepeatCount(1);

        mSet = new AnimatorSet();
//        mSet.play(animator1TransY).with(animator2TransY);
        mSet.play(animator2TransY).with(animator1TransY);
//        AnimatorSet.Builder builder = mSet.play(animator1TransY).with(animator2TransY);
//        builder.with(animator2TransY).with(animator1Color);
        //        mSet.playTogether(animator1Color,animator1TransY,animator2TransY);
        mSet.setDuration(1000);
        mSet.setStartDelay(2000);

//        mSet.setInterpolator(new BounceInterpolator());

        mSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Toast.makeText(getApplicationContext(),"onAnimationStart",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Toast.makeText(getApplicationContext(),"onAnimationEnd",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Toast.makeText(getApplicationContext(),"onAnimationCancel",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Toast.makeText(getApplicationContext(),"onAnimationRepeat",Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.btn_startAnimation:
                mSet.start();
                break;

            case R.id.btn_cancelAnimation:
                mSet.cancel();
                break;
            default:
                break;
        }
    }










}

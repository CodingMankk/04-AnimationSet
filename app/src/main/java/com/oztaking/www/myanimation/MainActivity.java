package com.oztaking.www.myanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mBtnalpha;
    private Button mBtntranslate;
    private Button mBtnrote;
    private Button mBtnscale;
    private Button mBtnset;
    private TextView mTextView;
    private Animation alphaanimation;
    private Animation roteanim;
    private Animation translationanim;
    private Animation scaleanim;
    private Animation setanim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_anim_layout);

        initView();
    }

    private void initView() {
        mBtnalpha = (Button) findViewById(R.id.btn_alpha);
        mBtntranslate = (Button) findViewById(R.id.btn_translate);
        mBtnrote = (Button) findViewById(R.id.btn_rote);
        mBtnscale = (Button) findViewById(R.id.btn_scale);
        mBtnset = (Button) findViewById(R.id.btn_set);

        mTextView = (TextView)findViewById(R.id.tv_textview);

        mBtnalpha.setOnClickListener(this);
        mBtntranslate.setOnClickListener(this);
        mBtnrote.setOnClickListener(this);
        mBtnscale.setOnClickListener(this);
        mBtnset.setOnClickListener(this);

        alphaanimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim
                .alphaanim);
        roteanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim
                .roteanim);
        translationanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim
                .translationanim);
        scaleanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim
                .scaleanim);
        setanim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim
                .setanim);


    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
             case R.id.btn_alpha:
                 mTextView.startAnimation(alphaanimation);
                  break;
            case R.id.btn_translate:
                mTextView.startAnimation(translationanim);
                break;
            case R.id.btn_rote:
                mTextView.startAnimation(roteanim);
                break;
            case R.id.btn_scale:
                mTextView.startAnimation(scaleanim);
                break;
            case R.id.btn_set:
                mTextView.startAnimation(setanim);
                break;


             default:
                  break;
        }

    }
}

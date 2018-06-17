package com.oztaking.www.myanimation.myponitcustomclassobject;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

/**
 * @function:
 */

public class PointView extends View {


    private Paint mPaint;
    private ValueAnimator mValueAnimator;
    private Point mCurrentRadius;

    public PointView(Context context) {
        super(context);
        initAnimator();
        initPaint();
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAnimator();
        initPaint();
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAnimator();
        initPaint();
    }
    private void initAnimator() {

        //init animator
        mValueAnimator = ValueAnimator.ofObject(new PointEvaluator(), new Point(0),
                new Point(300));
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentRadius = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });

        mValueAnimator.setDuration(5000);
        mValueAnimator.setRepeatCount(4);
        mValueAnimator.setInterpolator(new BounceInterpolator());
        mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.CYAN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mCurrentRadius != null) {
            canvas.drawCircle(352, 500, mCurrentRadius.getRadius(), mPaint);
        }
    }

    public void startAnimator() {
        mValueAnimator.start();
    }

    public void cancelAnimator() {
        mValueAnimator.cancel();
    }

    private class PointEvaluator implements TypeEvaluator<Point> {

        @Override
        public Point evaluate(float fraction, Point startValue, Point endValue) {
            float s = startValue.getRadius();
            float e = endValue.getRadius();

            return new Point(s + (e - s) * fraction);
        }
    }

    private class Point {

        float radius;

        public Point(float radius) {
            this.radius = radius;
        }

        public float getRadius() {
            return radius;
        }

        public void setRadius(float radius) {
            this.radius = radius;
        }

    }
}

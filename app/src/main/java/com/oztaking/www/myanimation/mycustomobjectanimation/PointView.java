package com.oztaking.www.myanimation.mycustomobjectanimation;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @function:
 */

public class PointView extends View {


    private Paint mPaint;

    Point mPoint = new Point(100);

    public PointView(Context context) {
        super(context);
        initPaint();
    }

    public PointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public PointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
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

            canvas.drawCircle(352, 500, mPoint.getRadius(), mPaint);
    }


    public void setPointRadius(int radius){
        mPoint.setRadius(radius);
        invalidate();
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

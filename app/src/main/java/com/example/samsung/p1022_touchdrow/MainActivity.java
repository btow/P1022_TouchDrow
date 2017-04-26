package com.example.samsung.p1022_touchdrow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private DrawView drawView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        drawView =new DrawView(this);
        drawView.setOnTouchListener(this);

        setContentView(drawView);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        DrawView dv = (DrawView) v;
        dv.mPoint.x = (int) event.getX();
        dv.mPoint.y = (int) event.getY();
        dv.invalidate();
        return true;
    }

    private class DrawView extends View {

        Paint mPaint;
        Rect mRect;
        Point mPoint;

        public DrawView(final Context context) {
            super(context);
            mPaint = new Paint();
            mRect = new Rect();
            mPoint = new Point(0, 0);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawARGB(80, 102, 204, 255);
            mPaint.setColor(Color.CYAN);
            mPaint.setStrokeWidth(5);
            mRect.set(mPoint.x - 50, mPoint.y - 50, mPoint.x + 50, mPoint.y + 50);
            canvas.drawRect(mRect, mPaint);
        }
    }
}

package com.core.lambdaapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.View;


public class FaultyView extends View {
    public FaultyView(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("This is a draw !");
        Paint paint = new Paint();
        canvas.drawRect(new Rect(20, 20, 20, 20), paint);
        // draw the mPath with the mPaint on the canvas when onDraw
        //canvas.drawPath(mPath, mPaint);

        Paint painti = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.parseColor("#FFA800"));


        Path path = new Path();

        path.moveTo(0, 0);
        path.lineTo(getWidth() / 2, 0);
        path.lineTo(getWidth(), getHeight()/2);
        path.lineTo(getWidth() / 2, getHeight());
        path.lineTo( 0, getHeight());
        path.lineTo( 0, 0);

        canvas.drawPath(path, painti);
            Rect rect = new Rect();
            this.getDrawingRect(rect);

            float[] verts = new float[8];
            verts[0] = rect.left - 50;
            verts[1] = rect.top + 30;

            verts[2] = rect.right + 20;
            verts[3] = rect.top + 40;

            verts[4] = rect.left;
            verts[5] = rect.bottom + 79;

            verts[6] = rect.right;
            verts[7] = rect.bottom - 40;

            int[] colors = new int[4];
            colors[0] = 0xFFFF0000;
            colors[1] = 0xFF00FF00;
            colors[2] = 0xFF0000FF;
            colors[3] = 0xFF000FF0;
            invalidate();

        }
}
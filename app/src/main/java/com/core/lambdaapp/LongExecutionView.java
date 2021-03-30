package com.core.lambdaapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;

public class LongExecutionView  extends View {

    private Bitmap bitmap;

    public LongExecutionView (MainActivity context) {
        super(context);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.face_aquamarine);
    }


    @Override
    protected void onDraw(Canvas c) {
        super.onDraw(c);

        drawBitmapMesh(c);
        System.out.println("This is a LongExecution draw !");
        // draw the mPath with the mPaint on the canvas when onDraw
        //canvas.drawPath(mPath, mPaint);
        invalidate();
    }

    private void drawBitmapMesh(Canvas c) {
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

        c.drawBitmapMesh(bitmap, 1, 1, verts, 0, colors, 0, null);
        invalidate();
    }
}
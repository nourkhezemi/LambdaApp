package com.core.lambdaapp;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

public class TrustedView extends View {
    public TrustedView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        System.out.println("This is a draw !");
        // draw the mPath with the mPaint on the canvas when onDraw
        //canvas.drawPath(mPath, mPaint);
        invalidate();
    }
}

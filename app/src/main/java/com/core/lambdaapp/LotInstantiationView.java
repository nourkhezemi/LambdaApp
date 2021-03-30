
package com.core.lambdaapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GRAY;

public class LotInstantiationView extends View {
    private static final double RADIUS = 5 ;
    private Rect mRectangle , rRec, R;
    private Paint mPaint,  LPaint;




    public LotInstantiationView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    


    public LotInstantiationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }


    public LotInstantiationView(Context context) {
        super(context);
        int x = 50;
        int y = 50;
        int sideLength = 200;


        // create a rectangle that we'll draw later
        mRectangle = new Rect(x, y, sideLength, sideLength);
        rRec = new Rect(x, y, sideLength, sideLength);
        R= new Rect(x, y, sideLength, sideLength);
        // create the Paint and set its color
        mPaint = new Paint();
        LPaint = new Paint();
        mPaint.setColor(GRAY);


        Paint paint = new Paint();
        RectF rect = new RectF();

        boolean drawing = false;
        float sweep = 0;

    }





    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(BLUE);
        canvas.drawRect(mRectangle,  mPaint);
        canvas.drawRect(rRec,  LPaint);
        canvas.drawRect(R,  LPaint);
        super.onDraw(canvas);

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




        System.out.println("This is LotInstantiationView draw !");
        invalidate();





}
    }

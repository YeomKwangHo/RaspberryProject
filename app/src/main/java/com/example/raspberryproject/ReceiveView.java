package com.example.raspberryproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by ±¤È£ on 2016-01-27.
 */
public class ReceiveView extends View {

    private Paint paint;
    private Canvas canvas;
    private int x, y, rad;

    public ReceiveView(Context context) {
        super(context);
    }

    public ReceiveView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ReceiveView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init()
    {
        paint = new Paint();
        canvas = new Canvas();

        paint.setColor(Color.RED);
        rad = 35; x = 35; y = 35;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x, y, rad, paint);
    }
}

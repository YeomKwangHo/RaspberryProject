package com.example.raspberryproject.receive;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by JISU on 2016-01-29.
 */
public class ButtonView extends View {

    public ButtonView(Context context) {
        super(context);
    }

    public ButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

       setMeasuredDimension(200, 200);
    }

    public float getDip(float value)
    {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();

        paint.setColor(Color.RED);

        canvas.drawCircle(100,100,100,paint);
    }


}

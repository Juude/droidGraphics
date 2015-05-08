package net.juude.droidgraphics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;


public class NTextView extends NView{
	private CharSequence mText; 
	private Paint mPaint;
	
    public NTextView(int width, int height) {
    	super(width, height);
    }
	public void setText(CharSequence text) {
		mText = text;
		mPaint = new Paint();
		mPaint.setColor(Color.BLACK);
	}

	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mPaint.setTextSize(40);
		canvas.drawText(mText.toString(), 0, 200, mPaint);
	};
}

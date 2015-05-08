package net.juude.droidgraphics;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;

@SuppressLint({ "DrawAllocation", "NewApi" })
public class NView {
	private int mWidth = 0;
	private int mHeight = 0;
	private int mMarginLeft;
	private int mMarginTop;
	private int mMarginRight;
	private int mMarginBottom;
	private int mBackgroundColor; 
    private Paint mPaint;
	
    public NView(int width, int height) {
    	mPaint = new Paint();
    	mWidth = width;
    	mHeight = height;
    }
    
    public NView() {
    	this(0, 0);
    }
	public void setBackgroundColor(int color) {
		mBackgroundColor = color;
	}
	
	
	public void setWidth(int width) {
		mWidth = width;
	}
	
	public int getmHeight() {
		return mHeight;
	}

	public void setmHeight(int mHeight) {
		this.mHeight = mHeight;
	}

	public int getmMarginLeft() {
		return mMarginLeft;
	}

	public void setmMarginLeft(int mMarginLeft) {
		this.mMarginLeft = mMarginLeft;
	}

	public int getmMarginTop() {
		return mMarginTop;
	}

	public void setmMarginTop(int mMarginTop) {
		this.mMarginTop = mMarginTop;
	}

	public int getmMarginRight() {
		return mMarginRight;
	}

	public void setmMarginRight(int mMarginRight) {
		this.mMarginRight = mMarginRight;
	}

	public int getmMarginBottom() {
		return mMarginBottom;
	}

	public void setmMarginBottom(int mMarginBottom) {
		this.mMarginBottom = mMarginBottom;
	}

	public void setHeight(int height) {
		mHeight = height;
	}
	
	public void setMargin(int left, int top, int right, int bottom) {
		mMarginLeft = left;
		mMarginTop = top;
		mMarginRight = right;
		mMarginBottom = bottom;
	}
	
	public void onDraw(Canvas canvas) {
		canvas.save();
		canvas.translate(mMarginLeft, mMarginTop);
		canvas.clipRect(0, 0 , mWidth, mHeight);
		canvas.drawColor(mBackgroundColor);
		dispatchDraw(canvas);
		canvas.restore();
	}

	public void dispatchDraw(Canvas canvas) {

	}

}

package net.juude.droidgraphics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

public class NParentView extends View {

	private NViewGroup mViewGroup;
	public NParentView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mViewGroup = new NViewGroup();
	}

	public NParentView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public NParentView(Context context) {
		this(context, null, 0);
	}

	@SuppressLint("WrongCall")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		mViewGroup.setWidth(500);
		mViewGroup.setHeight(400);
		mViewGroup.setBackgroundColor(Color.RED);
		mViewGroup.setMargin(100, 200, 0, 0);
		
		NTextView textView = new NTextView(400, 500);
		textView.setBackgroundColor(Color.BLUE);
		textView.setText("你好啊");
		mViewGroup.addView(textView);
		
		mViewGroup.onDraw(canvas);

	}

}

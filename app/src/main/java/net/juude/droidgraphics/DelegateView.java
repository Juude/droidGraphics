package net.juude.droidgraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
//import android.view.HardwareCanvas;
//import android.view.RenderNode;
import android.widget.LinearLayout;

/*
 * A view to hook state of view cycle
 * */
public class DelegateView extends LinearLayout{

	private static final String TAG = "DelegateView";

	private Paint mPaint = null;
	public DelegateView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mPaint = new Paint();
	}

	public DelegateView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}
	
	public DelegateView(Context context) {
		this(context, null, 0);
	}
	
	
	
	@Override
	protected void dispatchDraw(Canvas canvas) {
		Log.d(TAG, "", new Throwable());
		super.dispatchDraw(canvas);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Log.d(TAG , "onDraw canvas : @" + System.identityHashCode(canvas) + "name " + this.getTag() + "   type :" + canvas.getClass().getName());

		
//		super.onDraw(canvas);
//		this.getHardwareRenderer();
//		RenderNode node = RenderNode.create("juude", this);
//		HardwareCanvas hCanvas = node.start(200, 500);
//		mPaint.setStyle(Style.FILL);
//		mPaint.setColor(Color.RED);
//		hCanvas.drawRect(0, 0, 100, 200,mPaint);
//		hCanvas.drawColor(Color.RED);
//		Log.d(TAG, "hCanvas : " + hCanvas.getWidth() + "  " + hCanvas.getHeight());
//		node.end(hCanvas);
//		HardwareCanvas hardwareCanvas = (HardwareCanvas)canvas;
//		Log.d(TAG, "beforedrawRenderNode valid : " + node.isValid());
//
//		Log.d(TAG, "hardwareCanvas : " + hardwareCanvas.getWidth() + "  " + hardwareCanvas.getHeight());
//
//		hardwareCanvas.insertReorderBarrier();
//		hardwareCanvas.drawRenderNode(node);
//		hardwareCanvas.insertInorderBarrier();
//		Log.d(TAG, "afterdrawRenderNode  validx" + node.isValid());
	}	
	
}

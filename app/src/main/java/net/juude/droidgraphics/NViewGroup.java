package net.juude.droidgraphics;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.graphics.Canvas;

public class NViewGroup extends NView{

	private List<NView> mChildren;
	
	public NViewGroup() {
		
	}
	
	@Override
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}
	
	@SuppressLint("WrongCall")
	@Override
	public void dispatchDraw(Canvas canvas) {
		if(mChildren == null) {
			return;
		}
		for(NView view : mChildren) {
			view.onDraw(canvas);
		}
	}
	
	public void addView(NView v) {
		if(mChildren == null) {
			mChildren = new ArrayList<NView>();
		}
		mChildren.add(v);
	}

	
}

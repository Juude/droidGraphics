package net.juude.droidgraphics.spotlight;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * Created by juude on 15-5-21.
 */
public class RoundedViewGroupFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        RoundViewGroup viewGroup = new RoundViewGroup(getActivity());
        View v = new View(getActivity());
        v.setBackgroundColor(Color.RED);
        viewGroup.addView(v, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return viewGroup;
    }

    public static class RoundViewGroup extends FrameLayout {
        public RoundViewGroup(Context context) {
            super(context);
        }

        @Override
        public void draw(Canvas canvas) {
            int count = canvas.save();
            canvas.clipRect(100, 100, 300, 400);
            super.draw(canvas);
            canvas.restore();
        }

//        @Override
//        protected void dispatchDraw(Canvas canvas) {
//            int count = canvas.save();
//            Path path = new Path();
//            path.addRoundRect(0, 0, canvas.getWidth(), canvas.getHeight(), 20,20, null);
//            path.close();
//            canvas.clipPath(path);
//            super.dispatchDraw(canvas);
//            canvas.restoreToCount(count);
//        }


    }
}




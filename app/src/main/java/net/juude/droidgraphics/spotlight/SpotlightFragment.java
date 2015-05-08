package net.juude.droidgraphics.spotlight;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import net.juude.droidgraphics.R;

import java.io.IOException;
import java.io.InputStream;


/**
 * Created by juude on 15-4-1.
 */
public class SpotlightFragment extends Fragment {
    private static final String TAG = "SpotlightFragment";
    private FloatingActionsMenu mFloating;
    private FloatingActionButton mClipAction;
    private Bitmap mBitmap;
    private MainView mMainView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup)inflater.inflate(R.layout.fragment_spotlight, null);
        mFloating = (FloatingActionsMenu) v.findViewById(R.id.float_menu);
        mClipAction = (FloatingActionButton) mFloating.findViewById(R.id.clip_action);
        mClipAction.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mFloating.setVisibility(View.GONE);
                drawWithClip();
            }
        });

        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.photo);
        
        try {
            InputStream is = getResources().getAssets().open("photo.png");
            mBitmap = BitmapFactory.decodeStream(is);
            is.close();
       } catch (IOException e) {
            Log.e(TAG, "", e);
            getActivity().finish();
        }

        mMainView = new MainView(getActivity(), mBitmap);
        v.addView(mMainView, 0);
        return v;
    }

    private void drawWithClip() {
        mMainView.startAnimation();
    }

    class MainView extends View{
        private Paint mPaint;
        private Bitmap mBitmap;
        private Animator mAnimator;
        float mX = 0;
        float mY = 0;
        private float mRadius = 70 * getResources().getDisplayMetrics().density;
        private RectF mLayerRect;

        private Animator createAnimator() {
            ValueAnimator mToRightAnimator = ValueAnimator.ofFloat(0f, getWidth() - 2 * mRadius);
            mToRightAnimator.setDuration(800);
            mToRightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mX = (Float)animation.getAnimatedValue();
                    mY = 0f;
                    postInvalidateOnAnimation();
                }
            });
            ValueAnimator mToCenterAnimator = ValueAnimator.ofFloat(getWidth() - 2 * mRadius , getWidth()/2 - mRadius);
            mToCenterAnimator.setDuration(800);
            mToCenterAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mX = (Float)animation.getAnimatedValue();
                    mY = getHeight() / 2 * animation.getCurrentPlayTime() / animation.getDuration();
                    postInvalidateOnAnimation();
                }
            });
            final AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(mToRightAnimator, mToCenterAnimator);
            animatorSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    setWillNotDraw(false);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    setWillNotDraw(true);
                    animatorSet.start();
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            return animatorSet;
        }

        public void startAnimation() {
            if(mAnimator == null) {
                mAnimator = createAnimator();
            }
            mAnimator.start();
        }

        public MainView(Context context, Bitmap bitmap) {
            super(context);
            mPaint = new Paint();
            mBitmap = bitmap;
            mLayerRect = new RectF();
            setWillNotDraw(true);
            //setLayerType(View.LAYER_TYPE_S, null);
        }
        
        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
//            int count = canvas.save();
            Log.d(TAG, "mX : " + mX + " mY" + mY + " playTime : ");
            Log.d(TAG, "width : " + getWidth() + "  bitmap width : " + mBitmap.getWidth());
//            mLayerRect.set(mX, mY, mX + 2* mRadius, getHeight());
//            mX = getWidth()/2 - mRadius;
//            mY = getHeight() /2 - mRadius;
            mLayerRect.set(0, 0, getWidth(), getHeight());

            boolean withAlpha = false;
            if (withAlpha) {
                canvas.saveLayerAlpha(mLayerRect, 122,
                        Canvas.ALL_SAVE_FLAG
                );
            }
            else {
                canvas.saveLayer(mLayerRect, null,
                        Canvas.MATRIX_SAVE_FLAG |
                        Canvas.CLIP_SAVE_FLAG |
                        Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                        Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                        Canvas.CLIP_TO_LAYER_SAVE_FLAG);
            }

            mPaint.setXfermode(null);
            canvas.drawCircle(mX + mRadius, mY + mRadius, mRadius, mPaint);
            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(mBitmap, 0f, 0f, mPaint);
            canvas.restore();
        }
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop");
        mFloating.collapse();
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }
}

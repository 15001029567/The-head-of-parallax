package com.example.yanshi.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.ListView;

public class PullListView extends ListView {

	public PullListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public PullListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public PullListView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	ImageView imageView;
	private int imageHeight;
	private int imageViewHeight;
	private int maxHeight;
	@SuppressLint("NewApi")
	public void setPullListView(ImageView imageview){
		this.imageView=imageview;
		imageView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			

			@Override
			public void onGlobalLayout() {
				imageView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
				imageHeight = imageView.getDrawable().getIntrinsicHeight();
				imageViewHeight = imageView.getHeight();
				if (imageHeight>imageViewHeight) {
					maxHeight=imageHeight;
				}else {
					maxHeight=imageHeight*2;
				}
			}
		});
	}
	@SuppressLint("NewApi")
	@Override
	protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
			int scrollY, int scrollRangeX, int scrollRangeY,
			int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
		// TODO Auto-generated method stub
		if (deltaY<0 && isTouchEvent) {
			int newHeight =imageView.getHeight()-deltaY/2;
			if (newHeight>maxHeight) {
				newHeight=maxHeight;
			}
			imageView.getLayoutParams().height=newHeight;
			imageView.requestLayout();
		}
		return super.overScrollBy(deltaX, deltaY, scrollX, scrollY, scrollRangeX,
				scrollRangeY, maxOverScrollX, maxOverScrollY, isTouchEvent);
	}
	
	@SuppressLint("NewApi")
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if (ev.getAction()==MotionEvent.ACTION_UP) {
			ValueAnimator valueAnimator = ValueAnimator.ofInt(imageView.getHeight(),imageViewHeight);
			valueAnimator.addUpdateListener(new AnimatorUpdateListener() {
				
				@Override
				public void onAnimationUpdate(ValueAnimator animation) {
					int animatedValue = (Integer) animation.getAnimatedValue();
					imageView.getLayoutParams().height=animatedValue;
					imageView.requestLayout();
				}
			});
			valueAnimator.setDuration(300);
			valueAnimator.setInterpolator(new OvershootInterpolator());
			valueAnimator.start();
		}
		
		return super.onTouchEvent(ev);
//		return true;
	}
}

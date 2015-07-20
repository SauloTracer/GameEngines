package com.examplo.game_engine;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.view.View;

public class GEView extends View {
	private Point mDimensions = new Point();
	private boolean mHasStarted;

	private GEWatch mWatch = new GEWatch();

	private GEImageFactory mImageFactory;

	private GERenderer mRenderer;

	public GEView(Context context) {
		super(context);
		mImageFactory = new GEImageFactory(context);
		mRenderer = new GERenderer();
	}

	public Point getDimensions() {
		return mDimensions;
	}

	public void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLUE);
		step(canvas, mWatch.tick());
		invalidate();
	}

	public void step(Canvas canvas, float intervaloTempo) {

	}

	@Override
	protected void onSizeChanged(int width, int height, int oldWidth, int oldHeight) {
		mDimensions.set(width, height);
		if (!mHasStarted) {
			setup();
			mHasStarted = true;
		}
	}

	protected void setup() {
	}

	public GEImageFactory getImageFactory() {
		return mImageFactory;
	}

	public GERenderer getRenderer() {
		return mRenderer;
	}

}

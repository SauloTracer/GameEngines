package com.examplo.game_engine;

import java.util.ArrayList;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class GEInputPublicador implements GestureDetector.OnGestureListener {
	protected GestureDetector mGestureDetector = null;
	protected ArrayList<GEInputAssinante> mAssinantes = new ArrayList<GEInputAssinante>();

	public GEInputPublicador(Context context) {
		mGestureDetector = new GestureDetector(context, this);
	}

	public void registerAssinante(GEInputAssinante assinante) {
		mAssinantes.add(assinante);
	}

	public void unregisterAssinante(GEInputAssinante assinante) {
		mAssinantes.remove(assinante);
	}

	public boolean onTouchEvent(MotionEvent event) {
		int action = event.getActionMasked();
		if (action == MotionEvent.ACTION_UP) {
			for (int i = 0; i < mAssinantes.size(); i++) {
				mAssinantes.get(i).onUp(event);
			}
			return true;
		}
		return mGestureDetector.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent event) {
		for (int i = 0; i < mAssinantes.size(); i++) {
			mAssinantes.get(i).onDown(event);
		}
		return true;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocity,
			float velocityY) {
		return true;
	}

	@Override
	public void onLongPress(MotionEvent e) {
	}

	@Override
	public void onShowPress(MotionEvent e) {
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		return true;
	}

	@Override
	public boolean onScroll(MotionEvent downMove, MotionEvent moveMove,
			float distanceX, float distanceY) {
		for (int i = 0; i < mAssinantes.size(); i++) {
			mAssinantes.get(i).onScroll(downMove, moveMove, distanceX,
					distanceY);
		}
		return true;
	}

}

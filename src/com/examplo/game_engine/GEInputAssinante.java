package com.examplo.game_engine;

import android.view.MotionEvent;

public interface GEInputAssinante {
	public void onDown (MotionEvent event);
    
    public void onScroll(MotionEvent downEvent, MotionEvent moveEvent, float distanceX, float distanceY);

    public void onUp(MotionEvent event);

}

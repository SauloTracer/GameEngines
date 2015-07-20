package com.examplo.game_engine;

import android.graphics.Point;
import android.graphics.RectF;

public class GEMundo {
	private Point mDimensions;

	public GEMundo(Point tamanhoMundo) {
		mDimensions = new Point(tamanhoMundo);
	}

	public void step(float intervaloTempo) {
	}

	public void setup() {
	}

	public Point getDimensions() {
		return mDimensions;
	}

    public boolean collisionTest (RectF R1, RectF R2){
        return (R1.left < R2.right) &&
                     (R1.right > R2.left) &&
                     (R1.top < R2.bottom) &&
                     (R1.bottom > R2.top);
 }

}


package com.examplo.game_engine;

import java.util.ArrayList;

import android.graphics.PointF;
import android.graphics.RectF;

public class GETrigger extends GEEntidade {

	private ArrayList<GEEntidade> mObserverdEntities = new ArrayList<GEEntidade>();

	public GETrigger(GEMundo mundo, int id, PointF position, PointF dimensions) {
		super(mundo, id, "trigger", position, dimensions);
	}

	public boolean addObservedEntity(GEEntidade entidade) {
		if (mObserverdEntities.contains(entidade)) {
			return false;
		} else {
			mObserverdEntities.add(entidade);
			return true;
		}
	}

	public boolean removeObservedEntity(GEEntidade entidade) {
		return mObserverdEntities.remove(entidade);
	}

	public void onHit(GEEntidade entity, float elapsedTimeInSeconds) {
	}

	@Override
	public void step(float elapsedTimeInSeconds) {
		GEEntidade entidadeCorrente;
		GEMundo mundo = getMundo();
		RectF triggerBoundinBox = getBoundingBox();
		int arraySize = mObserverdEntities.size();
		for (int i = 0; i < arraySize; i++) {
			entidadeCorrente = mObserverdEntities.get(i);
			if (mundo.collisionTest(triggerBoundinBox,
					entidadeCorrente.getBoundingBox())) {
				onHit(entidadeCorrente, elapsedTimeInSeconds);
			}
		}
	}
}
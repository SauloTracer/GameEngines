package com.examplo.game_engine;

import android.graphics.PointF;
import android.graphics.RectF;

public class GEEntidade {
	private String mCategory; // Define a qual grupo a entidade pertence

	private PointF mDimensions = new PointF(); // largura e altura
	private int mId; // identificação única da entidade
	private boolean mIsActive = true; // se a entidade está ativa e deve ter as
										// interações calculadas
	protected PointF mPosition = new PointF(); // posição da entidade (canto
												// superior esquerdo)
	private GEMundo mMundo; // mundo ao qual a entidade pertence

	protected RectF mBBoxPadding = new RectF();
	protected RectF mBoundingBox = new RectF();

	private int mFlags;

	public GEEntidade(GEMundo mundo, int id, String category, PointF position,
			PointF dimensions) {
		mMundo = mundo;
		mId = id;
		mCategory = category;
		mPosition.set(position);
		mDimensions.set(dimensions);
		_updateBoundingBox();
	}

	public void move(float offsetX, float offsetY) {
		mPosition.x += offsetX;
		mPosition.y += offsetY;
		_updateBoundingBox();
	}

	public void step(float elapsedTimeInSeconds) {
	}

	public String getCategory() {
		return mCategory;
	}

	public PointF getDimensions() {
		return mDimensions;
	}

	public int getId() {
		return mId;
	}

	public PointF getPosition() {
		return mPosition;
	}

	public GEMundo getMundo() {
		return mMundo;
	}

	public boolean isActive() {
		return mIsActive;
	}

	public void setDimensions(float x, float y) {
		mDimensions.set(x, y);
	}

	public void setDimensions(PointF dimensions) {
		mDimensions.set(dimensions);
	}

	public void setIsActive(boolean isActive) {
		mIsActive = isActive;
	}

	public void setPosition(float x, float y) {
		mPosition.set(x, y);
		_updateBoundingBox();
	}

	public void setPosition(PointF dimensions) {
		mPosition.set(dimensions);
		_updateBoundingBox();
	}

	private void _updateBoundingBox() {
		mBoundingBox.set(mPosition.x + mBBoxPadding.left, mPosition.y
				+ mBBoxPadding.top, (mPosition.x + mDimensions.x)
				- mBBoxPadding.right, (mPosition.y + mDimensions.y)
				- mBBoxPadding.bottom);
	}

	public void setBBoxPadding(RectF padding) {
		mBBoxPadding.set(padding);
		_updateBoundingBox();
	}

	public RectF getBoundingBox() {
		return mBoundingBox;
	}

	public RectF getBBoxPadding() {
		return mBBoxPadding;
	}

	public void addFlags(int flags) {
		mFlags |= flags;
	}

	public boolean hasFlag(int flag) {
		return (mFlags & flag) != 0;
	}

	public void removeFlags(int flags) {
		flags = ~flags;
		mFlags &= flags;
	}

}
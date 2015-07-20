package com.examplo.game_engine;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class GEImageFactory {

	protected Context mContext = null;

	public GEImageFactory(Context context) {
		mContext = context;
	}

	public GEImage createImage(String filename) {
		Bitmap bitmap = null;
		try {
			AssetManager assetManager = mContext.getAssets();
			InputStream inputStream = assetManager.open(filename);
			bitmap = BitmapFactory.decodeStream(inputStream);
			inputStream.close();
		} catch (IOException e) {
			return null;
		}
		GEImage image = new GEImage(bitmap);
		return image;
	}

	public GEImage createImage(int resourceId) {
		Bitmap bitmap = null;
		try {
			Resources resources = mContext.getResources();
			InputStream inputStream = resources.openRawResource(resourceId);
			bitmap = BitmapFactory.decodeStream(inputStream);
			inputStream.close();
		} catch (IOException e) {
			return null;
		}
		GEImage image = new GEImage(bitmap);
		return image;
	}

	public Context getContext() {
		return mContext;
	}

}

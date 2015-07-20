package com.examplo.game_engine;

import android.graphics.Bitmap;
import android.graphics.Point;

public class GEImage {
	private Bitmap mBitmap = null;
    private Point mDimensions = new Point();

    public GEImage (Bitmap bitmap){
          mBitmap = bitmap;
          mDimensions.set(mBitmap.getWidth(),               
          mBitmap.getHeight());
   }

   public Bitmap getBitmap(){   return mBitmap; }
   
   public Point getDimensions(){   return mDimensions; }

}

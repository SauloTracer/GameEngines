package com.examplo.game_engine;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class GEPreferences {
	private SharedPreferences.Editor mEditor = null;
	private SharedPreferences mPreferences = null;

	public GEPreferences(Activity activity) {
		mPreferences = activity.getPreferences(Context.MODE_PRIVATE);
		mEditor = mPreferences.edit();
	}


	public boolean getBoolean(String key, boolean defaultValue) {
		try {
			return mPreferences.getBoolean(key, defaultValue);
		} catch (ClassCastException e) {
			return defaultValue;
		}
	}

	public int getInt(String key, int defaultValue) {
		try {
			return mPreferences.getInt(key, defaultValue);
		} catch (ClassCastException e) {
			return defaultValue;
		}
	}

	public float getFloat(String key, float defaultValue) {
		try {
			return mPreferences.getFloat(key, defaultValue);
		} catch (ClassCastException e) {
			return defaultValue;
		}
	}

	public long getLong(String key, long defaultValue) {
		try {
			return mPreferences.getLong(key, defaultValue);
		} catch (ClassCastException e) {
			return defaultValue;
		}
	}

	public String getString(String key, String defaultValue) {
		try {
			return mPreferences.getString(key, defaultValue);
		} catch (ClassCastException e) {
			return defaultValue;
		}
	}

	public GEPreferences putBoolean(String key, boolean value) {
		mEditor.putBoolean(key, value);
		return this;
	}

	public GEPreferences putFloat(String key, float value) {
		mEditor.putFloat(key, value);
		return this;
	}

	public GEPreferences putInt(String key, int value) {
		mEditor.putInt(key, value);
		return this;
	}

	public GEPreferences putLong(String key, long value) {
		mEditor.putLong(key, value);
		return this;
	}

	public GEPreferences putString(String key, String value) {
		mEditor.putString(key, value);
		return this;
	}

	public GEPreferences remove(String key) {
		mEditor.remove(key);
		return this;
	}
	
	 public GEPreferences begin(){
			mEditor = mPreferences.edit();
			return this;
		}

	 public void end(){
			mEditor.commit();
		}


}

package com.examplo.game_engine;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class GEActivity extends Activity {

	private GEPreferences mPreferences;

	protected GEInputPublicador mInputPublicador = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mPreferences = new GEPreferences(this);
	}

	public GEPreferences getPreferences() {
		return mPreferences;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	public void enableKeepScreenOn() {
		Window window = getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_ALLOW_LOCK_WHILE_SCREEN_ON);
	}

	@SuppressLint("NewApi")
	public void enableFullScreen() {
		Window window = getWindow();
		window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		window.requestFeature(Window.FEATURE_NO_TITLE);

		if (android.os.Build.VERSION.SDK_INT >= 19) {
			window.getDecorView().setSystemUiVisibility(
					View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
							| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (mInputPublicador != null) {
			return mInputPublicador.onTouchEvent(event);
		} else {
			return false;
		}
	}

	public void setInputPublicador(GEInputPublicador inputPublicador) {
		this.mInputPublicador = inputPublicador;
	}

	public GEInputPublicador getInnputPublicador() {
		return mInputPublicador;
	}

}

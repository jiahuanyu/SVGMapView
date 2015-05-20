package com.jiahuan.svgmapview.overlay;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;

public abstract class SVGMapBaseOverlay
{

	protected static final int MAP_LEVEL = 0; // map draw level
	protected static final int LOCATION_LEVEL = Integer.MAX_VALUE; // location draw level

	public int showLevel;// draw level
	public boolean isVisible = true;

    public abstract void onDestroy();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onTap(MotionEvent event);

    public abstract void draw(Canvas canvas, Matrix matrix, float currentZoom, float currentRotateDegrees);

}

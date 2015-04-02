package com.jiahuan.svgmapview.library.overlay;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.MotionEvent;

/**
 * 覆盖物基类，所有覆盖物实现此类
 * 
 * @since 1/7/2014
 * @author forward
 * 
 */
public abstract class SVGMapBaseOverlay
{
	protected static final int MAP_LEVEL = 0;
	protected static final int LOCATION_LEVEL = Integer.MAX_VALUE;

	public int showLevel;

	private boolean isVisible = true;

	public boolean isVisible()
	{
		return isVisible;
	}

	public void setVisible(boolean isVisible)
	{
		this.isVisible = isVisible;
	}

    public abstract void onDestory();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void onTap(MotionEvent event);

    public abstract void draw(Canvas canvas, Matrix matrix, float currentZoom, float currentRotateDegrees);

}

package com.jiahuan.svgmapview.core.helper;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.MotionEvent;

public class RectHelper
{
	/**
	 * 判断点击点是不是在矩形框内
	 * 
	 * @param event
	 * @param left
	 * @param top
	 * @param right
	 * @param bottom
	 * @param matrix
	 * @return
	 */
	public static boolean withRect(MotionEvent event, float left, float top, float right, float bottom, Matrix matrix)
	{
		float relP[] = { event.getX(), event.getY() };
		RectF basic = new RectF(left, top, right, bottom);
		matrix.mapRect(basic);
		if (basic.contains(relP[0], relP[1]))                          
		{
			return true;
		}
		return false;
	}

	public static boolean withRect(MotionEvent event, float x, float y, int dis)
	{
		if (event.getX() >= x - dis && event.getX() <= x + dis && event.getY() >= y - dis && event.getY() <= y + dis)
		{
			return true;
		}
		return false;
	}

	/**
	 * 判断两个矩形框是否有重叠
	 * 
	 * @param left
	 * @param top
	 * @param right
	 * @param bottom
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param matrix
	 * @return
	 */
	public static boolean withRect(float left, float top, float right, float bottom, int x1, int y1, int x2, int y2, Matrix matrix)
	{
		RectF screen = new RectF(x1, y1, x2, y2);
		RectF basic = new RectF(left, top, right, bottom);
		matrix.mapRect(basic);
		if (screen.contains(basic))
		{
			return true;
		}
		return false;
	}

}

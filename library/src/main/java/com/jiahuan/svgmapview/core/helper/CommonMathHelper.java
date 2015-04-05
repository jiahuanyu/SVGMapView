package com.jiahuan.svgmapview.core.helper;

public class CommonMathHelper
{
	public static float getDistanceBetweenTwoPoints(float x1, float y1, float x2, float y2)
	{
		return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
}

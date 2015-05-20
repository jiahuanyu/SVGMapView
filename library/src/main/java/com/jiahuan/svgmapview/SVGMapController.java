package com.jiahuan.svgmapview;


import android.graphics.PointF;

import com.jiahuan.svgmapview.core.componet.MapMainView;

/**
 * 地图控制类
 *
 * @author forward
 * @since 1/7/2014
 */
public class SVGMapController
{
    private MapMainView mapMainView;

    public SVGMapController(SVGMapView mapView)
    {
        this.mapMainView = (MapMainView) mapView.getChildAt(0);
    }

    /**
     * 设置是否开启地图手势移动，默认开启
     *
     * @param enabled true/false
     */
    public void setScrollGestureEnabled(boolean enabled)
    {
        this.mapMainView.setScrollGestureEnabled(enabled);
    }


    /**
     * 设置是否开启地图地图手势缩放，默认开启
     *
     * @param enabled
     */
    public void setZoomGestureEnabled(boolean enabled)
    {
        this.mapMainView.setZoomGestureEnabled(enabled);
    }


    /**
     * 设置是否开启地图手势旋转，默认开启
     *
     * @param enabled true/false
     */
    public void setRotationGestureEnabled(boolean enabled)
    {
        if (!enabled)
        {
            setCurrentRotationDegrees(0);
        }
        this.mapMainView.setRotationGestureEnabled(enabled);

    }


    /**
     * 设置地图手势缩放中心是否为手势的中心点
     *
     * @param enabled
     */
    public void setZoomWithTouchEventCenterEnabled(boolean enabled)
    {
        this.mapMainView.setZoomWithTouchEventCenter(enabled);
    }

    /**
     * 设置地图手势旋转中心是否为手势的中心点
     *
     * @param enabled true/false
     */
    public void setRotateWithTouchEventCenterEnabled(boolean enabled)
    {
        this.mapMainView.setRotateWithTouchEventCenter(enabled);
    }


    /**
     * 非动画形式的地图移动
     *
     * @param x x方向偏移量 +右
     * @param y y方向偏移量 +下
     */
    public void translateBy(float x, float y)
    {
        this.mapMainView.translateBy(x, y);
    }


    /**
     * 以非动画形式设置当前地图的缩放比例
     *
     * @param zoom   缩放率
     * @param pivotX 缩放中心点x
     * @param pivotY 缩放中心点y
     */
    public void setCurrentZoomValue(float zoom, float pivotX, float pivotY)
    {
        this.mapMainView.setCurrentZoomValue(zoom, pivotX, pivotY);
    }

    public void setCurrentZoomValue(float zoom)
    {
        setCurrentZoomValue(zoom, mapMainView.getWidth() / 2, mapMainView.getHeight() / 2);
    }

    /**
     * 以非动画的形式设置当前地图的旋转角度 【0，360】
     *
     * @param degrees
     */
    public void setCurrentRotationDegrees(float degrees)
    {
        setCurrentRotationDegrees(degrees, mapMainView.getWidth() / 2, mapMainView.getHeight() / 2);
    }

    public void setCurrentRotationDegrees(float degrees, float pivotX, float pivotY)
    {
        this.mapMainView.setCurrentRotationDegrees(degrees, pivotX, pivotY);
    }


    /**
     * 设置地图的最大缩缩放比例，默认为所有地图上的Unit显示時的大小
     *
     * @param maxZoomValue
     */
    public void setMaxZoomValue(float maxZoomValue)
    {
        this.mapMainView.setMaxZoomValue(maxZoomValue);
    }

    /**
     * 设置地图闪烁点
     *
     * @param point       目标点
     * @param radius      半径
     * @param color       颜色
     * @param repeatTimes 重复次数
     */
    public void sparkAtPoint(PointF point, float radius, int color, int repeatTimes)
    {
        this.mapMainView.sparkAtPoint(point, radius, color, repeatTimes);
    }

}

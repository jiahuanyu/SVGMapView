package com.jiahuan.svgmapview.library;


import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.jiahuan.svgmapview.library.core.componet.MapMainView;
import com.jiahuan.svgmapview.library.core.data.SVGPicture;
import com.jiahuan.svgmapview.library.core.helper.ImageHelper;
import com.jiahuan.svgmapview.library.core.helper.map.SVGBuilder;
import com.jiahuan.svgmapview.library.overlay.SVGMapBaseOverlay;

import java.util.List;

/**
 * 地图显示界面类
 *
 * @author forward
 * @since 1/7/2014
 */
public class SVGMapView extends FrameLayout
{
    private MapMainView mapMainView;
    private SVGMapController mapController;

    public SVGMapView(Context context)
    {
        this(context, null);
    }

    public SVGMapView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public SVGMapView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        mapMainView = new MapMainView(context, attrs, defStyle);
        addView(mapMainView);
        ImageView copyRight_imageView = new ImageView(context, attrs, defStyle);
        copyRight_imageView.setScaleType(ScaleType.FIT_START);
        copyRight_imageView.setImageBitmap(ImageHelper.drawableToBitmap(new SVGBuilder().readFromString(SVGPicture.ICON_TOILET).build().getDrawable(), 1.0f));
        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, context.getResources().getDisplayMetrics()));
        params.gravity = Gravity.BOTTOM | Gravity.LEFT;
        params.leftMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, context.getResources().getDisplayMetrics());
        params.bottomMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10, context.getResources().getDisplayMetrics());
        addView(copyRight_imageView, params);
    }

    /**
     * 取得地图控制器
     *
     * @return 地图控制器
     */
    public SVGMapController getController()
    {
        if (this.mapController == null)
        {
            this.mapController = new SVGMapController(this);
        }
        return this.mapController;
    }

    /**
     * 反馈地图是否加载完毕
     *
     * @return
     */
    public boolean isMapLoadFinsh()
    {
        return this.mapMainView.isMapLoadFinsh();
    }

    /**
     * 截取当前显示的地图，截取完毕后，在IdrMapViewListener接口中的onGetCurrentMap()得到bitmap
     */
    public void getCurrentMap()
    {
        this.mapMainView.getCurrentMap();
    }

    /**
     * 取得当前地图旋转角度
     *
     * @return 地图旋转角度 【0 360】
     */
    public float getCurrentRotateDegrees()
    {
        return this.mapMainView.getCurrentRotateDegrees();
    }

    /**
     * 取得当前地图缩放比例
     *
     * @return
     */
    public float getCurrentZoomValue()
    {
        return this.mapMainView.getCurrentZoomValue();
    }

    /**
     * 取得地图最大的缩放比例
     *
     * @return
     */
    public float getMaxZoomValue()
    {
        return this.mapMainView.getMaxZoomValue();
    }

    /**
     * 取得地图最小的缩放比例
     *
     * @return
     */
    public float getMinZoomValue()
    {
        return this.mapMainView.getMinZoomValue();
    }

    /**
     * 屏幕坐标转换成地图坐标
     *
     * @param screenX 屏幕坐标x
     * @param screenY 屏幕坐标y
     * @return 地图坐标 {x,y}
     */
    public float[] getMapCoordinateWithScreenCoordinate(int screenX, int screenY)
    {
        return this.mapMainView.getMapCoordinateWithScreenCoordinate(screenX, screenY);
    }

    /**
     * 取得当前地图的所有覆盖层
     *
     * @return
     */
    public List<SVGMapBaseOverlay> getOverLays()
    {
        return this.mapMainView.getOverLays();
    }

    /**
     * 注册idrMapViewListener监听
     *
     * @param idrMapViewListener
     */
    public void registeMapViewListener(SVGMapViewListener idrMapViewListener)
    {
        this.mapMainView.registeMapViewListener(idrMapViewListener);
    }

    /**
     * 加載地圖
     */

    public void loadMap(String svgString)
    {
        this.mapMainView.loadMap(svgString);
    }

    /**
     * 刷新地图
     */
    public void refresh()
    {
        this.mapMainView.refresh();
    }

    /**
     * Activity onDestory时调用
     */
    public void onDestory()
    {
        this.mapMainView.onDestory();
    }

    /**
     * Activity onPause时调用
     */
    public void onPause()
    {
        this.mapMainView.onPause();
    }

    /**
     * Activity onResume时调用
     */
    public void onResume()
    {
        this.mapMainView.onResume();
    }

}

package com.jiahuan.svgmapview.sample.overlay;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.widget.Toast;

import com.jiahuan.svgmapview.SVGMapView;
import com.jiahuan.svgmapview.overlay.SVGMapBaseOverlay;
import com.jiahuan.svgmapview.sample.R;

/**
 * Created by jiahuan on 2015/7/12.
 */
public class BitmapOverlay extends SVGMapBaseOverlay
{
    private SVGMapView mMapView;
    private int x = 200;
    private int y = 300;
    private Bitmap mBitmap;

    public BitmapOverlay(SVGMapView svgMapView)
    {
        initLayer(svgMapView);
    }

    private void initLayer(SVGMapView svgMapView)
    {
        mMapView = svgMapView;
        mBitmap = BitmapFactory.decodeResource(svgMapView.getResources(), R.mipmap.ic_launcher);
    }


    @Override
    public void onDestroy()
    {

    }

    @Override
    public void onPause()
    {

    }

    @Override
    public void onResume()
    {

    }

    @Override
    public void onTap(MotionEvent event)
    {
        float[] mapCoordinate = mMapView.getMapCoordinateWithScreenCoordinate(event.getX(), event.getY());
        if (mapCoordinate[0] >= x && mapCoordinate[0] <= x + mBitmap.getWidth() && mapCoordinate[1] >= y && mapCoordinate[1] <= y + mBitmap.getHeight())
        {
            Toast.makeText(mMapView.getContext(), "Clicked on bitmap",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void draw(Canvas canvas, Matrix matrix, float currentZoom, float currentRotateDegrees)
    {
        canvas.save();
        canvas.setMatrix(matrix);

        canvas.drawBitmap(mBitmap, x, y, new Paint(Paint.ANTI_ALIAS_FLAG));

        canvas.restore();
    }
}

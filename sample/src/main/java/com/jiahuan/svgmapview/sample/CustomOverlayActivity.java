package com.jiahuan.svgmapview.sample;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.jiahuan.svgmapview.SVGMapView;
import com.jiahuan.svgmapview.SVGMapViewListener;
import com.jiahuan.svgmapview.overlay.SVGMapLocationOverlay;
import com.jiahuan.svgmapview.sample.helper.AssetsHelper;
import com.jiahuan.svgmapview.sample.overlay.BitmapOverlay;


public class CustomOverlayActivity extends ActionBarActivity
{
    private SVGMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location);

        mapView = (SVGMapView) findViewById(R.id.location_mapview);

        mapView.registerMapViewListener(new SVGMapViewListener()
        {
            @Override
            public void onMapLoadComplete()
            {
                BitmapOverlay locationOverlay = new BitmapOverlay(mapView);
                mapView.getOverLays().add(locationOverlay);
                mapView.refresh();
            }

            @Override
            public void onMapLoadError()
            {
            }

            @Override
            public void onGetCurrentMap(Bitmap bitmap)
            {
            }
        });
        mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));
    }
}

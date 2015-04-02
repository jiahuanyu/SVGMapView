package com.jiahuan.svgmapview.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.jiahuan.svgmapview.library.SVGMapView;


public class MainActivity extends ActionBarActivity
{
    private SVGMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mapView = (SVGMapView) findViewById(R.id.mapView);

        mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));

        mapView.getController().setRotationGestureEnabled(false);
    }

}

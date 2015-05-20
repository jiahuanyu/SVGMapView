package com.jiahuan.svgmapview.sample;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.jiahuan.svgmapview.SVGMapView;
import com.jiahuan.svgmapview.sample.helper.AssetsHelper;

import java.util.Random;

public class SparkActivity extends ActionBarActivity
{

    private SVGMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spark);

        mapView = (SVGMapView) findViewById(R.id.spark_mapview);
        mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));

        Random random = new Random();

        for (int i = 0; i < 4; i++)
        {
            int color = i % 2 == 0 ? Color.RED : Color.BLUE;
            mapView.getController().sparkAtPoint(new PointF(random.nextInt(1000), random.nextInt(1000)), 100, color, 10);
        }

    }
}


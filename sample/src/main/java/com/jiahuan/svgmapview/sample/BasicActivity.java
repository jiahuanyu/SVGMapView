package com.jiahuan.svgmapview.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.jiahuan.svgmapview.library.SVGMapView;
import com.jiahuan.svgmapview.sample.helper.AssetsHelper;


public class BasicActivity extends ActionBarActivity
{
    private SVGMapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mapView = (SVGMapView) findViewById(R.id.mapView);

        mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));

        mapView.getController().setRotationGestureEnabled(false);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mapView.onPause();
    }


    @Override
    protected void onResume()
    {
        super.onResume();
        mapView.onResume();
    }


    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        mapView.onDestory();
    }
}

package com.jiahuan.svgmapview.sample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jiahuan.svgmapview.library.SVGMapView;
import com.jiahuan.svgmapview.library.SVGMapViewListener;
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


        mapView = (SVGMapView) findViewById(R.id.basic_mapview);

        mapView.registeMapViewListener(new SVGMapViewListener()
        {
            @Override
            public void onMapLoadComplete()
            {
                // 地图加载完成
                BasicActivity.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(BasicActivity.this, "onMapLoadComplete", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onMapLoadError()
            {
                // 地图加载失败
                BasicActivity.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(BasicActivity.this, "onMapLoadError", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onGetCurrentMap(Bitmap bitmap)
            {
                // 获取地图截图
                // 保存到本地
                //........
                BasicActivity.this.runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        Toast.makeText(BasicActivity.this, "onGetCurrentMap", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));

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

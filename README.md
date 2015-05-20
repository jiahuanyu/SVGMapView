# SVGMapView
![Sample](./sample.gif)

## System Reqirement
Android v2.2+

## TODO
Developed by Android Studio



## Basic map
- add map into layout
```xml
  <com.jiahuan.svgmapview.SVGMapView
      android:id="@+id/mapView"
      android:layout_width="match_parent"
      android:layout_height="match_parent">
  </com.jiahuan.svgmapview.SVGMapView>
```

- reference in `Activity`
```java
  mapView = (SVGMapView) findViewById(R.id.mapView);
```

- load map
```java
// load svg string
  mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));  
```

- lifecycle
```java
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
```

- set map listener
```java
    mapView.registeMapViewListener(new SVGMapViewListener()
    {
        @Override
        public void onMapLoadComplete()
        {
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
```

## map control
- gesture
```java
    // 关闭地图旋转的手势 默认开启
    // 如果将地图旋转手势置为false，那么地图将被固定在中间，地图旋转的相关操作也将被禁止掉。如果为true那么地图的位置将不会被固定
    mapView.getController().setRotationGestureEnabled(false);
    // 开启地图拖拉手势  默认开启
    mapView.getController().setScrollGestureEnabled(true);
    // 开启地图缩放手势 默认开启
    mapView.getController().setZoomGestureEnabled(true);
    // 关闭地图旋转的中心点是手势中心点 默认关闭，中心点是地图的中心点
    mapView.getController().setRoateWithTouchEventCenterEnabled(false);
    // 关闭地图缩放的中心点是手势中心点 默认关闭，中心点是地图的中心点
    mapView.getController().setZoomWithTouchEventCenterEnabled(false);
```

- zoom
```java
    // 此方法是相对于初始大小
    mapView.getController().setCurrentZoomValue(2);
    mapView.getController().setCurrentZoomValue(0.5f);
```

- rotate
```java
    // 正时为顺时针旋转
    // 如果旋转手势是关闭状态，则此方法无效
    mapView.getController().setCurrentRotationDegrees(30);
```


- get current map
```java
    mapView.getCurrentMap();
    //调用以上方法之后，在地图截图生成完毕后，在设置地图监听中返回
```





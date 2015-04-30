# SVGMapView
Developed by Android Studio

## System 
Android v2.2+

## Sample show
![Sample](./sample.gif)

## Basic map
- Add map into layout
```xml
  <com.jiahuan.svgmapview.SVGMapView
      android:id="@+id/mapView"
      android:layout_width="match_parent"
      android:layout_height="match_parent">
  </com.jiahuan.svgmapview.SVGMapView>
```

- Reference in `Activity`
```java
  mapView = (SVGMapView) findViewById(R.id.mapView);
```

- Load map
```java
  mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));  // 这里加载的是SVG的字符串
```

- Lifecycle
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

- Set map listener
```java
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
            // 获取地图截图 通过getCurrentMap
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
```

## Map operation
- Gesture
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

- Zoom
```java
    // 此方法是相对于初始大小
    mapView.getController().setCurrentZoomValue(2);
    mapView.getController().setCurrentZoomValue(0.5f);
```

- Rotate
```java
    // 正时为顺时针旋转
    // 如果旋转手势是关闭状态，则此方法无效
    mapView.getController().setCurrentRotationDegrees(30);
```


- Get current map
```java
    mapView.getCurrentMap();
    //调用以上方法之后，在地图截图生成完毕后，在设置地图监听中返回
```





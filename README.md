# SVGMapView
此项目是本人之前个人完成的室内地图定位导航SDK中室内地图显示部分的模块提取，当然开源部分与原始部分有很大的不同。
此项目由AndroidStudio开发


## 系统要求
Android v2.2+

## 效果展示
![Sample](./sample.gif)

## 基础地图
- 添加控件到布局文件中
```xml
  <com.jiahuan.svgmapview.library.SVGMapView
      android:id="@+id/mapView"
      android:layout_width="match_parent"
      android:layout_height="match_parent">
  </com.jiahuan.svgmapview.library.SVGMapView>
```

- `Activity`界面中使用
```java
  mapView = (SVGMapView) findViewById(R.id.mapView);
```

- 加载地图
```java
  mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));  // 这里加载的是SVG的字符串
```

- 生命周期函数
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

- 设置地图监听
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

## 地图相关操作
- 手势相关设置
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

- 截取当前地图
```java
    mapView.getCurrentMap();
```
调用以上方法之后，在地图截图生成完毕后，在设置地图监听中返回

## 说明
现在初始版本还存在大量性能问题，后续我将慢慢推进
关于功能这一块我会继续完善，毕竟我的原始版本的功能还是很强的


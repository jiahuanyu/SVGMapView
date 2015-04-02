# SVGMapView
此项目是本人之前个人完成的室内地图定位导航SDK中室内地图显示部分的模块提取，当然开源部分与原始部分有很大的不同。
此项目由AndroidStudio开发


## 系统要求
Android v2.2+

## 项目设置
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
  mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));  // 这里加载的是SVG的字符串
  mapView.getController().setRotationGestureEnabled(false);
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


## 说明
现在初始版本还存在大量性能问题，后续我将慢慢推进
关于功能这一块我会继续完善，毕竟我的原始版本的功能还是很强的


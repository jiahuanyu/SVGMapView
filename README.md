# SVGMapView
<img src="./images/overall_sample.gif" width="250px" height="auto" />
<img src="./images/location_sample.png" width="250px" height="auto" />
<img src="./images/spark_sample.gif" width="250px" height="auto" />
## System Requirement
Android v2.2+

## TODO
Developed by Android Studio

## Quick Start
### Add map into layout
```xml
<com.jiahuan.svgmapview.SVGMapView
  android:id="@+id/mapView"
  android:layout_width="match_parent"
  android:layout_height="match_parent">
</com.jiahuan.svgmapview.SVGMapView>
```

### Reference in `Activity`
```java
SVGMapView mapView = (SVGMapView) findViewById(R.id.mapView);
```

### Lifecycle
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
  mapView.onDestroy();
}
```

### Load map
```java
// load svg string
mapView.loadMap(AssetsHelper.getContent(this, "sample2.svg"));
```

## License
Copyright 2013 JiaHuan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and limitations under the License.



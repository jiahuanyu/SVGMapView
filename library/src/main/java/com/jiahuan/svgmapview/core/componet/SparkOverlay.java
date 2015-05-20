package com.jiahuan.svgmapview.core.componet;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.view.MotionEvent;

import com.jiahuan.svgmapview.overlay.SVGMapBaseOverlay;

public class SparkOverlay extends SVGMapBaseOverlay
{
    private static final float STEP = 2f;
    private static final long delayTime = 40;
    //
    private MapMainView mapMainView;
    private float totalRadius;
    private int repeatTimes = 3;
    private int currentRadius = 0;
    private int currentRepeatTime = 0;
    private Paint paint;
    private PointF centerPoint;
    private int alphaStep = 0;
    private int currentAlpha = 255;
    private DrawThread drawThread = new DrawThread();

    public SparkOverlay(MapMainView mapMainView, float radius, PointF centerPoint, int color, int repeatTimes)
    {
        initLayer(mapMainView, radius, centerPoint, color, repeatTimes);
    }

    private void initLayer(MapMainView mapMainView, float radius, PointF centerPoint, int color, int repeatTimes)
    {
        this.totalRadius = radius;
        this.currentAlpha = color >>> 24;
        this.alphaStep = (int) (currentAlpha / (this.totalRadius / STEP));
        this.repeatTimes = repeatTimes;
        this.mapMainView = mapMainView;
        this.centerPoint = centerPoint;
        this.showLevel = LOCATION_LEVEL;
        this.paint = new Paint();
        this.paint.setColor(color);
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Style.FILL_AND_STROKE);
        drawThread.start();
    }

    private class DrawThread extends Thread
    {
        @Override
        public void run()
        {
            super.run();
            while (currentRepeatTime != repeatTimes)
            {
                if (currentRepeatTime < repeatTimes)
                {
                    if (currentRadius >= totalRadius)
                    {
                        currentRadius = 0;
                        currentRepeatTime++;
                    }
                    else
                    {
                        currentRadius += STEP;
                        currentAlpha -= alphaStep;
                        paint.setAlpha(currentAlpha);
                        mapMainView.refresh();
                    }
                }
                try
                {
                    Thread.sleep(delayTime);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            mapMainView.getOverLays().remove(SparkOverlay.this);
        }
    }

    @Override
    public void onDestroy()
    {
    }

    @Override
    public void onPause()
    {

    }

    @Override
    public void onResume()
    {
        if (!drawThread.isAlive())
        {
            new DrawThread().start();
        }
    }

    @Override
    public void onTap(MotionEvent event)
    {

    }

    @Override
    public void draw(Canvas canvas, Matrix matrix, float currentZoomValue, float currentRotateDegrees)
    {
        canvas.save();
        if (isVisible)
        {
            canvas.setMatrix(matrix);
            canvas.drawCircle(this.centerPoint.x, this.centerPoint.y, this.currentRadius, this.paint);
        }
        canvas.restore();
    }

}

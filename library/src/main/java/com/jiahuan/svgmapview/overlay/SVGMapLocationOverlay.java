package com.jiahuan.svgmapview.overlay;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.MotionEvent;

import com.jiahuan.svgmapview.SVGMapView;

public class SVGMapLocationOverlay extends SVGMapBaseOverlay
{
    // Model
    public static final int MODE_NORMAL = 0;
    public static final int MODE_COMPASS = 1;

    // Color for compass
    private static final int DEFAULT_LOCATION_COLOR = 0xFF3EBFC9;
    private static final int DEFAULT_LOCATION_SHADOW_COLOR = 0xFF909090;
    private static final int DEFAULT_INDICATOR_ARC_COLOR = 0xFFFA4A8D;
    private static final int DEFAULT_INDICATOR_CIRCLE_COLOR = 0xFF00F0FF;
    private static final float COMPASS_DELTA_ANGLE = 5.0f;
    private float defaultLocationCircleRadius;

    // Compass mode
    private float compassLineLength;
    private float compassLineWidth;
    private float compassLocationCircleRadius;
    private float compassRadius;
    private float compassArcWidth;
    private float compassIndicatorCircleRadius;
    private float compassIndicatorGap;
    private float compassIndicatorArrowRotateDegree;
    private float compassIndicatorCircleRotateDegree = 0;
    private Bitmap compassIndicatorArrowBitmap;

    private Paint compassLinePaint;
    private Paint locationPaint;
    private Paint indicatorCirclePaint;
    private Paint indicatorArcPaint;

    private PointF currentPosition = null;
    private int currentMode = MODE_NORMAL;

    public SVGMapLocationOverlay(SVGMapView svgMapView)
    {
        initLayer(svgMapView);
    }

    private void initLayer(SVGMapView svgMapView)
    {
        this.showLevel = LOCATION_LEVEL;
        //
        locationPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        locationPaint.setAntiAlias(true);
        locationPaint.setStyle(Paint.Style.FILL);
        locationPaint.setColor(DEFAULT_LOCATION_COLOR);
        locationPaint.setShadowLayer(5, 3, 3, DEFAULT_LOCATION_SHADOW_COLOR);
        //
        defaultLocationCircleRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, svgMapView.getResources().getDisplayMetrics());
        //
        compassRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 38, svgMapView.getResources().getDisplayMetrics());
        compassLocationCircleRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0.5f, svgMapView.getResources().getDisplayMetrics());
        compassLineWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.3f, svgMapView.getResources().getDisplayMetrics());
        compassLineLength = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2.3f, svgMapView.getResources().getDisplayMetrics());
        compassArcWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4.0f, svgMapView.getResources().getDisplayMetrics());
        compassIndicatorCircleRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2.6f, svgMapView.getResources().getDisplayMetrics());
        compassIndicatorGap = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15.0f, svgMapView.getResources().getDisplayMetrics());
        //
        compassLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        compassLinePaint.setAntiAlias(true);
        compassLinePaint.setStrokeWidth(compassLineWidth);
        //
        indicatorCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        indicatorCirclePaint.setAntiAlias(true);
        indicatorCirclePaint.setStyle(Paint.Style.FILL);
        indicatorCirclePaint.setShadowLayer(3, 1, 1, DEFAULT_LOCATION_SHADOW_COLOR);
        indicatorCirclePaint.setColor(DEFAULT_INDICATOR_CIRCLE_COLOR);
        //
        indicatorArcPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        indicatorArcPaint.setStyle(Paint.Style.STROKE);
        indicatorArcPaint.setColor(DEFAULT_INDICATOR_ARC_COLOR);
        indicatorArcPaint.setStrokeWidth(compassArcWidth);
    }

    public void setIndicatorArrowBitmap(Bitmap bitmap)
    {
        this.compassIndicatorArrowBitmap = bitmap;
    }

    public void setMode(int mode)
    {
        this.currentMode = mode;
    }


    public PointF getPosition()
    {
        return currentPosition;
    }

    public void setPosition(PointF position)
    {
        this.currentPosition = position;
    }

    public void setIndicatorArrowRotateDegree(float degree)
    {
        this.compassIndicatorArrowRotateDegree = degree % 360;
    }

    public void setIndicatorCircleRotateDegree(float degree)
    {
        this.compassIndicatorCircleRotateDegree = degree % 360;
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

    }

    @Override
    public void onTap(MotionEvent event)
    {

    }

    @Override
    public void draw(Canvas canvas, Matrix matrix, float currentZoom, float currentRotateDegrees)
    {
        canvas.save();
        if (this.isVisible && this.currentPosition != null)
        {
            float goal[] = {currentPosition.x, currentPosition.y};
            matrix.mapPoints(goal);

            canvas.drawCircle(goal[0], goal[1], defaultLocationCircleRadius, locationPaint);

            if (currentMode == MODE_COMPASS)
            {
                for (int i = 0; i < 360 / COMPASS_DELTA_ANGLE; i++)
                {
                    canvas.save();
                    canvas.rotate(COMPASS_DELTA_ANGLE * i, goal[0], goal[1]);
                    if (i % (90 / COMPASS_DELTA_ANGLE) == 0)
                    {
                        canvas.drawLine(goal[0], goal[1] - compassRadius + compassLocationCircleRadius, goal[0], goal[1] - compassRadius + compassLocationCircleRadius - compassLineLength, compassLinePaint);
                    }
                    else
                    {
                        canvas.drawCircle(goal[0], goal[1] - compassRadius, compassLocationCircleRadius, new Paint());
                    }
                    canvas.restore();
                }
                if (compassIndicatorArrowBitmap != null)
                {
                    canvas.save();
                    canvas.rotate(this.compassIndicatorArrowRotateDegree, goal[0], goal[1]);
                    canvas.drawBitmap(compassIndicatorArrowBitmap, goal[0] - compassIndicatorArrowBitmap.getWidth() / 2, goal[1] - defaultLocationCircleRadius - compassIndicatorGap, new Paint());
                    canvas.restore();
                    if (360 - (this.compassIndicatorArrowRotateDegree - this.compassIndicatorCircleRotateDegree) > 180)
                    {
                        canvas.drawArc(new RectF(goal[0] - compassRadius, goal[1] - compassRadius, goal[0] + compassRadius, goal[1] + compassRadius), -90 + this.compassIndicatorCircleRotateDegree, (this.compassIndicatorArrowRotateDegree - this.compassIndicatorCircleRotateDegree), false,
                                indicatorArcPaint);
                    }
                    else
                    {
                        canvas.drawArc(new RectF(goal[0] - compassRadius, goal[1] - compassRadius, goal[0] + compassRadius, goal[1] + compassRadius), -90 + this.compassIndicatorArrowRotateDegree, 360 - (this.compassIndicatorArrowRotateDegree - this.compassIndicatorCircleRotateDegree), false,
                                indicatorArcPaint);
                    }

                }
                canvas.save();
                canvas.rotate(compassIndicatorCircleRotateDegree, goal[0], goal[1]);
                canvas.drawCircle(goal[0], goal[1] - compassRadius, compassIndicatorCircleRadius, indicatorCirclePaint);
                canvas.restore();
            }

        }
        canvas.restore();
    }
}

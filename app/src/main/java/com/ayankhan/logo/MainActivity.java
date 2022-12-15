package com.ayankhan.logo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    private float floatStartX = -1, floatStartY = -1,
            floatEndX = -1, floatEndY = -1;

    private Bitmap bitmap;
    private Canvas canvas;
    private Paint paint = new Paint();
    private float radian=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView2);
    }

    private void drawPaintSketchImage(){

        if (bitmap == null){
            bitmap = Bitmap.createBitmap(imageView.getWidth(),
                    imageView.getHeight(),
                    Bitmap.Config.ARGB_8888);
            canvas = new Canvas(bitmap);
            paint.setColor(Color.RED);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(8);
        }
        canvas.drawLine(floatStartX,
                floatStartY,
                floatEndX,
                floatEndY,
                paint);
        imageView.setImageBitmap(bitmap);
    }
    public void turn(View view)
    {
        radian+=90;
        floatEndX+=Math.sin(radian)*100;
        floatEndY+=Math.cos(radian)*100;
        drawPaintSketchImage();
        floatStartX=floatEndX;
        floatStartY=floatEndY;

    }
    public void click(View view)
    {
        if(radian==0)
        {
           floatEndX+=100;
           floatEndY+=100;
        }
        else{
        floatEndX+=Math.sin(radian)*100;
        floatEndY+=Math.cos(radian)*100;}
        if(floatStartX==-1.0) {
            floatStartX = this.getResources().getDisplayMetrics().widthPixels;
            float floatStartY = this.getResources().getDisplayMetrics().heightPixels;
        }
        drawPaintSketchImage();
        floatStartX=floatEndX;
        floatStartY=floatEndY;



    }

}
package com.gloomyer.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.gloomyer.zoomimageview.ZoomImageView;

/**
 * Created by Gloomy on 16/7/5.
 */
public class SimpleImageAct extends Activity {
    ZoomImageView ziv;
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_image);

        ziv = (ZoomImageView) findViewById(R.id.ziv);
        ziv.post(new Runnable() {
            @Override
            public void run() {
                Log.i("test", ziv.getWidth() + "," + ziv.getHeight());
                width = ziv.getWidth();
                height = ziv.getHeight();
            }
        });
    }

    public void loadSrc1(View v) {
        ziv.setImageForUrl("http://qximg.lightplan.cc/2016/02/20/1455947314173671.jpg?imageView2/2/w/"
                + width + "/h/" + height);
    }

    public void loadSrc2(View v) {
        ziv.setImageForUrl("http://qximg.lightplan.cc/2016/03/1/1456833663958973.jpg?imageView2/2/w/"
                + width + "/h/" + height);
    }

    public void loadSrc3(View v) {
        ziv.reSetState();
        Glide.with(this)
                .load("http://qximg.lightplan.cc/2016/05/10/1462863397324242.gif?imageView2/2/w/"
                        + width + "/h/" + height)
                .into(ziv);
    }
}

package com.gloomyer.demo.anim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.gloomyer.demo.R;
import com.gloomyer.zoomimageview.ZoomImageView;

/**
 * Created by Gloomy on 2017/6/12.
 */

public class Anim2Act extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim2);
        ZoomImageView ziv = (ZoomImageView) findViewById(R.id.mZoomImageView);

        Glide.with(this)
                .load(R.mipmap.kali_bg)
                .into(ziv);
        ViewCompat.setTransitionName(ziv, "image");
    }
}

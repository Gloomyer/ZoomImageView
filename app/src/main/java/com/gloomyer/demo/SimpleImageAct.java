package com.gloomyer.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.gloomyer.zoomimageview.ZoomImageView;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.squareup.picasso.Picasso;

/**
 * Created by Gloomy on 16/7/5.
 */
public class SimpleImageAct extends Activity {
    ZoomImageView ziv;
    RadioGroup group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_image);

        ziv = (ZoomImageView) findViewById(R.id.ziv);
        ziv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleImageAct.this.finish();
            }
        });
        group = (RadioGroup) findViewById(R.id.group);
        RadioButton child = (RadioButton) group.getChildAt(0);
        child.setChecked(true);
        ImageLoader.getInstance().init(new ImageLoaderConfiguration.Builder(this)
                .threadPriority(Thread.NORM_PRIORITY - 2)
                .denyCacheImageMultipleSizesInMemory()
                .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .build());
    }

    public void loadSrc1(View v) {
        ziv.placeholder(R.mipmap.ic_launcher);
        String url = "http://qximg.lightplan.cc/2016/02/20/1455947314173671.jpg";
        RadioButton child = (RadioButton) group.getChildAt(0);
        if (child.isChecked()) {
            Glide.with(this)
                    .load(url)
                    .asBitmap()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ziv);
            return;
        }
        child = (RadioButton) group.getChildAt(1);
        if (child.isChecked()) {
            Picasso.with(this)
                    .load(url)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ziv);
            return;
        }

        child = (RadioButton) group.getChildAt(2);
        if (child.isChecked()) {
            ImageLoader.getInstance().displayImage(url, ziv);
            return;
        }
    }

    public void loadSrc2(View v) {
        ziv.placeholder(R.mipmap.ic_launcher);
        String url = "http://qximg.lightplan.cc/2016/03/1/1456833663958973.jpg";
        RadioButton child = (RadioButton) group.getChildAt(0);
        if (child.isChecked()) {
            Glide.with(this)
                    .load(url)
                    .asBitmap()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ziv);
            return;
        }
        child = (RadioButton) group.getChildAt(1);
        if (child.isChecked()) {
            Picasso.with(this)
                    .load(url)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ziv);
            return;
        }

        child = (RadioButton) group.getChildAt(2);
        if (child.isChecked()) {
            ImageLoader.getInstance().displayImage(url, ziv);
            return;
        }
    }

    public void loadSrc3(View v) {
        ziv.placeholder(R.mipmap.ic_launcher);
        String url = "http://qximg.lightplan.cc/2016/05/10/1462863397324242.gif";
        RadioButton child = (RadioButton) group.getChildAt(0);
        if (child.isChecked()) {
            Glide.with(this)
                    .load(url)
                    .asGif()
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ziv);
            return;
        }
        child = (RadioButton) group.getChildAt(1);
        if (child.isChecked()) {
            Picasso.with(this)
                    .load(url)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(ziv);
            return;
        }

        child = (RadioButton) group.getChildAt(2);
        if (child.isChecked()) {
            ImageLoader.getInstance().displayImage(url, ziv);
            return;
        }
    }
}

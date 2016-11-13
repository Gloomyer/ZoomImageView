package com.gloomyer.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.gloomyer.zoomimageview.ZoomImageView;

/**
 * Created by Gloomy on 16/7/5.
 */
public class MultiImageAct extends Activity {

    ViewPager vp;
    private MyAdapter mAdapter;
    private String[] imgs =
            {"http://qximg.lightplan.cc/ios/2016-04-01/83add523b915cea169946fcdb0b5f0710.jpg?imageView2/2/w/900/h/1600",
                    "http://qximg.lightplan.cc/ios/2016-04-01/eed2b1b596b630e1f175afcc372665bb1.jpg?imageView2/2/w/900/h/1600",
                    "http://qximg.lightplan.cc/ios/2016-04-01/eed2b1b596b630e1f175afcc372665bb2.jpg?imageView2/2/w/900/h/1600",
                    "http://qximg.lightplan.cc/2016/03/1/1456833663958973.jpg?imageView2/2/w/900/h/1600",
                    "http://qximg.lightplan.cc/2016/05/10/1462863397324242.gif?imageView2/2/w/900/h/1600"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_image);

        vp = (ViewPager) findViewById(R.id.vp);
        mAdapter = new MyAdapter();
        vp.setAdapter(mAdapter);
    }

    private class MyAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ZoomImageView ziv = new ZoomImageView(MultiImageAct.this);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            ziv.placeholder(R.mipmap.ic_launcher);
            ziv.reSetState();
            Glide.with(MultiImageAct.this)
                    .load(imgs[position])
                    .into(ziv);
            //ziv.setImageForUrl(imgs[position]);
            container.addView(ziv, layoutParams);
            return ziv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
}

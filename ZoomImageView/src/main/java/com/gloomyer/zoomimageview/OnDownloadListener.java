package com.gloomyer.zoomimageview;

import android.graphics.Bitmap;

/**
 * 下载图片的一些回调
 */
public abstract class OnDownloadListener {

    /**
     * 开始下载了
     */
    public void onStart() {

    }

    /**
     * 完成下载了
     *
     * @param bitmap 下载完成的图片
     */
    public void onFinish(Bitmap bitmap) {

    }

    /**
     * 正在下载
     *
     * @param progress 下载进度
     */
    public void onProgress(int progress) {

    }
}

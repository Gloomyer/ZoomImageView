package com.gloomyer.zoomimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 图片下载器
 *
 * @author Gloomy
 * @date 2016年07月02日16:38:08
 */
public class ImageDownLoad implements Runnable {

    private Context context;
    private String tag;
    private Thread thread;
    private URL url;
    private File cacheFile;
    private OnDownloadListener listener;
    private ZoomImageView imageView;
    private Handler mHandler;
    private int araeImgRes = -1;

    /**
     * 创建,并且开始下载一个图片
     *
     * @param context 上下文
     * @param url     图片的url
     */
    public ImageDownLoad(Context context, String url) {
        this.context = context;
        cacheFile = context.getCacheDir();
        cacheFile = new File(cacheFile, "gloomy_img_download");
        if (!cacheFile.exists())
            cacheFile.mkdirs();
        mHandler = new Handler();

        this.tag = url;

        setImageDownloadPath(url);

        try {
            this.url = new URL(url);
        } catch (MalformedURLException e) {
            new RuntimeException("URL不正确!");
        }
        this.thread = new Thread(this);
    }

    /**
     * 设置图片下载的存放绝对路径
     *
     * @param url 图片的URL
     */
    private void setImageDownloadPath(String url) {
        String md5 = com.gloomyer.zoomimageview.Utils.getMD5(url);
        cacheFile = new File(cacheFile, md5);
    }

    /**
     * 开始任务
     */
    public void start() {
        Log.i("test", cacheFile.getAbsolutePath());
        if (cacheFile.exists()) {
            //已经下载过了,直接调用完成回调
            Bitmap bitmap = Utils.createBitmap(cacheFile.getAbsolutePath());
            if (listener != null)
                listener.onFinish(bitmap);

            if (imageView != null && tag.equals(((String) imageView.getTag()))) {
                imageView.setImageBitmap(bitmap);
            }
        } else {
            thread.start();
        }

    }

    @Override
    public void run() {
        /**
         * 调用开始回调
         */
        if (mHandler != null && listener != null)
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    if (araeImgRes > 0)
                        imageView.setImageResource(araeImgRes);
                    listener.onStart();
                }
            });

        try {
            URLConnection conn = url.openConnection();

            InputStream is = conn.getInputStream();
            FileOutputStream fos = new FileOutputStream(cacheFile);

            byte[] butter = new byte[1024];

            int len = -1;

            while ((len = is.read(butter)) != -1) {
                fos.write(butter, 0, len);
            }

            final Bitmap bitmap = com.gloomyer.zoomimageview.Utils.createBitmap(cacheFile.getAbsolutePath());
            // 下载完成,调用完成回调
            if (mHandler != null) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        if (listener != null)
                            listener.onFinish(bitmap);

                        if (imageView != null && tag.equals(((String) imageView.getTag())))
                            imageView.setImageBitmap(bitmap);
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置下载监听
     *
     * @param listener
     * @return
     */
    public ImageDownLoad setOnDownloadListener(com.gloomyer.zoomimageview.OnDownloadListener listener) {
        if (listener == null)
            new NullPointerException("监听不能为空!");

        this.listener = listener;
        return this;
    }

    /**
     * 下载完成后,自动设置至ImageVIew
     *
     * @param iv 要设置图片的Imagev, 注意,这个ImageView不能设置tag
     * @return
     */
    public ImageDownLoad into(ZoomImageView iv) {
        this.imageView = iv;
        iv.setTag(tag);
        return this;
    }

    public ImageDownLoad placeholder(int araeImgRes) {
        this.araeImgRes = araeImgRes;
        return this;
    }
}

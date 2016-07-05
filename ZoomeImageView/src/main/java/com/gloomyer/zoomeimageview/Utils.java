package com.gloomyer.zoomeimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 工具类
 *
 * @author Gloomy
 * @date 2016年07月02日16:52:46
 */
public class Utils {

    /**
     * MD5加密
     *
     * @param info 要加密的字符串
     * @return 加密完成的字符串
     */
    public static String getMD5(String info) {
        String result = "加密失败";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(info.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }

    private static int screenWidth;

    public static int getScreenWidth(Context context) {
        if (screenWidth > 0)
            return screenWidth;
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        screenWidth = outMetrics.widthPixels;
        return screenWidth;
    }

    /**
     * 根据路径创建Bitmap
     *
     * @param path 图像的绝对路径
     * @return
     */
    public static Bitmap createBitmap(String path) {
        return BitmapFactory.decodeFile(path);
    }
}

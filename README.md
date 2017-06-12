## ZoomImageView  ##

###  概述:  ###

一个大图预览ImageVIew

支持多点触控自由缩放.支持ViewPager多图预览(解决事件冲突)

如果当前预览图片是长图(比如漫画页),将不全图缩略加载,而是直接加载,方便阅读.

---

###  使用:  ###

下载该项目,导入ZoomImageView.

app是Demo

设置图片加载框架加载图片即可

###  版本说明  ###

1.1版本:  
修复1.0版本Bug:  
支持setOnClickListener(1.0版本因为重写了onTouchListener不支持)  
修改了图片初始缩放参数(更加完善)  
增加了新功能:  
占位图:使用自带的图片缓存框架加载图片时候,可以使用placeholder(int resID)来设置占位图了.<font color='#aa0000'>请务必在调用setImageForUrl之前调用!</font>  
如果是使用setImageResource() 或 setImageBitmap() 方法设置图片,将不需要手动调用reSetState()方法了.  
  
1.2版本:  
完善了Demo  
解决了重复加载时,需要手动调用reSetStatus()方法  
支持了图片加载框架来设置占位图  
移除ImageDownload辅助类;  
请使用第三方图片加载框架  
增加测试:  
Glide:完美  
Picasso:不支持动图/长图..
ImageLoader:不支持动图,长图会模糊!  
  
推荐图片加载框架:Glide  
  
1.3版本:
修复占位图位图放大bug
调用如下:
```java
ziv = (ZoomImageView) findViewById(R.id.ziv);
ziv.placeholder(R.mipmap.ic_launcher);
Glide.with(this)
.load(url)
.asBitmap()
.placeholder(R.mipmap.ic_launcher)
.into(ziv);
```

1.4版本  
更新Gradle to 3.3  
更新Demo  
单图浏览、多图浏览增加点击退出示例  
增加一个5.0过场动画使用的demo  

---
如果发现什么Bug,欢迎提交给我!

Email:gloomyneter@gmail.com

Blog:http://gloomyer.com

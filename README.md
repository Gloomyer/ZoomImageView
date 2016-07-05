# ZoomImageView

概述:

一个大图预览ImageVIew

支持多点触控自由缩放.支持ViewPager多图预览(解决事件冲突)

如果当前预览图片是长图(比如漫画页),将不全图缩略加载,而是直接加载,方便阅读.

---

使用:

下载该项目,导入ZoomImageView.

app是Demo

设置图片即可,

<font color='#aa0000'>请注意,如果是重复设置图片,请务必在重新设置图片之前,调用reSetState()方法!</font>

内部写了一个小的图片缓存(磁盘/网络缓存)框架(有复用检查)

直接调用setImageForUrl("");//这里直接填写图片的url即可.

但是请注意,这个小的图片缓存框架加载图片不会对图片进行任何处理!!!

如果需要使用这个图片框架,并且你的后台服务器不支持缩放图片.

那么你将需要重写ZoomImageView库中的Utils类里面的createBitmap()方法.

因为图片下载完成,把下载完成的图片加载至内存中是由这个方法来干的.

---

1.1版本:

修复1.0版本Bug:

支持setOnClickListener(1.0版本因为重写了onTouchListener不支持)

修改了图片初始缩放参数(更加完善)

增加了新功能:

占位图:使用自带的图片缓存框架加载图片时候,可以使用placeholder(int resID)来设置占位图了.<font color='#aa0000'>请务必在调用setImageForUrl之前调用!</font>

如果是使用setImageResource() 或 setImageBitmap() 方法设置图片,将不需要手动调用reSetState()方法了.

---



如果需要加载gif图片,请使用[Glide](https://github.com/bumptech/glide)去加载.



如果发现什么Bug,欢迎提交给我!

Email:gloomyneter@gmail.com

Blog:http://gloomyer.com

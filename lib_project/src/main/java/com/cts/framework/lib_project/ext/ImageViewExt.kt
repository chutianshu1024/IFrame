//package com.zytdsj.citywindow.lib_project.ext
//
//import android.graphics.drawable.Drawable
//import android.widget.ImageView
//import androidx.annotation.DrawableRes
//import com.bumptech.glide.load.engine.DiskCacheStrategy
//import com.bumptech.glide.load.resource.bitmap.CenterCrop
//import com.bumptech.glide.load.resource.bitmap.CircleCrop
//import com.bumptech.glide.load.resource.bitmap.RoundedCorners
//import com.bumptech.glide.load.resource.gif.GifDrawable
//import com.bumptech.glide.request.RequestOptions
//import com.bumptech.glide.request.target.SimpleTarget
//import com.bumptech.glide.request.transition.Transition
//import com.zytdsj.citywindow.lib_project.R
//import com.zytdsj.citywindow.lib_project.config.glide.GlideApp
//import com.zytdsj.citywindow.lib_project.utils.glide.GlideCircleBorderTransform
//
///**
// * @Description: Imageview拓展函数
// * @Author: CTS
// * @Date: 2019/6/14 19:09
// */
//
///**
// * 默认有centerCrop效果
// */
//inline fun ImageView.loadUrl(url: String?, skipMemoryCache: Boolean) {
//    if (url.isNullOrBlank()) {//加载默认图片
//        GlideApp.with(context)
//            .load(R.drawable.shape_placeholder_rec_rad3)
//            .into(this)
//        return
//    }
//
//    GlideApp.with(context)
////            .asBitmap()
//        .load(url)
//        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//        .skipMemoryCache(skipMemoryCache)
//        .error(R.drawable.shape_placeholder_rec_rad3)
//        .dontAnimate()
////        .placeholder(R.drawable.shape_placeholder_rec)
////        .error(R.drawable.shape_placeholder_rec)
//        .centerCrop()
//        .into(this)
//}
//
///**
// * 不带centerCrop效果的（默认填充）
// */
//inline fun ImageView.loadUrlNoCenter(url: String?, skipMemoryCache: Boolean) {
//    if (url.isNullOrBlank()) {
//        GlideApp.with(context)
//            .load(R.drawable.shape_placeholder_rec_rad3)
//            .into(this)
//        return
//    }
//
//    GlideApp.with(context)
////            .asBitmap()
//        .load(url)
//        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//        .skipMemoryCache(skipMemoryCache)
//        .error(R.drawable.shape_placeholder_rec_rad3)
//        .dontAnimate()
////        .placeholder(R.drawable.shape_placeholder_rec)
////        .error(R.drawable.shape_placeholder_rec)
//        .into(this)
//}
//
///**
// * 加载头像:有默认图
// */
//inline fun ImageView.loadHeadUrl(url: String?, skipMemoryCache: Boolean) {
//    if (url.isNullOrBlank()) {
//        GlideApp.with(context)
//            .load(R.mipmap.friend_urban_circle_icon_head_portrait)
//            .into(this)
//        return
//    }
//
//    GlideApp.with(context)
//        .load(url)
//        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//        .skipMemoryCache(skipMemoryCache)
//        .error(R.mipmap.friend_urban_circle_icon_head_portrait)
//        .dontAnimate()
//        .centerCrop()
//        .into(this)
//}
//
//
///**
// * 圆形图-头像（一般为头像，所以要填失败图和占位图）
// */
//inline fun ImageView.loadUrlCircleHeadImg(url: String?) {
//    if (url.isNullOrBlank()) {
//        GlideApp.with(context)
//            .load(R.drawable.ic_headimg_circle)
//            .into(this)
//        return
//    }
//
//    GlideApp.with(context)
////            .asBitmap()
//        .load(url)
//        .apply(RequestOptions.bitmapTransform(CircleCrop()))
//        .placeholder(R.drawable.ic_headimg_circle)
//        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//        .skipMemoryCache(false)
//        .error(R.drawable.ic_headimg_circle)
//        .into(this)
//////
//////    RequestOptions.bitmapTransform(CircleCrop())
////    GlideApp.with(this)
////        .load("http://img5.duitang.com/uploads/item/201506/07/20150607110911_kY5cP.jpeg")
////        .apply(RequestOptions.bitmapTransform(CircleCrop()))
////        .into(this)
//}
//
///**
// * 带边框圆形头像
// */
//inline fun ImageView.loadUrlCircleHeadWithBorder(
//    url: String?,
//    borderWidth: Float,
//    borderColor: Int
//) {
//    if (url.isNullOrBlank()) {
//        GlideApp.with(context)
//            .load(R.drawable.ic_headimg_circle)
//            .into(this)
//        return
//    }
//
//    GlideApp.with(context)
////            .asBitmap()
//        .load(url)
//        .apply(RequestOptions.bitmapTransform(GlideCircleBorderTransform(borderWidth, borderColor)))
//        .placeholder(R.drawable.ic_headimg_circle)
//        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//        .skipMemoryCache(false)
//        .error(R.drawable.ic_headimg_circle)
//        .into(this)
//}
//
///**
// * 带边框圆形图
// */
//inline fun ImageView.loadUrlCircleWithBorder(
//    url: String?,
//    borderWidth: Float,
//    borderColor: Int
//) {
//    if (url.isNullOrBlank()) {
//        GlideApp.with(context)
//            .load(resources.getDrawable(R.drawable.shape_placeholder_circle_img))
//            .into(this)
//        return
//    }
//
//    GlideApp.with(context)
////            .asBitmap()
//        .load(url)
//        .apply(RequestOptions.bitmapTransform(GlideCircleBorderTransform(borderWidth, borderColor)))
//        .placeholder(resources.getDrawable(R.drawable.shape_placeholder_circle_img))
//        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//        .skipMemoryCache(false)
//        .error(resources.getDrawable(R.drawable.shape_placeholder_circle_img))
//        .into(this)
//}
//
///**
// * 圆形图（icon类，带默认图）
// */
//inline fun ImageView.loadUrlIconCircle(url: String?) {
//    if (url.isNullOrBlank()) {
//        GlideApp.with(context)
//            .load(R.drawable.ic_headimg_circle)
//            .into(this)
//        return
//    }
//
//    GlideApp.with(context)
////            .asBitmap()
//        .load(url)
//        .apply(RequestOptions.bitmapTransform(CircleCrop()))
//        .placeholder(R.drawable.ic_headimg_circle)
//        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//        .skipMemoryCache(false)
//        .error(R.drawable.ic_headimg_circle)
//        .into(this)
//}
//
///**
// * 圆形图（自定义失败图片）
// */
//inline fun ImageView.loadUrlCircle(url: String?, @DrawableRes placeholder: Int, @DrawableRes errorResId: Int) {
//    if (url.isNullOrBlank()) {
//        GlideApp.with(context)
//            .load(placeholder)
//            .into(this)
//        return
//    }
//
//    GlideApp.with(context)
////            .asBitmap()
//        .load(url)
//        .apply(RequestOptions.bitmapTransform(CircleCrop()))
//        .placeholder(placeholder)
//        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//        .skipMemoryCache(false)
//        .error(errorResId)
//        .into(this)
//}
//
/////**
//// * 加载超长图
//// */
////inline fun ImageView.loadLongImg(url: String?, skipMemoryCache: Boolean) {
////    if (url.isNullOrBlank()) {
////        logD("图片路径为null")
////        return
////    }
////
////    GlideApp.with(this)
////        .load(url)
////        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
////        .skipMemoryCache(skipMemoryCache)
////        .downloadOnly(object : SimpleTarget<File>() {
////            override fun onResourceReady(resource: File, transition: Transition<in File>?) {
//////                setImageURI(Uri.fromFile(resource))
////                // 将保存的图片地址给SubsamplingScaleImageView,这里注意设置ImageViewState设置初始显示比例
////                var bitmap = BitmapFactory.decodeFile(resource.getAbsolutePath(), null)
//////                bitmap.width = ScreenUtils.getScreenWidth()
////                // 显示处理好的Bitmap图片
////                setImageBitmap(bitmap)
////            }
////        })
////}
////
//
///**
// * 通用圆角网络图（默认图圆角度数为3）
// */
//inline fun ImageView.loadUrlRounded(url: String?, roundedCorners: Int, skipMemory: Boolean) {
//    if (url.isNullOrBlank()) {
//        GlideApp.with(context)
//            .load(R.drawable.shape_placeholder_rec_rad3)
//            .into(this)
//        return
//    }
//
//    GlideApp.with(context)
////            .asBitmap()
//        .load(url)
//        .apply(
//            RequestOptions().transforms(
//                CenterCrop(), RoundedCorners(roundedCorners)
//            )
//        )
//        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
//        .apply { placeholder(R.drawable.shape_placeholder_rec_rad3) }
////            .placeholder(placeholder)
//        .skipMemoryCache(skipMemory)
//        .error(R.drawable.shape_placeholder_rec_rad3)
//        .dontAnimate()
//        .into(this)
//}
//
///**
// * 复杂图片加载用这个
// * roundedCorners:圆角度数，0为没有圆角
// * placeholder：占位图
// * errorResId：失败图片
// * cacheType：缓存方式
// * skipMemory：是否跳过内存缓存
// */
//inline fun ImageView.loadUrlComplex(
//    url: String?, roundedCorners: Int, placeholder: Int, errorResId: Int
//    , cacheType: DiskCacheStrategy, skipMemory: Boolean
//) {
//    if (url.isNullOrBlank()) {
//        GlideApp.with(context)
//            .load(errorResId)
//            .into(this)
//        return
//    }
//
//    if (roundedCorners > 0) {
//        GlideApp.with(context)
//            .asBitmap()
//            .load(url)
//            //直接调用会导致圆角被CenterCrop覆盖
////                        .transition(DrawableTransitionOptions().crossFade(200))//渐显效果
//            .diskCacheStrategy(cacheType)
//            .apply(
//                RequestOptions().transforms(
//                    CenterCrop(), RoundedCorners(roundedCorners)
//                )
//            )
//            .apply { if (placeholder != 0) placeholder(placeholder) }
////            .placeholder(placeholder)
//            .skipMemoryCache(skipMemory)
//            .error(errorResId)
//            .dontAnimate()
//            .into(this)
//
//    } else {
//        GlideApp.with(context)
////            .asBitmap()
//            .load(url)
////                        .transition(DrawableTransitionOptions().crossFade(200))//渐显效果
//            .diskCacheStrategy(cacheType)
//            .apply { if (placeholder != 0) placeholder(placeholder) }
//            .skipMemoryCache(skipMemory)
//            .error(errorResId)
//            .centerCrop()
//            .dontAnimate()
//            .into(this)
//    }
//
//}
//
///**
// * 加载gif
// */
//inline fun ImageView.loadGif(resourceId: Int) {
//    GlideApp.with(this).load(resourceId).into(this)
//}
//
///**
// * 加载本地图片，通过资源id
// */
//inline fun ImageView.loadByResourceId(resourceId: Int) {
//    GlideApp.with(this).load(resourceId).into(this)
//}
//
///**
// * gif动画次数[count]
// */
//inline fun ImageView.loadGifByCount(resourceId: Int, count: Int) {
//    GlideApp.with(this).load(resourceId).into(object : SimpleTarget<Drawable>() {
//        override fun onResourceReady(drawable: Drawable, transition: Transition<in Drawable>?) {
//            if (drawable is GifDrawable) {
//                var gifDrawable = drawable
//                gifDrawable.setLoopCount(count)
//                setImageDrawable(drawable)
//                gifDrawable.start()
//            }
//        }
//    })
//}
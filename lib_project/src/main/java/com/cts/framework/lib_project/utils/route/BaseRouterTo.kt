//package com.zytdsj.citywindow.lib_project.utils.route
//
//import android.content.Context
//import android.content.Intent
//import android.os.Parcelable
//import com.alibaba.android.arouter.launcher.ARouter
//import com.zytdsj.citywindow.lib_project.arouter.RouterPath
//import com.zytdsj.citywindow.lib_project.base.BaseActivity
//import com.zytdsj.citywindow.lib_project.source.bean.ShareDataBean
//import com.zytdsj.citywindow.lib_project.source.bean.ShareModel
//import com.zytdsj.citywindow.lib_project.cache.account.CacheAccountUtil
//import com.zytdsj.citywindow.lib_project.constants.BaseConfigConstants
//import com.zytdsj.citywindow.lib_project.view.dialog2popup.share.ShareDialog
//
///**
// * @Description: 基础跳转类
// * @Author: lipo
// * @Date: 2020-01-20 18:22
// */
//open class BaseRouterTo {
//
//    /**
//     * 分享
//     */
//    fun jumpToShare(
//        mContext: Context,
//        info: ShareDataBean,
//        callBack: (bean: ShareDataBean) -> Unit
//    ) {
//        var shareContentUrl = info.shareContentUrl
//        if (!shareContentUrl.startsWith("http://") && !shareContentUrl.startsWith("https://")) {
//            shareContentUrl = "http://${shareContentUrl}"
//        }
//
//        if (shareContentUrl.split("?").size > 1) {
//            shareContentUrl = "$shareContentUrl&share_user=${CacheAccountUtil.instance.getUserId()}"
//        } else {
//            shareContentUrl = "$shareContentUrl?share_user=${CacheAccountUtil.instance.getUserId()}"
//        }
//
//        ShareDialog(
//            mContext,
//            ShareModel(
//                info.shareTitle,
//                info.shareImageUrl,
//                info.shareContent,
//                shareContentUrl,
//                info.shareSmsContent
//            ),
//            BaseConfigConstants.list_share_common,
//            BaseConfigConstants.list_share_common2,
//            object : ShareDialog.ClickShareListener {
//                override fun shareClick(platform: BaseConfigConstants.Companion.ShareEnum) {
//                    //上传分享记录
//                    info.platform = platform
//                    callBack(info)
//                }
//            }
//        ).showDialog()
//    }
//
//    /**
//     * 阿里路由跳转
//     * 路劲[path]
//     */
//    fun jumpTo(path: String) {
//        val postCard = ARouter.getInstance().build(path)
//        postCard.navigation()
//    }
//
//    fun jumpTo(path: String, key: String, value: Parcelable) {
//        val postCard = ARouter.getInstance().build(path)
//        postCard.withParcelable(key, value)
//        postCard.navigation()
//    }
//
//    fun jumpToForResult(mContext: BaseActivity, path: String, key: String, value: Parcelable, code:Int) {
//        val postCard = ARouter.getInstance().build(path)
//        postCard.withParcelable(key, value)
//        postCard.navigation(mContext,code)
//    }
//
//    fun jumpTo(path: String, key: String, value: String) {
//        val postCard = ARouter.getInstance().build(path)
//        postCard.withString(key, value)
//        postCard.navigation()
//    }
//
//    fun jumpTo(path: String, key: String, value: Int) {
//        val postCard = ARouter.getInstance().build(path)
//        postCard.withInt(key, value)
//        postCard.navigation()
//    }
//
//    fun jumpToLogin() {
//        if(!ifLogin){
//            ARouter.getInstance().build(RouterPath.LG_TO_LOGIN).navigation()
//        }
//
//    }
//
//    companion object{
//        //
//        var ifLogin:Boolean = false
//    }
//}
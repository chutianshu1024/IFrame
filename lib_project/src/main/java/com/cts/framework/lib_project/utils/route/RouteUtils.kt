//package com.zytdsj.citywindow.lib_project.utils.route
//
//import com.alibaba.android.arouter.launcher.ARouter
//import com.zytdsj.citywindow.lib_project.ui.activity.H5Activity
//import com.zytdsj.citywindow.lib_project.arouter.RouterPath
//import com.zytdsj.citywindow.lib_project.cache.config.CacheConfigByNetUserUtil
//import com.zytdsj.citywindow.lib_project.utils.ToastUtils
//
///**
// * @Description: App路由相关
// * @Author: CTS
// * @Date: 2019/10/14 14:36
// */
//class RouteUtils private constructor() {
//    companion object {
//        val instance: RouteUtils by lazy { RouteUtils() }
//    }
//
//    /**
//     * 设置banner、广告等跳转
//     * [type]跳转类型  0.原生    1.h5
//     * [routerPath]跳转url   如果是原生，就传Arouter路径，如果是H5就传url
//     * 注：如果需要参数，也在这里处理。（参数拼接进url中，在这里分离出来）
//     */
//    fun pageJump(type: String, routerPath: String, title: String) {
//        if (type == "0") {//跳转原生
//            //先拦截需要手动处理的
//            when (routerPath) {
//                "/na/sport_home" -> {//跳转运动
//                    if (CacheConfigByNetUserUtil.instance.getOpenSportStatus()) {
//                        ARouter.getInstance().build(RouterPath.HOME_WISESPORTS)
//                            .navigation()
//                    } else {
//                        ARouter.getInstance().build(RouterPath.WISE_HOME_WELCOME)
//                            .navigation()
//                    }
//                }
//                "/na/pwelfare_home" -> {//跳转公益
//                    ToastUtils.getInstance().toastShow("暂未开放")
////                    if (CacheConfigByNetUserUtil.instance.getOpenWelfareStatus()) {
////                        ARouter.getInstance().build(RouterPath.PUBLIC_HOME_PAGE)
////                            .navigation()
////                    } else {
////                        ARouter.getInstance().build(RouterPath.PUBLIC_HOME_WELCOME)
////                            .navigation()
////                    }
//                }
//                else -> {//其他都按照路由跳转
//                    if (routerPath.startsWith("/")) {//防止后台异常数据，做个校验
//
//                        ARouter.getInstance().build(routerPath).navigation()
//                    }
//
//                }
//            }
//        } else {//跳转H5
//            ARouter.getInstance().build(RouterPath.LIB_H5)
//                .withString(H5Activity.PARAM_TITLE, title)
//                .withString(H5Activity.PARAM_URL, routerPath)
//                .navigation()
//        }
//    }
//}
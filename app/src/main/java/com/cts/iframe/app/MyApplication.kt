package com.cts.iframe.app

import com.cts.framework.lib_project.application.BaseApplication
import com.tencent.smtt.export.external.TbsCoreSettings
import com.tencent.smtt.sdk.QbSdk
import com.tencent.smtt.sdk.QbSdk.PreInitCallback


/**
 * @Description: application基类
 * @Author: CTS
 * @Date: 2019/7/6 14:37
 */
class MyApplication : BaseApplication() {


    override fun onCreate() {
        super.onCreate()

        // 在调用TBS初始化、创建WebView之前进行如下配置，以开启优化方案
        val map = HashMap<String, Any>()
        map[TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER] = true
        QbSdk.initTbsSettings(map)

        //非wifi情况下，主动下载x5内核
        QbSdk.setDownloadWithoutWifi(true)
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        val cb: PreInitCallback = object : PreInitCallback {
            override fun onViewInitFinished(arg0: Boolean) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
            }

            override fun onCoreInitFinished() {
            }
        }
        //x5内核初始化接口
        QbSdk.initX5Environment(applicationContext, cb)

    }
}

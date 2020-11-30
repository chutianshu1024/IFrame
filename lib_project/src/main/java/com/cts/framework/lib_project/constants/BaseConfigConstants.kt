package com.cts.framework.lib_project.constants

/**
 * @Description: 基础参数
 * @Author: CTS
 * @Date: 2019/7/31 17:42
 */
class BaseConfigConstants {
    companion object {
        //时间选择器时间范围
        const val timesel_start_year = 2018
        const val timesel_start_month = 0
        const val timesel_start_date = 1

        const val timesel_end_year = 2050
        const val timesel_end_month = 11
        const val timesel_end_date = 30

        //Bugly appId
        const val BUGLY_APPID = "53c658b715"

        //分享平台枚举
        enum class ShareEnum {
            QQ, QQF, WX, WXF,
            FRI,//平台的朋友圈
            CITY,//平台的城市圈
            SINA,//新浪微博
            ALIP,//支付宝
            DD,//钉钉
            SMS,//短信
            PIC,//分享图片
            LINK//链接
        }

        //常用分享枚举配置（第一行，三方面平台分享）
        val list_share_common = arrayListOf(
            ShareEnum.WX,
            ShareEnum.WXF,
            ShareEnum.QQ,
            ShareEnum.QQF,
            ShareEnum.SINA,
            ShareEnum.ALIP,
            ShareEnum.DD
        )
        //常用分享枚举配置（第二行手机功能分享）
        val list_share_common2 = arrayListOf(
            ShareEnum.SMS,
            ShareEnum.PIC,
            ShareEnum.LINK
        )

        /**
         * 客服相关
         */
        const val SERVER_CARDPACGAGE = "卡包"
        const val SERVER_VOUCHERCENTER = "充值中心"
        const val SERVER_LIVINGEXPENXEX = "生活缴费"
        const val SERVER_PUBLICWELFARE = "公益"
        const val SERVER_VOUCHERCENTERBILLDETAILS = "充值中心—账单详情"
        const val SERVER_VOUCHERCENTER_PAYMENTSUCCESS = "充值中心—支付成功—对此订单有疑问"
        const val SERVER_REDSTAR = "红星"
        const val SERVER_CREDIT = "信用通"


        /**
         * 三方应用包名
         */
        //百度和高德地图的包名
        const val BAIDU_MAP_PACKAGE = "com.baidu.BaiduMap"
        const val ALI_MAP_PACKAGE = "com.autonavi.minimap"

        //应用宝
        const val YYB_PACKAGE = "com.tencent.android.qqdownloader"
        //百度
        const val BAIDU_PACKAGE = "com.baidu.appsearch"

        //市场相关包名list
        val MARKET_LIST = arrayListOf(YYB_PACKAGE, BAIDU_PACKAGE)


        /**
         * App UI相关配置
         */
        //dialog透明度，统一配置
        const val DIALOG_DIMAMOUNT = 0.2f

        //消息中心的消息类型
        enum class MessageModule {
            ALL,//所有消息
            MED,//医疗模块
        }
    }
}
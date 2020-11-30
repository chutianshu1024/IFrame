package com.cts.framework.lib_project.constants

/**
 * @Description: 协议
 * @Author: qdwang
 * @Date: 2019/9/11
 * @Note:
 */
class AgreementConstants {

    companion object {

        /**
         * 卡包模块
         */
        //年卡申退说明
        var CARD_REFUND =
            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-card-backpage/card-statement-niankashentuishuoming"

        //用户授权协议
        var BASE_USER_AGREEMENT =
            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-welfare-medical-authorizationpage/zhihuiyiliaoyonghufuwuxieyi"

        //亲情卡使用说明
        var CARD_FAMILY_DESC =
            "http://www.chengshizhichuang.com/dygacontent-management-app/content/dealinfo/window-of-city-card-family/familycardshuoming"

        /**
         * 公益模块
         */
        //公益账户服务协议
        var PUBW_ACCOUNT =
            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window_of_city-welfare-openpage/gongyizhanghufuwuxieyi"

        //爱心捐赠协议
        var PUBW_HEART =
            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/welfare-fukuan/welfare-agreement-juanzengxieyi"

        //公益授权协议
        var PUBW_AUTHOR =
            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window-of-city-welfare-homepage-setpage/gongyizhanghushouquanxieyi"


        /**
         * 运动模块
         */
        //运动账户服务协议
        var SPORT_ACCOUNT =
            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/sport-home/sport-agreement-fuwuxieyi"


        /**
         * 生活缴费
         */
        //德一自助缴费协议
        var LS_PAYCOST =
            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/payment-alladduser/payment-agreement-zizhujiaofei"

        //关于
        //城市之窗软件许可协议
        var SOFTWARE_LICENSE_AGREEMENT =
            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window-of-city-base-setpage-aboutpage/zhengwutongruanjianxukexieyi"

        //城市之窗隐私保护协议
        var PRIVACY_PROTECTION_AGREEMENT =
            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window-of-city-base-setpage-aboutpage/zhengwutongyinsibaohuxieyi"

        //关于
        //功能介绍
        var ABOUT_INTRODUCTION =
            "http://www.chengshizhichuang.com/pay/informPage"

        //信用通---公司信息及合法声明
        var CREDIT_STATEMENT_AGREEMENT =
            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-credit-homepage/credit-statement-gongsixinxijihefashengming"

        //信用通---信用通服务协议
        var CREDIT_SERVICE_AGREEMENT =
            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-credit-homepage/credit-agreement-xinyongtongfuwuxieyi"

        //信用通---数据安全及隐私权保护政策
        var CREDIT_SAFETY_AGREEMENT =
            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-credit-homepage/credit-agreement-shujuanquanjiyinsiquanbaohuzhengce"


        //城市之窗及客户端服务协议
        var LG_SERVICE_AGREEMENT =
            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window-of-city-base-login_registpage/base-agreement-zhengwutongjikehuduanfuwuxieyi"

        //城市之窗隐私权政策
        var LG_PRIVACY_AGREEMENT =
            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window-of-city-base-login_registpage/base-agreement-zhengwutongyinsiquanzhengce"

        //设置-隐私-隐私政策
        var SETTING_YS_YSZC =
            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-base-setpage-privacypage/base-agreement-chengshizhichuangyinsizhengce"

        //生物识别通用规则
        var SETTING_BIOMETRICS =
            "http://www.chengshizhichuang.com/dygacontent-management-app/content/dealinfo/window-of-city-base-biology/biologytongyongguize"


        //智慧医疗-电子健康卡帮助说明
        var MED_CARD_HELP =
            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-medical-healthcodepage/bangzhushuoming"

        //智慧医疗-电子健康卡开卡协议
        var MED_CARD_XY =
            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-medical-healthcodepage/dianzijiankangkafuwuxieyi"
    }

//    companion object {
//
//        /**
//         * 卡包模块
//         */
//        //年卡申退说明
//        const val CARD_REFUND =
//            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-card-backpage/card-statement-niankashentuishuoming"
//
//        //用户授权协议
//        const val BASE_USER_AGREEMENT =
//            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-welfare-medical-authorizationpage/zhihuiyiliaoyonghufuwuxieyi"
//
//        //亲情卡使用说明
//        const val CARD_FAMILY_DESC =
//            "http://www.chengshizhichuang.com/dygacontent-management-app/content/dealinfo/window-of-city-card-family/familycardshuoming"
//
//        /**
//         * 公益模块
//         */
//        //公益账户服务协议
//        const val PUBW_ACCOUNT =
//            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window_of_city-welfare-openpage/gongyizhanghufuwuxieyi"
//
//        //爱心捐赠协议
//        const val PUBW_HEART =
//            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/welfare-fukuan/welfare-agreement-juanzengxieyi"
//
//        //公益授权协议
//        const val PUBW_AUTHOR =
//            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window-of-city-welfare-homepage-setpage/gongyizhanghushouquanxieyi"
//
//
//        /**
//         * 运动模块
//         */
//        //运动账户服务协议
//        const val SPORT_ACCOUNT =
//            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/sport-home/sport-agreement-fuwuxieyi"
//
//
//        /**
//         * 生活缴费
//         */
//        //德一自助缴费协议
//        const val LS_PAYCOST =
//            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/payment-alladduser/payment-agreement-zizhujiaofei"
//
//        //关于
//        //城市之窗软件许可协议
//        const val SOFTWARE_LICENSE_AGREEMENT =
//            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window-of-city-base-setpage-aboutpage/zhengwutongruanjianxukexieyi"
//
//        //城市之窗隐私保护协议
//        const val PRIVACY_PROTECTION_AGREEMENT =
//            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window-of-city-base-setpage-aboutpage/zhengwutongyinsibaohuxieyi"
//
//        //关于
//        //功能介绍
//        const val ABOUT_INTRODUCTION =
//            "http://www.chengshizhichuang.com/pay/informPage"
//
//        //信用通---公司信息及合法声明
//        const val CREDIT_STATEMENT_AGREEMENT =
//            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-credit-homepage/credit-statement-gongsixinxijihefashengming"
//
//        //信用通---信用通服务协议
//        const val CREDIT_SERVICE_AGREEMENT =
//            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-credit-homepage/credit-agreement-xinyongtongfuwuxieyi"
//
//        //信用通---数据安全及隐私权保护政策
//        const val CREDIT_SAFETY_AGREEMENT =
//            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-credit-homepage/credit-agreement-shujuanquanjiyinsiquanbaohuzhengce"
//
//
//        //城市之窗及客户端服务协议
//        const val LG_SERVICE_AGREEMENT =
//            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window-of-city-base-login_registpage/base-agreement-zhengwutongjikehuduanfuwuxieyi"
//
//        //城市之窗隐私权政策
//        const val LG_PRIVACY_AGREEMENT =
//            NetConstants.BASE_URL + "dygacontent-management-service/content/dealinfo/window-of-city-base-login_registpage/base-agreement-zhengwutongyinsiquanzhengce"
//
//        //设置-隐私-隐私政策
//        const val SETTING_YS_YSZC =
//            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-base-setpage-privacypage/base-agreement-chengshizhichuangyinsizhengce"
//
//        //生物识别通用规则
//        const val SETTING_BIOMETRICS =
//            "http://www.chengshizhichuang.com/dygacontent-management-app/content/dealinfo/window-of-city-base-biology/biologytongyongguize"
//
//
//        //智慧医疗-电子健康卡帮助说明
//        const val MED_CARD_HELP =
//            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-medical-healthcodepage/bangzhushuoming"
//
//        //智慧医疗-电子健康卡开卡协议
//        const val MED_CARD_XY =
//            NetConstants.BASE_URL + "dygacontent-management-app/content/dealinfo/window-of-city-medical-healthcodepage/dianzijiankangkafuwuxieyi"
//    }
}
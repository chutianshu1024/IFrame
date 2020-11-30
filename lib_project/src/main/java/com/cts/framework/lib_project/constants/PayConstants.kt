package com.cts.framework.lib_project.constants

/**
 * @Description: 支付相关常量
 * @Author: CTS
 * @Date: 2019/8/17 15:50
 */
open class PayConstants {
    companion object {
        //微信appId
        open val WxAPPID = "wx4c0b364da1b44875"

        val INTENT_KEY_MODELALL = "intent_key_model_all"
        val INTENT_KEY_MODEL_LIFE_PAY = "intent_key_model_life_pay"

        val REQUESTCODE_OPENFAMILYCARD = "requestCode_openfamilycard"//添加亲情卡-支付请求码
    }
}

//支付请求来源
enum class PayFrom {
    LIFE_PAY,//生活缴费
    RECHARGE_CENTER,//充值中心
    CARD_PACKAGE,//卡包
    BALANCE,//余额
    PUBLIC_WELFARE//公益
}

//支付方式
enum class PayType {
    TYPE_ALI,
    TYPE_WX,
    TYPE_BALANCE,
    TYPE_BANKCARD
}

enum class PayResult {
    PAY_SUCCESS,
    PAY_FAILED,
    PAY_CANCEL,
    PAY_OTHER//支付失败的其他情况，一般不用处理，只toast
}
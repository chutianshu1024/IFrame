package com.cts.ihttp.bean

/**
 * @Description:
 * @Author: CTS
 * @Date: 2020/11/2 10:37
 */
//用户资料
class UserTipsData(
        var is_admin: Int = 0,
        var userinfo: UserTipsInfo? = null
)

//接上
data class UserTipsInfo(
        var nickname: String? = null,
        var original_name: String? = null,
        var appface: String? = null,
        var sex: Int = 0,
        var age: Int = 0,
        var uid: Int = 0,
        var numid: Int = 0,
        var follow: Int = 0,
        var level: Int = 0,
        var isVerfy: Int = 0,
        var is_admin: Int = 0,
        var is_block: Int = 0,
        var mystery: Int = 0,
        //var honor: RoomHonor? = null,//荣誉暂时没加
        var isgoldmaster: Int = 0,// 1金牌主播
        var location: String? = null,
        var intro: String? = null,
        var costlevel: Int = 0,
        var rcostlevel: Int = 0,
        var royal_card_bg: String? = null,
        var fansCount: Int = 0,
        var histroy_bean: Int = 0)
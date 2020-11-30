package com.cts.ihttp.bean

/**
 * @Description: 小游戏相关bean
 * @Author: CTS
 * @Date: 2020/10/21 12:10
 */
//你画我猜-通用bean
data class GuessDBean(
        var _hangup_msg: String? = "",
        var _mybean: Int? = 0,
        var _mycoin: Int? = 0,
        var _mygold: Int? = 0,
        var _sex: String? = "",
        var bean: Int? = 0,
        var fappface: String? = "",
        var friendlevel: Int? = 0,
        var game_id: String? = "",
        var illegal: Int? = 0,
        var illegal_seconds: Int? = 0,
        var income: Int? = 0,
        var price: Int? = 0,
        var price_txt: String? = "",
        var rt_id: String? = "",
        var tappface: String? = "",
        var type: Int? = 3,//类型  3.音频； 4.视频
        var touid: String? = ""//被邀请人uid
)

//你画我猜-im消息bean
class GuessDrawImBean(
        var drawUid: String? = "",
        var msg: String? = "",
        var questionList: List<GuessDSelectTopicBean>? = listOf(),//题目
        var type: Int? = 0,//业务类型
        var waitTime: Int? = 0,//延时
        var suspectUid: String? = "",
        var drawstr: String? = "",//绘图数据
        var answer: String? = "",//答案
        var start_position: String? = "",//起止点坐标，用于删除最后一画
        var end_position: String? = "",
        var title: String? = "", //答案
        var resolution: String? = "",//屏幕分辨率
        var is_true: Int? = 0,//是否答对 0.否  1.是
)

//接上  你画我猜-选择题目
data class GuessDSelectTopicBean(
        var id: String? = "",
        var status: String? = "",
        var tips_1: String? = "",
        var tips_2: String? = "",
        var title: String? = ""
)

//你画我猜-邀请通知消息
class GuessDrawInviteBean(
        var uid: String? = "",
        var chat_from: String? = "",
        var from_type: String? = "",
        var rt_id: String? = "",//音视频id
        var nickname: String? = "",//对方昵称
        var game_id: String? = "",//游戏id
        var tappface: String? = "",//头像
        var type: Int? = 0,//类型  3.音频； 4.视频
        var fuid: Int? = 0//发起人的uid
)

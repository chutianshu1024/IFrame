package com.cts.framework.lib_project.constants

class SPKeyConfigConstants {
    companion object {
        //登录相关
        const val loginTime = "sp_user_login_time"
        const val isauth = "sp_user_isauth"

        //用户资料相关
        const val userName = "sp_user_username"
        const val id = "sp_user_id"
        const val status = "sp_user_status"//账号状态(0正常1冻结2封号3注销)
        const val sex = "sp_user_sex"
        const val sex_str = "sp_user_sex_str"//跟上面有区别，这里直接存的“男”或“女”，上面存的是标识
        const val token = "sp_user_token"
        const val phone = "sp_user_phone"//手机号
        const val account = "sp_user_account"//账号（区分手机号，但是暂时是手机号）
        const val head_img = "sp_user_head_img"//头像
        const val login_head_img = "sp_user_login_head_img"//登录头像缓存
        const val agreedDocument = "sp_user_agreedDocument"
        const val addressId = "sp_user_addressId" //城市id
        const val authenticationStatus =
            "sp_user_authenticationStatus"//实名状态  0未认证、1认证中，2认证通过，3认证不通过
        const val personalitySign = "sp_user_personalitySign" //个性签名
        const val userRole = "sp_user_userRole"//用户权限， 0：为普通用户  1：管理员用户

        //账号信息临时缓存，用于登录时展示上一次的用户账号和头像
        const val temp_account = "sp_temp_account"
        const val temp_headimg = "sp_temp_headimg"


        const val creditIsopenStatus = "credit_isopen_status" //是否已开通信息通


        //设置
        const val font_size = "sp_font_size"

        //开机图片相关
        const val CACHE_START_PIC_URL = "sp_cache_start_pic_url"
        const val CACHE_START_PIC = "sp_cache_start_pic"

        /**
         * app本地的缓存相关，不是从接口获取的
         */
        const val CACHE_LOCAL_YEAR_CARD_ACTIVE_POPUP = "sp_cache_local_yearcard_active_popup"
        const val CACHE_LOCAL_ISFIRST_OPEN = "sp_cache_local_isfirst_open"
        const val CACHE_LOCAL_CITYCODE = "sp_cache_local_citycode"//城市编号
        const val CACHE_LOCAL_CITYNAME = "sp_cache_local_cityname"//城市名
        const val CACHE_LOCAL_IS_AGREEMENT = "sp_cache_local_is_agreement"//是否同意协议


        /**
         * 配置缓存-接口下发的
         */
        //是否开启运动
        const val CACHE_NET_ISOPEN_SPORT = "sp_cache_net_isopen_sport"

        //是否开启公益
        const val CACHE_NET_ISOPEN_WELFARE = "sp_cache_net_isopen_welfare"


        /**
         * 登录页面
         */
        //登录中账户的保存
        const val LOGIN_ACCOUNT = "sp_login_account"
    }
}
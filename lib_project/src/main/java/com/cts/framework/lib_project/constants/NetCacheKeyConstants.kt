package com.cts.framework.lib_project.constants

/**
 * @Description: 网络请求缓存key
 * @Author: CTS
 * @Date: 2019/8/14 21:00
 */
class NetCacheKeyConstants {
    companion object {
        /**
         * 首页
         */
        //首页缓存
        const val HOME_DATA = "net_cachekey_home_data"


        /**
         * 公益
         */
        //公益首页图片接口（/dygawelfare-app/home/getBackgroundUrl）
        const val PUBW_HOME_IMG = "net_cachekey_pubw_home_img"


        /**
         * 卡包相关
         */
        //年卡列表缓存
        const val CARD_YEAR_PACKAGE_LIST = "net_cachekey_card_package_list"//一级列表
        const val CARD_ALL_LIST = "net_cachekey_card_all_list"//二级列表
        const val CARD_ALLCITY_CARD_LIST = "net_cachekey_card_allcity_card_list"//二级列表
        const val CARD_YEAR_LIST = "net_cachekey_card_year_list"
        const val CARD_YEAR_DETAIL = "net_cachekey_card_year_detail"
        const val CARD_YEAR_DETAIL_QRCODE = "net_cachekey_card_year_detail_qrcode"//卡列表（用于二维码页面）
        const val CARD_YEAR_DETAIL_QRCODE2 =
            "net_cachekey_card_year_detail_qrcode2"//卡详情列表（用于充值主卡时选择的主卡列表）
        const val CARD_YEAR_DEPUTY_DETAIL = "net_cachekey_cardy_deputy_detail"//预充卡详情

        //预充卡列表
        const val CARD_DEPUTY = "net_cachekey_card_deputy"

        //预充卡列表-充值赠送等的选择列表
        const val CARD_DEPUTY_SEL = "net_cachekey_card_deputy_sel"

        //亲情卡标签
        const val CARD_FAMILY_LABEL = "net_cachekey_card_family_label"
        const val CARD_FAMILY_LIST = "net_cachekey_card_family_list"
        const val CARD_FAMILY_TYPE_LIST = "net_cachekey_card_family_type_list"
        const val CARD_FAMILY_UNBIND_MES = "net_cachekey_card_family_unbind_mes"

        //适用景区
        const val CARD_APPLY_SCENIC = "net_cachekey_card_apply_scenic"

        //购买年卡相关
        const val CARD_BUY_PROVINCE = "net_cachekey_card_bug_province"
        const val CARD_BUY_CITY = "net_cachekey_card_bug_city"

        //赠送-主卡
        const val CARD_GIVE_MAIN = "net_cachekey_card_give_main"

        //分销-卡列表
        const val CARD_DIS_CARD = "net_cachekey_card_dis_card"
        const val CARD_DIS_RECORD = "net_cachekey_card_dis_record"

        //审核入园-可审核景区列表
        const val CARD_VER_SCENIC_LIST = "net_cachekey_card_ver_scenic_list"

        //景区管理
        const val CARD_SCENIC_MANAGE_LIST = "net_cachekey_card_scenic_manage_list"

        //入园管理
        const val CARD_SCENIC_ADMISSION_LIST = "net_cachekey_card_scenic_admission_list"

        //年卡帮助相关
        const val CARD_HELP_1 = "net_cachekey_card_help1"
        const val CARD_HELP_2 = "net_cachekey_card_help2"
        const val CARD_HELP_3 = "net_cachekey_card_help3"
        const val CARD_HELP_4 = "net_cachekey_card_help4"
        const val CARD_HELP_5 = "net_cachekey_card_help5"
        const val CARD_HELP_6 = "net_cachekey_card_help6"
        const val CARD_HELP_7 = "net_cachekey_card_help7"
        const val CARD_HELP_8 = "net_cachekey_card_help8"
        const val CARD_HELP_9 = "net_cachekey_card_help9"
        const val CARD_HELP_10 = "net_cachekey_card_help10"
        const val CARD_HELP_11 = "net_cachekey_card_help11"
        const val CARD_HELP_12 = "net_cachekey_card_help12"

        //日历-预约
        const val CARD_CALENDAR = "net_cachekey_card_calendar"


        /**
         * 信用通
         */
        const val CREDIT_PAGE_LIST = "net_cachekey_list"
        const val CREDIT_PAGE_LIST_RANKING = "net_cachekey_list_ranking"
        const val CREDIT_PAGE_LIST_BANNER = "net_cachekey_list_banner"
        const val CREDIT_PAGE_LIST_ANALYSIS = "net_cachekey_list_analysis"
        const val CREDIT_PAGE_LIST_ITEM = "net_cachekey_list_item"


        /**
         * 朋友圈图片换存
         */
        const val FRIEDND_CIRCLE_IMAGE_ALL = "friend_circle_cache_all"
        const val FRIEDND_CIRCLE_IMAGE_SINGLE = "friend_circle_cache_single"
        const val FRIEDND_CIRCLE_IMAGE_PERSONLY = "friend_circle_cache_personly"


        /**
         * 智慧运动相关
         */
        //智慧运动起始页图片缓存
        const val WISE_HOME_IMG = "net_cachekey_wise_home_img"

        //运动的个人中心成就icon
        const val WISE_PC_ICON = "net_cachekey_wise_pc_icon"


        /**
         * 充值中心
         */
        //充值首页金额缓存
        const val VOUCHER_HOME_PRICE = "voucher_home_price"


        /**
         * 个人中心
         */
        //我的二维码
        const val PERC_MY_QRCODE = "perc_my_qrcode"

        //刷脸设置
        const val FACR_SETTING = "perc_face_setting"


        /**
         * 消息中心
         */
        const val MES_LIST = "mes_list"

        /**
         * 医疗模块
         */
        //医疗首页
        const val MED_HOME = "med_home"

        //科普列表
        const val MED_KP_LIST = "med_kp_list"

        //远程诊断
        const val MED_LD_HOME = "med_ld_home"

        //远程诊断-首页下面的资讯
        const val MED_LD_HOME_ARTICLE = "med_ld_home_article"

        //查找医生-首页热门科室列表
        const val MED_DOC_HOTDEPA = "med_doc_hotdepa"
        const val MED_DOC_ALLDEPA = "med_doc_alldepa"
        const val MED_DOC_CITY = "med_doc_city"
        const val MED_DOC_TITLE = "med_doc_title"
        const val MED_DOC_LIST = "med_doc_list"
        const val MED_DOC_LIST2 = "med_doc_list2"

        //医生资料
        const val MED_DOC_INFO = "med_doc_info"

        //我的收藏
        const val MED_COLLECT = "med_collect"


    }
}
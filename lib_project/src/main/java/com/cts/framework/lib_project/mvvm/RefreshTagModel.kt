package com.cts.framework.lib_project.mvvm

/**
 * @Description: 列表区分状态（现在只有刷新和加载两种状态）
 * @Author: CTS
 * @Date:  2018/6/27
 */
class RefreshTagModel<T>(isRefreshTag: Int, t: T) {
    companion object {
        const val IS_REFRESH = 0
        const val IS_LOAD_MORE = 1
    }

    var isRefreshTag: Int = isRefreshTag//刷新状态标识码，0：刷新，  1：加载
    var value0 = t

    /**
     * 返回否是刷新
     */
    fun isRefresh(): Boolean {
        if (isRefreshTag == IS_REFRESH) {
            return true
        }
        return false
    }

}
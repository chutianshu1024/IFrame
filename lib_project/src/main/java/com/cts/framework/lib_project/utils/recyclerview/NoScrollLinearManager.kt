package com.cts.framework.lib_project.utils.recyclerview

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager

/**
 * @Description: 不可滑动 LinearManager
 * @Author: CTS
 * @Date: 2019/7/16 15:44
 */
class NoScrollLinearManager(context: Context) : LinearLayoutManager(context) {
    override fun canScrollHorizontally(): Boolean {
        return false
    }

    override fun canScrollVertically(): Boolean {
        return false
    }
}
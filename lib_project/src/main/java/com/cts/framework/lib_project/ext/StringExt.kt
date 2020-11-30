package com.cts.framework.lib_project.ext

/**
 * @Description: String扩展函数
 * @Author: CTS
 * @Date: 2019/6/22 11:09
 */

/**
 * 替换为[str]
 */
inline fun String.replaceWith(str: String, start: Int, end: Int): String {
    var s = ""

    return if (length > 0) {
        for (i in this.substring(start, end).indices) {
            s += str
        }

        substring(0, start) + s + subSequence(end, this.length)
    } else {
        ""
    }
}

/**
 * [price] 价格
 * [position] 小数点位数
 */
inline fun String.formatPrice(position: Int): String {
    return when (position) {
        0 -> {
            this.toInt().toString()
        }
        else -> {
            String.format("%.${position}f", this.toDouble())
        }
    }

}
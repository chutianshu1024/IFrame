package com.cts.framework.lib_project.ext

import java.text.DecimalFormat

/**
 * @Description: Double扩展函数
 * @Author: CTS
 * @Date: 2019/10/24 19:59
 */
inline fun Double.formatPrice(): String {
    return DecimalFormat("0.00").format(this)
}

/**
 * [position] 小数点位数
 */
inline fun Double.formatPrice(position: Int): String {
    return String.format("%.${position}f", this)
}

/**
 * 带 ¥ 符号的
 * [position] 小数点位数
 */
inline fun Double.formatPriceWithSymbol(position: Int): String {
    return "¥" + String.format("%.${position}f", this)
}
package com.cts.framework.lib_project.utils

import java.math.BigDecimal

/**
 * @Description: 高精度计算工具类
 * @Author: CTS
 * @Date: 2019/8/3 10:55
 */
class BigDecimalUtils private constructor() {
    companion object {
        val instance: BigDecimalUtils by lazy { BigDecimalUtils() }

        // 需要精确至小数点后几位
        const val DECIMAL_POINT_NUMBER: Int = 2
    }

    // 加法运算
    fun add(d1: String, d2: String): BigDecimal = BigDecimal(d1).add(BigDecimal(d2)).setScale(
        DECIMAL_POINT_NUMBER,
        BigDecimal.ROUND_DOWN
    )

    // 减法运算
    fun sub(d1: String, d2: String): BigDecimal = BigDecimal(d1).subtract(BigDecimal(d2)).setScale(
        DECIMAL_POINT_NUMBER,
        BigDecimal.ROUND_DOWN
    )

    // 乘法运算
    fun mul(d1: String, d2: String, decimalPoint: Int): BigDecimal =
        BigDecimal(d1).multiply(BigDecimal(d2)).setScale(
            decimalPoint,
            BigDecimal.ROUND_DOWN
        )

    // 除法运算
    fun div(d1: String, d2: String): BigDecimal = BigDecimal(d1).divide(BigDecimal(d2)).setScale(
        DECIMAL_POINT_NUMBER,
        BigDecimal.ROUND_DOWN
    )
}
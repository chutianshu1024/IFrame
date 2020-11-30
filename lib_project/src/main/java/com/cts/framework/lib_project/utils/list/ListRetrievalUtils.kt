package com.cts.framework.lib_project.utils.list

import android.util.Log

/**
 * @Description: list检索（尽量别用，效率较差）
 * @Author: CTS
 * @Date: 2019/8/8 17:19
 */
class ListRetrievalUtils {
    companion object {
        val instance: ListRetrievalUtils by lazy { ListRetrievalUtils() }
    }

    /**
     * 检索
     * [str]目标字段
     * [list]需要检索的list
     */
    fun retrieval(str: String, list: List<ListRetrievalStr>): ArrayList<ListRetrievalStr> {
        var listTemp: ArrayList<ListRetrievalStr> = arrayListOf()
        if (str.isNotBlank() && list.isNotEmpty()) {
            list.forEach {
                for (item in it.getRetrievalStr()){
                    if (item.contains(str)) {
                        listTemp.add(it)
                    }
                }

            }
        } else {
            Log.d("ListRetrievalUtils", "检索字段和列表不能为空")
        }

        return listTemp
    }

    interface ListRetrievalStr {
        fun getRetrievalStr(): Array<String>
    }
}
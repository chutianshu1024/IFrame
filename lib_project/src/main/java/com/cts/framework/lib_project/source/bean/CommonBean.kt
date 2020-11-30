package com.cts.framework.lib_project.source.bean

import java.io.Serializable

/**
 * @Description: 通用bean
 * @Author: CTS
 * @Date: 2019/7/18 21:13
 */
class PayTypeModel(
    var id: String = "",
    var imgUrl: String = "",
    var name: String = ""
)

//上传文件入参
data class UploadPathModel(
    var fileUrl: String
) : Serializable

//上传文件返回
data class UploadPathResultModel(
    var fileUrl: String
)

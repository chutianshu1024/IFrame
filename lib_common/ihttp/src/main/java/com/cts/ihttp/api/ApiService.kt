package com.cts.ihttp.api

import com.cts.ihttp.base.BaseResponse
import com.cts.ihttp.bean.BuvIdBean
import com.cts.ihttp.bean.GuessDBean
import com.cts.ihttp.bean.UserTipsData
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Url

/**
 *
 *　　┏┓　　　┏┓+ +
 *　┏┛┻━━━┛┻┓ + +
 *　┃　　　　　　　┃ 　
 *　┃　　　━　　　┃ ++ + + +
 * ████━████ ┃+
 *　┃　　　　　　　┃ +
 *　┃　　　┻　　　┃
 *　┃　　　　　　　┃ + +
 *　┗━┓　　　┏━┛
 *　　　┃　　　┃　　　　　　　　　　　
 *　　　┃　　　┃ + + + +
 *　　　┃　　　┃
 *　　　┃　　　┃ +  神兽保佑
 *　　　┃　　　┃    代码无bug　　
 *　　　┃　　　┃　　+　　　　　　　　　
 *　　　┃　 　　┗━━━┓ + +
 *　　　┃ 　　　　　　　┣┓
 *　　　┃ 　　　　　　　┏┛
 *　　　┗┓┓┏━┳┓┏┛ + + + +
 *　　　　┃┫┫　┃┫┫
 *　　　　┗┻┛　┗┻┛+ + + +
 *
 * @Description: 所有apiService
 * @Author: CTS
 * @Date: 2020/9/22 15:52
 * @Note: 目录根据功能和业务分块
 *        目录: 1.通用api
 *             2.登录注册相关
 *             3.个人资料相关
 *             4.小游戏相关
 */
interface ApiService {
    /**
     * ━━━━━━━━━━━━━━━━━━━
     * 通用api  （临时提示：一般包含通用上传，提交等全域通用接口）
     * ━━━━━━━━━━━━━━━━━━━
     */
    //获取buvId
    @FormUrlEncoded
    @POST()
    suspend fun getBuvId(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<BuvIdBean>

    /**
     * 适配java的方案
     * (java直接返回result，接收到result之后，再进行二次解析，多了一次Gson解析，会导致5ms左右的额外耗时)
     */
    @FormUrlEncoded
    @POST()
    suspend fun post(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<Any>


    /**
     * ━━━━━━━━━━━━━━━━━━━
     * 登录注册相关
     * ━━━━━━━━━━━━━━━━━━━
     */
    //临时测试模板
    @FormUrlEncoded
    @POST("/invite/regByInvitePhone")
    suspend fun testPost2(@FieldMap maps: Map<String, String>): BaseResponse<Any>


    /**
     * ━━━━━━━━━━━━━━━━━━━
     * 个人资料相关
     * ━━━━━━━━━━━━━━━━━━━
     */
    //获取个人资料
    @FormUrlEncoded
    @POST()
    suspend fun getUserInfo(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<UserTipsData>


    /**
     * ━━━━━━━━━━━━━━━━━━━
     * 小游戏相关
     * ━━━━━━━━━━━━━━━━━━━
     */
    //你画我猜-发起邀请(包含音视频)
    @FormUrlEncoded
    @POST()
    suspend fun launchGuessDraw(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<GuessDBean>

    //你画我猜-发起邀请（不包含音视频）
    @FormUrlEncoded
    @POST()
    suspend fun launchGuessDrawOnly(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<GuessDBean>

    //你画我猜-接受邀请
    @FormUrlEncoded
    @POST()
    suspend fun acceptGuessDraw(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<GuessDBean>

    //你画我猜-拒绝邀请
    @FormUrlEncoded
    @POST()
    suspend fun refuseGuessDraw(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<String>

    //你画我猜-选择题目
    @FormUrlEncoded
    @POST()
    suspend fun selectTopic(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<String>

    //你画我猜-选择题目
    @FormUrlEncoded
    @POST()
    suspend fun sendDrawData(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<String>

    //你画我猜-发送回合结束通知
    @FormUrlEncoded
    @POST()
    suspend fun sendDrawRoundEnd(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<String>

    //你画我猜-发送回合结束通知
    @FormUrlEncoded
    @POST()
    suspend fun sendAnswer(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<String>

    //你画我猜-退出游戏
    @FormUrlEncoded
    @POST()
    suspend fun stopGuessd(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<String>

    //你画我猜-删除最后一画
    @FormUrlEncoded
    @POST()
    suspend fun removeLast(@Url url: String, @FieldMap maps: Map<String, String>): BaseResponse<String>


//    @POST
//    fun postBody(@Url url: String?, @Body `object`: Any?): Observable<ResponseBody?>?
//
//    @POST
//    @Headers("Content-Type: application/json", "Accept: application/json")
//    fun postJson(@Url url: String?, @Body jsonBody: RequestBody?): Observable<ResponseBody?>?
//
////    @POST
////    fun postBody(@Url url: String?, @Body body: RequestBody?): BaseResponse<T>
//
//    @GET
//    operator fun get(@Url url: String?, @QueryMap maps: Map<String?, String?>?): Observable<ResponseBody?>?
//
//    @DELETE
//    fun delete(@Url url: String?, @QueryMap maps: Map<String?, String?>?): Observable<ResponseBody?>?
//
//    //@DELETE()//delete body请求比较特殊 需要自定义
//    @HTTP(method = "DELETE", hasBody = true)
//    fun deleteBody(@Url url: String?, @Body `object`: Any?): Observable<ResponseBody?>?
//
//    //@DELETE()//delete body请求比较特殊 需要自定义
//    @HTTP(method = "DELETE", hasBody = true)
//    fun deleteBody(@Url url: String?, @Body body: RequestBody?): Observable<ResponseBody?>?
//
//    //@DELETE()//delete body请求比较特殊 需要自定义
//    @Headers("Content-Type: application/json", "Accept: application/json")
//    @HTTP(method = "DELETE", hasBody = true)
//    fun deleteJson(@Url url: String?, @Body jsonBody: RequestBody?): Observable<ResponseBody?>?
//
//    @PUT
//    fun put(@Url url: String?, @QueryMap maps: Map<String?, String?>?): Observable<ResponseBody?>?
//
//    @PUT
//    fun putBody(@Url url: String?, @Body `object`: Any?): Observable<ResponseBody?>?
//
//    @PUT
//    fun putBody(@Url url: String?, @Body body: RequestBody?): Observable<ResponseBody?>?
//
//    @PUT
//    @Headers("Content-Type: application/json", "Accept: application/json")
//    fun putJson(@Url url: String?, @Body jsonBody: RequestBody?): Observable<ResponseBody?>?
//
//    @Multipart
//    @POST
//    fun uploadFlie(@Url fileUrl: String?, @Part("description") description: RequestBody?, @Part("files") file: MultipartBody.Part?): Observable<ResponseBody?>?
//
//    @Multipart
//    @POST
//    fun uploadFiles(@Url url: String?, @PartMap maps: Map<String?, RequestBody?>?): Observable<ResponseBody?>?
//
//    @Multipart
//    @POST
//    fun uploadFiles(@Url url: String?, @Part parts: List<MultipartBody.Part?>?): Observable<ResponseBody?>?
//
//    @Streaming
//    @GET
//    fun downloadFile(@Url fileUrl: String?): Observable<ResponseBody?>?

//    fun findMethod(url: String, params: Map<String, String>): BaseResponse<GuessDBean> {
//        var method = javaClass.getMethod("")
//        var urlAnnotation = method.getAnnotation(POST::class.java)
//        if (urlAnnotation != null) {
//            val urlAnnotationStr = urlAnnotation.value
//            if (urlAnnotationStr.isNotEmpty()) {
//                return method.invoke(this, url, params)
//            }
//        }
//        return null
//    }

}
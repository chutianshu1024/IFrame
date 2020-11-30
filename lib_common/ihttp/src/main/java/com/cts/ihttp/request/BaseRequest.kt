package com.cts.ihttp.request

import android.content.Context
import android.text.TextUtils
import com.cts.ihttp.IHttp
import com.cts.ihttp.IHttp.Companion.instance
import com.cts.ihttp.api.ApiService
import com.cts.ihttp.base.BaseResponse
import com.cts.ihttp.cache.ICache
import com.cts.ihttp.cache.converter.IDiskConverter
import com.cts.ihttp.cache.model.CacheMode
import com.cts.ihttp.cache.model.CacheResult
import com.cts.ihttp.exception.ApiException
import com.cts.ihttp.https.HttpsUtils
import com.cts.ihttp.https.HttpsUtils.SSLParams
import com.cts.ihttp.interceptor.*
import com.cts.ihttp.model.HttpHeaders
import com.cts.ihttp.result.ApiResult
import com.cts.ihttp.utils.HttpLog
import com.cts.ihttp.utils.Utils
import kotlinx.coroutines.*
import okhttp3.*
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import java.io.File
import java.io.InputStream
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.net.Proxy
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier

/**　　┏┓　　　┏┓+ +
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
 * @Description: Request（请求体）
 * @Author: CTS
 * @Date: 2020/9/24 16:37
 */
abstract class BaseRequest<R : BaseRequest<R>>() {
    private var cache: Cache? = null
    private var cacheMode: CacheMode = CacheMode.NO_CACHE                         //默认无缓存
    private var cacheTime: Long = -1                                              //缓存时间
    private var cacheKey: String? = null                                          //缓存Key
    private var diskConverter: IDiskConverter? = null                             //设置Rxcache磁盘转换器
    private var baseUrl: String?                                                  //BaseUrl

    private var readTimeOut: Long = 0                                             //读超时
    private var writeTimeOut: Long = 0                                            //写超时
    private var connectTimeout: Long = 0                                          //链接超时

    private var cookies: MutableList<Cookie> = ArrayList()                        //用户手动添加的Cookie
    private val networkInterceptors: MutableList<Interceptor> = ArrayList()
    private var headers = HttpHeaders()                                           //添加的header
    private var httpParams: MutableMap<String, String> = mutableMapOf()           //添加的param

    private lateinit var retrofit: Retrofit
    private lateinit var iCache: ICache                                           //rxcache缓存
    private lateinit var apiManager: ApiService                                   //通用的的api接口
    private lateinit var okHttpClient: OkHttpClient

    private var context: Context? = instance.getContext()
    private var sign = true                                                       //是否需要签名
    private var timeStamp = true                                                  //是否需要追加时间戳
    private var accessToken = true                                                //是否需要追加token
    private var httpUrl: HttpUrl? = null
    private var proxy: Proxy? = null
    private var sslParams: SSLParams? = null
    private var hostnameVerifier: HostnameVerifier? = null
    private var converterFactories: MutableList<Converter.Factory> = ArrayList()
    private var adapterFactories: MutableList<CallAdapter.Factory> = ArrayList()
    private val interceptors: MutableList<Interceptor> = ArrayList()

    //标识网络请求数据是否已回传，如果网络请求快于硬盘读取则不再加载硬盘缓存
    private var tagIsRemoteFinished = false

    fun getParams(): MutableMap<String, String> {
        return httpParams
    }

    fun readTimeOut(readTimeOut: Long): R {
        this.readTimeOut = readTimeOut
        return this as R
    }

    fun writeTimeOut(writeTimeOut: Long): R {
        this.writeTimeOut = writeTimeOut
        return this as R
    }

    fun connectTimeout(connectTimeout: Long): R {
        this.connectTimeout = connectTimeout
        return this as R
    }

    fun okCache(cache: Cache?): R {
        this.cache = cache
        return this as R
    }

    fun cacheMode(cacheMode: CacheMode): R {
        this.cacheMode = cacheMode
        return this as R
    }

    fun cacheKey(cacheKey: String?): R {
        this.cacheKey = cacheKey
        return this as R
    }

    fun cacheTime(cacheTime: Long): R {
        var cacheTime = cacheTime
        if (cacheTime <= -1) cacheTime = IHttp.DEFAULT_CACHE_NEVER_EXPIRE.toLong()
        this.cacheTime = cacheTime
        return this as R
    }

    fun baseUrl(baseUrl: String?): R {
        this.baseUrl = baseUrl
        if (!TextUtils.isEmpty(this.baseUrl)) httpUrl = HttpUrl.parse(baseUrl)
        return this as R
    }

    //    public BaseRequest retryCount(int retryCount) {
    //        if (retryCount < 0) throw new IllegalArgumentException("retryCount must > 0");
    //        this.retryCount = retryCount;
    //        return  this;
    //    }
    //
    //    public BaseRequest retryDelay(int retryDelay) {
    //        if (retryDelay < 0) throw new IllegalArgumentException("retryDelay must > 0");
    //        this.retryDelay = retryDelay;
    //        return  this;
    //    }
    //
    //    public BaseRequest retryIncreaseDelay(int retryIncreaseDelay) {
    //        if (retryIncreaseDelay < 0)
    //            throw new IllegalArgumentException("retryIncreaseDelay must > 0");
    //        this.retryIncreaseDelay = retryIncreaseDelay;
    //        return  this;
    //    }
    fun addInterceptor(interceptor: Interceptor): R {
        interceptors.add(Utils.checkNotNull(interceptor, "interceptor == null"))
        return this as R
    }

    fun addNetworkInterceptor(interceptor: Interceptor): R {
        networkInterceptors.add(Utils.checkNotNull(interceptor, "interceptor == null"))
        return this as R
    }

    fun addCookie(name: String?, value: String?): R {
        val builder = Cookie.Builder()
        val cookie = builder.name(name).value(value).domain(httpUrl!!.host()).build()
        cookies.add(cookie)
        return this as R
    }

    fun addCookie(cookie: Cookie): R {
        cookies.add(cookie)
        return this as R
    }

    fun addCookies(cookies: List<Cookie>): R {
        this.cookies.addAll(cookies)
        return this as R
    }

    /**
     * 设置Converter.Factory,默认GsonConverterFactory.create()
     */
    fun addConverterFactory(factory: Converter.Factory): R {
        converterFactories.add(factory)
        return this as R
    }

    /**
     * 设置CallAdapter.Factory,默认RxJavaCallAdapterFactory.create()
     */
    fun addCallAdapterFactory(factory: CallAdapter.Factory): R {
        adapterFactories.add(factory)
        return this as R
    }

    /**
     * 设置代理
     */
    fun okproxy(proxy: Proxy?): R {
        this.proxy = proxy
        return this as R
    }

    /**
     * 设置缓存的转换器
     */
    fun cacheDiskConverter(converter: IDiskConverter): R {
        diskConverter = Utils.checkNotNull(converter, "converter == null")
        return this as R
    }

    /**
     * https的全局访问规则
     */
    fun hostnameVerifier(hostnameVerifier: HostnameVerifier?): R {
        this.hostnameVerifier = hostnameVerifier
        return this as R
    }

    /**
     * https的全局自签名证书
     */
    fun certificates(vararg certificates: InputStream?): R {
        sslParams = HttpsUtils.getSslSocketFactory(null, null, certificates)
        return this as R
    }

    /**
     * https双向认证证书
     */
    fun certificates(bksFile: InputStream?, password: String?, vararg certificates: InputStream?): R {
        sslParams = HttpsUtils.getSslSocketFactory(bksFile, password, certificates)
        return this as R
    }

    /**
     * 添加头信息
     */
    fun headers(headers: HttpHeaders?): R {
        this.headers.put(headers)
        return this as R
    }

    /**
     * 添加头信息
     */
    fun headers(key: String?, value: String?): R {
        headers.put(key, value)
        return this as R
    }

    /**
     * 移除头信息
     */
    fun removeHeader(key: String?): R {
        headers.remove(key)
        return this as R
    }

    /**
     * 移除所有头信息
     */
    fun removeAllHeaders(): R {
        headers.clear()
        return this as R
    }

    /**
     * 设置参数
     */
    fun params(key: String, value: String): R {
        httpParams.put(key, value)
        return this as R
    }

    fun params(keyValues: Map<String, String>): R {
        httpParams.putAll(keyValues)
        return this as R
    }

    //添加文件list参数（用于文件上传）
    fun paramsFiles(key: String, files: List<File>) {

    }

    fun removeParam(key: String?): R {
        httpParams.remove(key)
        return this as R
    }

    fun removeAllParams(): R {
        httpParams.clear()
        return this as R
    }

    fun sign(sign: Boolean): R {
        this.sign = sign
        return this as R
    }

    fun timeStamp(timeStamp: Boolean): R {
        this.timeStamp = timeStamp
        return this as R
    }

    fun accessToken(accessToken: Boolean): R {
        this.accessToken = accessToken
        return this as R
    }
    //    /**
    //     * 移除缓存（key）
    //     */
    //    public void removeCache(String key) {
    //        IHttp.Companion.getInstance().getRxCache().remove(key).compose(RxUtil.<Boolean>io_main())
    //                .subscribe(new Consumer<Boolean>() {
    //                    @Override
    //                    public void accept(@NonNull Boolean aBoolean) throws Exception {
    //                        HttpLog.i("removeCache success!!!");
    //                    }
    //                }, new Consumer<Throwable>() {
    //                    @Override
    //                    public void accept(@NonNull Throwable throwable) throws Exception {
    //                        HttpLog.i("removeCache err!!!" + throwable);
    //                    }
    //                });
    //    }
    /**
     * 根据当前的请求参数，生成对应的OkClient
     */
    private fun generateOkClient(): OkHttpClient.Builder {
        return if (readTimeOut <= 0 && writeTimeOut <= 0 && connectTimeout <= 0 && sslParams == null && cookies.size == 0 && hostnameVerifier == null && proxy == null && headers.isEmpty) {
            val builder = instance.getOkHttpClientBuilder()
            for (interceptor in builder!!.interceptors()) {
                if (interceptor is BaseDynamicInterceptor<*>) {
                    interceptor.sign(sign).timeStamp(timeStamp).accessToken(accessToken)
                }
            }
            builder
        } else {
            val newClientBuilder = instance.getOkHttpClient()!!.newBuilder()
            if (readTimeOut > 0) newClientBuilder.readTimeout(readTimeOut, TimeUnit.MILLISECONDS)
            if (writeTimeOut > 0) newClientBuilder.writeTimeout(writeTimeOut, TimeUnit.MILLISECONDS)
            if (connectTimeout > 0) newClientBuilder.connectTimeout(connectTimeout, TimeUnit.MILLISECONDS)
            if (hostnameVerifier != null) newClientBuilder.hostnameVerifier(hostnameVerifier)
            if (sslParams != null) newClientBuilder.sslSocketFactory(sslParams!!.sSLSocketFactory, sslParams!!.trustManager)
            if (proxy != null) newClientBuilder.proxy(proxy)
            if (cookies.size > 0) instance.getCookieJar()!!.addCookies(cookies)

            //添加头  头添加放在最前面方便其他拦截器可能会用到
            newClientBuilder.addInterceptor(HeadersInterceptor(headers))
            for (interceptor in interceptors) {
                if (interceptor is BaseDynamicInterceptor<*>) {
                    interceptor.sign(sign).timeStamp(timeStamp).accessToken(accessToken)
                }
                newClientBuilder.addInterceptor(interceptor)
            }
            for (interceptor in newClientBuilder.interceptors()) {
                if (interceptor is BaseDynamicInterceptor<*>) {
                    interceptor.sign(sign).timeStamp(timeStamp).accessToken(accessToken)
                }
            }
            if (networkInterceptors.size > 0) {
                for (interceptor in networkInterceptors) {
                    newClientBuilder.addNetworkInterceptor(interceptor)
                }
            }
            newClientBuilder
        }.apply {
            if (cacheMode == CacheMode.DEFAULT) { //okhttp缓存
                cache(cache)
            }
        }
    }

    /**
     * 根据当前的请求参数，生成对应的Retrofit
     */
    private fun generateRetrofit(): Retrofit.Builder {
        return if (converterFactories.isEmpty() && adapterFactories.isEmpty()) {
            val builder = instance.getRetrofitBuilder()
            if (!TextUtils.isEmpty(baseUrl)) {
                builder!!.baseUrl(baseUrl)
            }
            builder
        } else {
            val retrofitBuilder = Retrofit.Builder()
            if (!TextUtils.isEmpty(baseUrl)) retrofitBuilder.baseUrl(baseUrl)
            if (!converterFactories.isEmpty()) {
                for (converterFactory in converterFactories) {
                    retrofitBuilder.addConverterFactory(converterFactory)
                }
            } else {
                //获取全局的对象重新设置
                val newBuilder = instance.getRetrofitBuilder()
                if (!TextUtils.isEmpty(baseUrl)) {
                    newBuilder!!.baseUrl(baseUrl)
                }
                val listConverterFactory = newBuilder!!.build().converterFactories()
                for (factory in listConverterFactory) {
                    retrofitBuilder.addConverterFactory(factory)
                }
            }
            if (!adapterFactories.isEmpty()) {
                for (adapterFactory in adapterFactories) {
                    retrofitBuilder.addCallAdapterFactory(adapterFactory)
                }
            } else {
                //获取全局的对象重新设置
                val newBuilder = instance.getRetrofitBuilder()
                val listAdapterFactory = newBuilder!!.baseUrl(baseUrl).build().callAdapterFactories()
                for (factory in listAdapterFactory) {
                    retrofitBuilder.addCallAdapterFactory(factory)
                }
            }
            retrofitBuilder
        }
    }

    /**
     * 根据当前的请求参数，生成对应的RxCache和Cache
     */
    private fun generateRxCache(): ICache.Builder {
        val rxCacheBuilder = instance.getRxCacheBuilder()
        when (cacheMode) {
            CacheMode.NO_CACHE -> {
                val NOCACHEINTERCEPTOR = NoCacheInterceptor()
                interceptors.add(NOCACHEINTERCEPTOR)
                networkInterceptors.add(NOCACHEINTERCEPTOR)
            }
            CacheMode.DEFAULT -> {
                if (cache == null) {
                    var cacheDirectory = instance.getCacheDirectory()
                    if (cacheDirectory == null) {
                        cacheDirectory = File(instance.getContext()!!.cacheDir, "okhttp-cache")
                    } else {
                        if (cacheDirectory.isDirectory && !cacheDirectory.exists()) {
                            cacheDirectory.mkdirs()
                        }
                    }
                    cache = Cache(cacheDirectory, Math.max(5 * 1024 * 1024.toLong(), instance.getCacheMaxSize()))
                }
                val cacheControlValue = String.format("max-age=%d", Math.max(-1, cacheTime))
                val REWRITE_CACHE_CONTROL_INTERCEPTOR = CacheInterceptor(instance.getContext(), cacheControlValue)
                val REWRITE_CACHE_CONTROL_INTERCEPTOR_OFFLINE = CacheInterceptorOffline(instance.getContext(), cacheControlValue)
                networkInterceptors.add(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                networkInterceptors.add(REWRITE_CACHE_CONTROL_INTERCEPTOR_OFFLINE)
                interceptors.add(REWRITE_CACHE_CONTROL_INTERCEPTOR_OFFLINE)
            }
            CacheMode.ONLYCACHE, CacheMode.CACHEANDREMOTE, CacheMode.CACHEANDREMOTEDISTINCT -> {
                interceptors.add(NoCacheInterceptor())
                return if (diskConverter == null) {
                    rxCacheBuilder!!.cachekey(Utils.checkNotNull(cacheKey, "cacheKey == null"))
                            .cacheTime(cacheTime)
                    rxCacheBuilder
                } else {
                    val cacheBuilder = instance.getRxCache().newBuilder()
                    cacheBuilder.diskConverter(diskConverter)
                            .cachekey(Utils.checkNotNull(cacheKey, "cacheKey == null"))
                            .cacheTime(cacheTime)
                    cacheBuilder
                }
            }
        }
        return rxCacheBuilder
    }

    open fun build(): R {
        val okHttpClientBuilder = generateOkClient()
        okHttpClient = okHttpClientBuilder.build()
        if (cacheMode == CacheMode.DEFAULT) { //okhttp缓存
            okHttpClientBuilder.cache(cache)
        }
        retrofit = generateRetrofit().client(okHttpClient).build()
        iCache = generateRxCache().build()
        apiManager = retrofit.create(ApiService::class.java)
        return this as R
    }

    private fun getApiService(): ApiService {
        if (apiManager == null) {
            HttpLog.e("必须先初始化ApiService")
        }
        return apiManager
    }

    //通用的请求，一般post、get啥的都用这个
    suspend fun <T : Any> execute(
            call: suspend (apiService: ApiService, params: MutableMap<String, String>) -> BaseResponse<T>,
            successBlock: (CoroutineScope.(ApiResult: ApiResult.Success<T>) -> Unit)? = null,
            errorBlock: (CoroutineScope.(error: ApiResult.Error) -> Unit)? = null) {
        coroutineScope {
            try {
                async(Dispatchers.IO) {
                    val response = safeApiCall(call)
                    if (response.isSuccess()) {
                        tagIsRemoteFinished = true

                        launch(Dispatchers.Main) {
                            successBlock?.let {
                                it(ApiResult.Success(response.data))
                            }
                        }
                        cacheKey?.let {
                            iCache.save(it, response.data)
                        }

                    } else {
                        tagIsRemoteFinished = true
                        launch(Dispatchers.Main) {
                            errorBlock?.let {
                                it(ApiResult.Error(response.result, response.msg
                                        ?: "", response.data.toString()))
                            }
                        }

                    }
                }

            } catch (e: Exception) {
                HttpLog.e(e.message)
                val ex = ApiException.handleException(e)
                errorBlock?.let { it(ApiResult.Error(ex.code, ex.message ?: "", "")) }
            }
        }
    }

    //带有返回值的通用的请求，比上面那个多个返回值
    suspend fun <T : Any> executeWithResult(
            call: suspend (apiService: ApiService, params: MutableMap<String, String>) -> BaseResponse<T>,
            successBlock: (suspend CoroutineScope.(ApiResult: ApiResult.Success<T>) -> Unit)? = null,
            errorBlock: (suspend CoroutineScope.(error: ApiResult.Error) -> Unit)? = null): ApiResult<T> {
        return coroutineScope {
            try {
                async(Dispatchers.IO) {
                    val response = safeApiCall(call)
                    if (response.isSuccess()) {
                        tagIsRemoteFinished = true

                        launch(Dispatchers.Main) {
                            successBlock?.let {
                                it(ApiResult.Success(response.data))
                            }
                        }

                        cacheKey?.let {
                            iCache.save(it, response.data)
                        }

                        ApiResult.Success(response.data)

                    } else {
                        tagIsRemoteFinished = true

                        launch(Dispatchers.Main) {
                            errorBlock?.let {
                                it(ApiResult.Error(response.result, response.msg
                                        ?: "", response.data.toString()))
                            }
                        }

                        ApiResult.Error(response.result, response.msg
                                ?: "", response.data.toString())
                    }
                }.await()

            } catch (e: Exception) {
                HttpLog.e(e.message)
                val ex = ApiException.handleException(e)
                errorBlock?.let { it(ApiResult.Error(ex.code, ex.message ?: "", "")) }
                ApiResult.Error(ex.code, ex.message ?: "", "")
            }
        }
    }

    /**
     * 根据[cacheMode]类型 进行缓存处理
     */
    private suspend fun <T> handleCache(cacheMode: CacheMode, successBlock: (suspend CoroutineScope.(success: ApiResult.Success<T>) -> Unit)? = null) {
        when (cacheMode) {
            CacheMode.CACHEANDREMOTE -> {
                getCacheByKey(successBlock)
            }
        }
    }

    private suspend fun <T> getCacheByKey(successBlock: (suspend CoroutineScope.(success: ApiResult.Success<T>) -> Unit)? = null) {
        //如果存在缓存，先回调缓存
        try {
            if (!cacheKey.isNullOrBlank() && iCache.containsKey(cacheKey)) {
                withContext(Dispatchers.IO) {
                    val type: Type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
                    val cacheResult: CacheResult<T> = iCache.load(type, cacheKey
                            ?: "", cacheTime)
                    if (!tagIsRemoteFinished) {
                        ApiResult.Success(cacheResult.data)
                        successBlock?.let {
                            it(ApiResult.Success(cacheResult.data))
                        }
                    }
                }
            }
        } catch (e: Exception) {
            HttpLog.e("读取缓存异常：${e.message}")
        }
    }

    suspend fun <T> executeCache(successBlock: (suspend CoroutineScope.(success: ApiResult.Success<T>) -> Unit)? = null): R {
        if (!tagIsRemoteFinished) {//如果网络请求已回调，则不取缓存，不过现在手机读取本地缓存一般在15ms上下，肯定比接口快，
            handleCache(cacheMode, successBlock)
        }
        return this as R
    }

    //之后在这里捕捉通用异常
    private suspend fun <T> safeApiCall(call: suspend (apiService: ApiService, params: MutableMap<String, String>) -> BaseResponse<T>): BaseResponse<T> {
        return try {
            call(getApiService(), getParams())
        } catch (e: Exception) {
            // An exception was thrown when calling the API so we're converting this to an IOException
            HttpLog.e(e.message)
            val ex = ApiException.handleException(e)
            BaseResponse(ex.code, ex.message ?: "", null)
        }
    }

    init {
        val config = instance
        baseUrl = config.getBaseUrl()
        if (!TextUtils.isEmpty(baseUrl)) {
            httpUrl = HttpUrl.parse(baseUrl)
        }

        //        if (baseUrl == null) {
        //            baseUrl = httpUrl!!.url().protocol + "://" + httpUrl!!.url().host + "/"
        //        }
        cacheMode = config.getCacheMode() //添加缓存模式
        cacheTime = config.getCacheTime() //缓存时间
        //Okhttp  cache
        cache = config.getHttpCache()
        //默认添加 Accept-Language
        val acceptLanguage = HttpHeaders.getAcceptLanguage()
        if (!TextUtils.isEmpty(acceptLanguage)) headers(HttpHeaders.HEAD_KEY_ACCEPT_LANGUAGE, acceptLanguage)
        //默认添加 User-Agent
        val userAgent = HttpHeaders.getUserAgent()
        if (!TextUtils.isEmpty(userAgent)) headers(HttpHeaders.HEAD_KEY_USER_AGENT, userAgent)
        //添加公共请求参数
        config.getCommonParams()?.let { httpParams.putAll(it) }
        config.getCommonHeaders()?.let { headers.put(it) }
    }
}

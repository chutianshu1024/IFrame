package com.cts.framework.lib_project.view.webview

import android.content.Context
import android.os.Build
import android.os.Build.VERSION_CODES
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import com.tencent.smtt.export.external.interfaces.WebResourceRequest
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebSettings
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient

/**
 * @Description: 项目用到的webView ，现在使用的腾讯x5内核
 * @Author: CTS
 * @Date: 2020/11/27 14:45
 */
class IWebView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : WebView(context, attrs, defStyleAttr) {
    init {
        initWebViewSettings()
        //设置可以点击
        this.isClickable = true
    }

    /**
     * 做一些公共的初始化操作
     */
    private fun initWebViewSettings() {
        val ws = this.settings
        // 网页内容的宽度是否可大于WebView控件的宽度
        ws.loadWithOverviewMode = false
        // 保存表单数据
        ws.saveFormData = true
        // 是否应该支持使用其屏幕缩放控件和手势缩放
        ws.setSupportZoom(true)
        // 设置内置的缩放控件。若为false，则该WebView不可缩放
        ws.builtInZoomControls = true
        // 隐藏原生的缩放控件
        ws.displayZoomControls = false
        // 启动应用缓存
        ws.setAppCacheEnabled(true)
        // 设置缓存模式
        // 缓存模式如下：
        // LOAD_CACHE_ONLY: 不使用网络，只读取本地缓存数据
        // LOAD_DEFAULT: （默认）根据cache-control决定是否从网络上取数据。
        // LOAD_NO_CACHE: 不使用缓存，只从网络获取数据.
        // LOAD_CACHE_ELSE_NETWORK，只要本地有，无论是否过期，或者no-cache，都使用缓存中的数据。
        ws.cacheMode = WebSettings.LOAD_DEFAULT
        ws.setAppCacheMaxSize(Long.MAX_VALUE)
        // setDefaultZoom  api19被弃用
        // 设置此属性，可任意比例缩放。
        ws.useWideViewPort = true
        // 告诉WebView启用JavaScript执行。默认的是false。
        // 注意：这个很重要   如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        ws.javaScriptEnabled = true

        //设置可以访问文件
        ws.allowFileAccess = true
        //支持通过JS打开新窗口
        ws.javaScriptCanOpenWindowsAutomatically = true
        //支持自动加载图片
        ws.loadsImagesAutomatically = true
        //  页面加载好以后，再放开图片
        //ws.setBlockNetworkImage(false);
        // 使用localStorage则必须打开
        ws.domStorageEnabled = true
        //防止中文乱码
        ws.defaultTextEncodingName = "UTF -8"
        /*
         * 排版适应屏幕
         * 用WebView显示图片，可使用这个参数
         * 设置网页布局类型： 1、LayoutAlgorithm.NARROW_COLUMNS ：
         * 适应内容大小 2、LayoutAlgorithm.SINGLE_COLUMN:适应屏幕，内容将自动缩放
         */
        ws.layoutAlgorithm = WebSettings.LayoutAlgorithm.NARROW_COLUMNS
        // WebView是否新窗口打开(加了后可能打不开网页)
        //ws.setSupportMultipleWindows(true);
        // webview从5.0开始默认不允许混合模式,https中不能加载http资源,需要设置开启。
        if (Build.VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP) {
            ws.mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        }
        //设置字体默认缩放大小
        ws.textZoom = 100
        // 不缩放
        setInitialScale(100)
        ws.loadsImagesAutomatically = Build.VERSION.SDK_INT >= VERSION_CODES.KITKAT
        //默认关闭硬件加速
        setOpenLayerType(true)
        //默认不开启密码保存功能
        setSavePassword(false)

        //设置响应js 的Alert()函数
        this.webChromeClient = (object : WebChromeClient() {
            override fun onJsAlert(
                view: WebView?,
                url: String?,
                message: String?,
                result: com.tencent.smtt.export.external.interfaces.JsResult?
            ): Boolean {
                Toast.makeText(context, message ?: "", Toast.LENGTH_SHORT).show()
                result?.confirm()
                return true
            }
        })

    }

    /**
     * 是否开启软硬件加速
     *
     * @param layerType 布尔值
     */
    private fun setOpenLayerType(layerType: Boolean) {
        if (layerType) {
            //开启软硬件加速，开启软硬件加速这个性能提升还是很明显的，但是会耗费更大的内存 。
            when {
                Build.VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP -> {
                    setLayerType(View.LAYER_TYPE_HARDWARE, null)
                }
                Build.VERSION.SDK_INT >= VERSION_CODES.KITKAT -> {
                    setLayerType(View.LAYER_TYPE_HARDWARE, null)
                }
                else -> {
                    setLayerType(View.LAYER_TYPE_SOFTWARE, null)
                }
            }
        }
    }

    /**
     * WebView 默认开启密码保存功能，但是存在漏洞。
     * 如果该功能未关闭，在用户输入密码时，会弹出提示框，询问用户是否保存密码，如果选择”是”，
     * 密码会被明文保到 /data/data/com.package.name/databases/webview.db 中，这样就有被盗取密码的危险
     *
     * @param save
     */
    private fun setSavePassword(save: Boolean) {
        this.settings.savePassword = save
    }
}
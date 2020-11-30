package com.cts.framework.lib_project.base.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.FragmentActivity
import org.greenrobot.eventbus.EventBus

/**
 * @Description: 封装BaseActivity
 * @Author: CTS
 * @Date: 2020/10/21 11:32
 */
abstract class BaseActivity : FragmentActivity() {

    private var isEventBus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initWindow()
        setContentView(setLayoutView())

        initParams()
        initCommonView()
        initView()
        initListener()
        initViewModelListener()
        initData()
        getData(true)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (isEventBus) {
            EventBus.getDefault().unregister(this)//反注册EventBus
        }

    }

    //以下是通用方法
    //不可重写
    fun setEventBus() {
        isEventBus = true
        //初始化EventBus
        EventBus.getDefault().register(this)
    }

    //沉浸状态栏
    fun transparentStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                        or WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION
            )
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = Color.TRANSPARENT
            window.navigationBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
    }

    //以下是模板方法
    /**
     * 可选
     * 初始化Window，在setContentView()之前运行
     */
    open fun initWindow() {}

    /**
     * 设置布局文件id
     */
    abstract fun setLayoutView(): View

    /**
     * 可选
     * 初始化参数，一般用于获取intent中携带的参数，在initView()之前运行
     */
    open fun initParams() {}

    /**
     * 可选
     * 初始化一些通用view
     */
    open fun initCommonView() {}

    /**
     * 可选
     * 初始化一些数据
     */
    open fun initData() {}

    /**
     * 初始化View（仅初始化view，在onCreate中初始化，涉及到数据的不放在这里）
     */
    abstract fun initView()

    /**
     * 初始化Listener
     */
    abstract fun initListener()

    /**
     * 初始化viewModel的监听器
     */
    abstract fun initViewModelListener()

    /**
     * 取数据（当前页面所有数据获取，如果刷新数据直接调用此方法）
     */
    abstract fun getData(isRefresh: Boolean)
}
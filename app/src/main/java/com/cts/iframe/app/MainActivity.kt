package com.cts.iframe.app

import android.os.Build
import android.os.Build.VERSION_CODES
import android.view.View
import com.cts.framework.lib_project.base.ui.BaseActivity
import com.cts.iframe.app.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun setLayoutView(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
    }

    override fun initListener() {
    }

    override fun initViewModelListener() {
    }

    override fun getData(isRefresh: Boolean) {
    }

    override fun onResume() {
        super.onResume()
        binding.forumContext.loadUrl("https://h5.static.txxtxx.cn/taskCenter/taskBoy.html?uid=1744390&token=84b3ce9cd64c7221a107b8f2565a6078")
    }

    /**
     * 是否开启软硬件加速
     *
     * @param layerType 布尔值
     */
    open fun setOpenLayerType(layerType: Boolean) {
        if (layerType) {
            //开启软硬件加速，开启软硬件加速这个性能提升还是很明显的，但是会耗费更大的内存 。
            when {
                Build.VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP -> {
                    binding.forumContext.setLayerType(View.LAYER_TYPE_HARDWARE, null)
                }
                Build.VERSION.SDK_INT >= VERSION_CODES.KITKAT -> {
                    binding.forumContext.setLayerType(View.LAYER_TYPE_HARDWARE, null)
                }
                else -> {
                    binding.forumContext.setLayerType(View.LAYER_TYPE_SOFTWARE, null)
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
    fun setSavePassword(save: Boolean) {
        if (save) {
            binding.forumContext.getSettings().setSavePassword(true)
        } else {
            binding.forumContext.getSettings().setSavePassword(false)
        }
    }

}
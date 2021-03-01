package com.cts.iframe.app

import android.os.Build
import android.os.Build.VERSION_CODES
import android.util.Log
import android.view.View
import com.cts.framework.lib_project.base.ui.BaseActivity
import com.cts.iframe.app.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    //下载通道
    private val channel = Channel<Int>()

    override fun setLayoutView(): View {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun initView() {
        //测试
        GlobalScope.launch {
            for (i in 1..5) {
                channel.send(i * i)
                delay(2000)
                if (i == 3) {
                    channel.send(999)
                    delay(2000)
                }
            }
        }
        GlobalScope.launch {
            for (item in channel) {
                Log.d("测试channel", item.toString())
            }
        }
//        for (i in 1..5) {
//            channel.send(i*i)
//        }
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


}
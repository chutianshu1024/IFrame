package com.cts.module_test1

import android.view.View
import com.cts.framework.lib_project.base.ui.BaseActivity
import com.cts.module_test1.databinding.Test1ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: Test1ActivityMainBinding

    override fun setLayoutView(): View {
        binding = Test1ActivityMainBinding.inflate(layoutInflater)
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
        binding.forumContext.loadUrl("https://www.jianshu.com/p/7116ae0752a4")
    }
}

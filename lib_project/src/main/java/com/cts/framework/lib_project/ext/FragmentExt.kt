package com.zzzl.zzlease.util

import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

/**
 * @Description: Fragment拓展函数
 * @Author: CTS
 * @Date: 2019/6/18 14:39
 */

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}

inline fun <T : View> Fragment.findViewById(@IdRes id: Int): T? {
    return if (activity == null) {
        null
    } else {
        activity?.findViewById<T>(id)
    }
}

/**
 * 取ViewModel
 */
inline fun <T : ViewModel> Fragment.getViewModel(viewModelClass: Class<T>): T {
    return ViewModelProviders.of(this).get(viewModelClass)
}

/**
 * 取ViewModel
 */
inline fun <T : ViewModel> Fragment.getViewModelFromActivity(viewModelClass: Class<T>): T {
    return ViewModelProviders.of(activity!!).get(viewModelClass)
}
package com.cts.framework.lib_project.utils.anim

import android.animation.ValueAnimator
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation

/**
 * @Description: 动画工具类
 * @Author: CTS
 * @Date: 2020/1/9 12:28
 */
class AnimUtils {
    companion object {
        val instance: AnimUtils by lazy { AnimUtils() }
    }

    /**
     * 动态改变view的高度动画效果
     * 原理:动画改变view LayoutParams.height的值
     * @param view 要进行高度改变动画的view
     * @param startHeight 动画前的view的高度
     * @param endHeight 动画后的view的高度
     */
    inline fun changeViewHeightAnimatorStart(
        view: View?,
        startHeight: Int,
        endHeight: Int,
        duration: Long = 300L//默认300ms
    ) {
        if (view != null && startHeight >= 0 && endHeight >= 0) {
            val animator: ValueAnimator = ValueAnimator.ofInt(startHeight, endHeight)
            animator.duration = duration
            animator.addUpdateListener { animation ->
                val params: ViewGroup.LayoutParams = view.layoutParams
                params.height = animation.animatedValue as Int
                view.layoutParams = params
            }
            animator.start()
        }
    }

    /**
     * 启动y轴缩放动画
     */
    inline fun startYScale(
        view: View,
        isOpen: Boolean,//区分是展开还是收起  true:展开
        duration: Long = 300L//默认300ms
    ) {
        val animation =
            ScaleAnimation(
                1f,
                1f,
                if (isOpen) 0f else 1f,
                if (isOpen) 1f else 0f,
                Animation.RELATIVE_TO_SELF,
                0.5f,
                Animation.RELATIVE_TO_SELF,
                0f
            )
        animation.duration = duration
        //设置持续时间
        animation.fillAfter = true
        //设置动画结束之后的状态是否是动画的最终状态，true，表示是保持动画结束时的最终状态
        animation.repeatCount = 0
        //设置循环次数，0为1次
        view.startAnimation(animation)
    }

}
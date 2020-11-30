package com.cts.framework.core.base

import android.app.Application
import android.content.Context
import androidx.multidex.BuildConfig
import androidx.multidex.MultiDex

/**
 * @Description: Application基类，不耦合任何项目的业务逻辑
 * @Author: CTS
 * @Date: 2019/7/5 17:43
 */
open class CoreApplication : Application() {
    private val TAG = "CoreApplication"

    var IS_DEBUG = BuildConfig.DEBUG

//    //activity栈
//    private var activityStack: Stack<Activity> = Stack()
//
//    //初始化activityLinkedList，用于管理Activity
//    private fun initActivityList() {
//        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
//            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
//                // 在Activity启动时（onCreate()） 写入Activity实例到容器内
//                activityStack.add(activity)
//            }
//
//            override fun onActivityDestroyed(activity0: Activity) {
//                // 在Activity结束时（Destroyed（）） 写出Activity实例
//                activityStack.remove(activity0)
//            }
//
//            override fun onActivityStarted(activity: Activity) {}
//            override fun onActivityResumed(activity: Activity) {}
//            override fun onActivityPaused(activity: Activity) {}
//            override fun onActivityStopped(activity: Activity) {}
//            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
//        })
//    }
//
//    fun exitApp() {
//        Log.d(TAG, "容器内的Activity列表如下 ")
//        //先打印当前容器内的Activity列表
//        for (activity in activityStack) {
//            Log.d(TAG, activity.localClassName)
//        }
//
//        Log.d(TAG, "正逐步退出容器内所有Activity")
//        //逐个退出Activity
//        for (activity in activityStack) {
//            activity.finish()
//        }
//
//        //结束进程
//        android.os.Process.killProcess(android.os.Process.myPid())
//        exitProcess(0)
//    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        //MultiDex分包方法 必须最先初始化
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()


    }

}
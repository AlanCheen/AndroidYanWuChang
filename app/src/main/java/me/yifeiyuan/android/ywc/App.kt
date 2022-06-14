package me.yifeiyuan.android.ywc

import android.app.Application
import android.content.ComponentCallbacks
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import me.yifeiyuan.adh.DebugConfig
import me.yifeiyuan.adh.DebugHelper

/**
 * Created by 程序亦非猿 on 2022/5/30.
 */
class App : Application() {

    companion object {
        private const val TAG = "App"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate() called")

        DebugConfig().apply {
            debuggable = false
            application = this@App
            enableStrictMode = false
            detectActivityLifecycle = true
            detectFragmentLifecycle = true
            logLevel = DebugConfig.LogLevel.V
        }.also {
            DebugHelper.setup(it)
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(TAG, "onConfigurationChanged() called with: newConfig = $newConfig")
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        Log.d(TAG, "attachBaseContext() called with: base = $base")
    }

    override fun registerComponentCallbacks(callback: ComponentCallbacks?) {
        super.registerComponentCallbacks(callback)
        Log.d(TAG, "registerComponentCallbacks() called with: callback = $callback")
    }

    override fun unregisterComponentCallbacks(callback: ComponentCallbacks?) {
        super.unregisterComponentCallbacks(callback)
        Log.d(TAG, "unregisterComponentCallbacks() called with: callback = $callback")
    }

    override fun registerActivityLifecycleCallbacks(callback: ActivityLifecycleCallbacks?) {
        super.registerActivityLifecycleCallbacks(callback)
        Log.d(TAG, "registerActivityLifecycleCallbacks() called with: callback = $callback")
    }

    override fun unregisterActivityLifecycleCallbacks(callback: ActivityLifecycleCallbacks?) {
        super.unregisterActivityLifecycleCallbacks(callback)
        Log.d(TAG, "unregisterActivityLifecycleCallbacks() called with: callback = $callback")
    }

    override fun registerOnProvideAssistDataListener(callback: OnProvideAssistDataListener?) {
        super.registerOnProvideAssistDataListener(callback)
        Log.d(TAG, "registerOnProvideAssistDataListener() called with: callback = $callback")
    }

    override fun unregisterOnProvideAssistDataListener(callback: OnProvideAssistDataListener?) {
        super.unregisterOnProvideAssistDataListener(callback)
        Log.d(TAG, "unregisterOnProvideAssistDataListener() called with: callback = $callback")
    }
}
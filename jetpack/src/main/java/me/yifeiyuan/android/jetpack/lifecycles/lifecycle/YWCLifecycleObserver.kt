package me.yifeiyuan.android.jetpack.lifecycles.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

/**
 * Created by 程序亦非猿 on 2022/6/13.
 *
 * @OnLifecycleEvent 已经被废弃
 *
 * 注解的方法里可以加上 lifecycleOwner 参数
 * onStart()
 * onStart(owner: LifecycleOwner)
 */
class YWCLifecycleObserver : LifecycleObserver {

    companion object {
        private const val TAG = "YWCLifecycleObserver"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.d(TAG, "onCreate() called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(owner: LifecycleOwner) {
        Log.d(TAG, "onStart() called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(owner: LifecycleOwner) {
        Log.d(TAG, "onResume() called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(owner: LifecycleOwner) {
        Log.d(TAG, "onPause() called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(owner: LifecycleOwner) {
        Log.d(TAG, "onStop() called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(owner: LifecycleOwner) {
        Log.d(TAG, "onDestroy() called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner, event: Lifecycle.Event) {

    }
}
package me.yifeiyuan.android.jetpack.lifecycles.lifecycle

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

/**
 * Created by 程序亦非猿 on 2022/6/13.
 */
class YWCLifecycleEventObserver : LifecycleEventObserver {

    companion object {
        private const val TAG = "YWCLifecycleEventObserv"
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        Log.d(TAG, "onStateChanged() called with: source = $source, event = $event")
    }
}
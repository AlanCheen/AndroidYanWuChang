package me.yifeiyuan.android.jetpack.lifecycles.lifecycle

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * Created by 程序亦非猿 on 2022/6/14.
 */
class LifecycleHandler(
    lifecycleOwner: LifecycleOwner,
    looper: Looper = Looper.getMainLooper(),
    callback: Callback? = null
) :
    Handler(looper, callback), DefaultLifecycleObserver {

    init {
        lifecycleOwner.lifecycle.addObserver(this)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        owner.lifecycle.removeObserver(this)
    }
}
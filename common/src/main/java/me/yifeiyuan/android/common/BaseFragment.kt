package me.yifeiyuan.android.common

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

/**
 * Created by 程序亦非猿 on 2022/6/14.
 */
class BaseFragment : Fragment() {

    var logTag = "BaseFragment"

    var logLifecycle = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()

        if (logLifecycle) {
            log("Fragment.onCreate: ")
        }
    }

    override fun onStart() {
        super.onStart()
        if (logLifecycle) {
            log("Fragment.onStart: ")
        }
    }

    override fun onResume() {
        super.onResume()
        if (logLifecycle) {
            log("Fragment.onResume: ")
        }
    }

    override fun onPause() {
        super.onPause()
        if (logLifecycle) {
            log("Fragment.onPause: ")
        }
    }

    override fun onStop() {
        super.onStop()
        if (logLifecycle) {
            log("Fragment.onStop: ")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (logLifecycle) {
            log("Fragment..onDestroyView: ")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (logLifecycle) {
            log("Fragment.onDestroy: ")
        }
    }

    private fun setup() {
        val ywcAnnotation: YWC? = this::class.java.getAnnotation(YWC::class.java)

        ywcAnnotation?.let {
            logLifecycle = ywcAnnotation.logLifecycle
            logTag = ywcAnnotation.logTag
        }
    }

    protected fun log(msg: String, tag: String = logTag) {
        Log.d(tag, msg)
    }
}
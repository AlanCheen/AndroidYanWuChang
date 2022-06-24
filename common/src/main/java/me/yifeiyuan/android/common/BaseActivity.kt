package me.yifeiyuan.android.common

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by 程序亦非猿 on 2022/6/14.
 */
open class BaseActivity : AppCompatActivity {

    var logTag = "BaseActivity"

    var logLifecycle = false

    constructor() : super()
    constructor(contentLayoutId: Int) : super(contentLayoutId)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup()
        if (logLifecycle) {
            log("Activity.onCreate: ")
        }
    }

    private fun setup() {
        val ywcAnnotation: YWC? = this::class.java.getAnnotation(YWC::class.java)

        ywcAnnotation?.let {
            logLifecycle = ywcAnnotation.logLifecycle
            logTag = ywcAnnotation.logTag.ifEmpty { "BaseActivity" }
            title = ywcAnnotation.title.ifEmpty { ywcAnnotation.logTag }
        }
    }

    override fun onStart() {
        super.onStart()
        if (logLifecycle) {
            log("Activity.onStart: ")
        }
    }

    override fun onResume() {
        if (logLifecycle) {
            log("Activity.onResume:  super.onResume() 调用之前")
        }
        super.onResume()
        if (logLifecycle) {
            log("Activity.onResume: ")
        }
    }

    override fun onRestart() {
        super.onRestart()
        if (logLifecycle) {
            log("Activity.onRestart: ")
        }
    }

    override fun onPause() {
        super.onPause()
        if (logLifecycle) {
            log("Activity.onPause: ")
        }
    }

    override fun onStop() {
        super.onStop()
        if (logLifecycle) {
            log("Activity.onStop: ")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (logLifecycle) {
            log("Activity.onDestroy: ")
        }
    }

    protected fun log(msg: String, tag: String = logTag) {
        Log.d(tag, msg)
    }
}

package me.yifeiyuan.android.jetpack.lifecycles.lifecycle

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.lifecycle.*
import me.yifeiyuan.android.common.BaseActivity
import me.yifeiyuan.android.common.YWC
import me.yifeiyuan.android.jetpack.R

/**
 * 测试 Lifecycle 的代码
 */
@YWC(
    LifecycleActivity.TAG,
    LifecycleActivity.TAG,
)
class LifecycleActivity : BaseActivity() {

    companion object{
         const val TAG = "LifecycleActivity"
    }

    var lifecycleHandler: LifecycleHandler = LifecycleHandler(this)

    var handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "Activity.onCreate: pre super.onCreate")
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Activity.onCreate: after super.onCreate")

        setContentView(R.layout.activity_lifecycle)

        //官方废弃
//        testLifecycleObserverWithLifecycleOnEvent()

//        testDefaultLifecycleObserver()
        testLifecycleEventObserver()
//        lifecycle.addObserver(ConflictLifecycleObserver())
    }

    private fun testLifecycleEventObserver() {
        lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                Log.d(
                    TAG,
                    "onStateChanged() called with: source = $source, event = $event : LifecycleEventObserver"
                )

                when (event) {
                    Lifecycle.Event.ON_CREATE -> {
                        Log.d(TAG, "LifecycleEventObserver: ON_CREATE")
                    }
                    Lifecycle.Event.ON_START -> {
                        Log.d(TAG, "LifecycleEventObserver: ON_START")
                    }

                    Lifecycle.Event.ON_RESUME -> {
                        Log.d(TAG, "LifecycleEventObserver: ON_RESUME")
                    }

                    Lifecycle.Event.ON_PAUSE -> {
                        Log.d(TAG, "LifecycleEventObserver: ON_PAUSE")
                    }

                    Lifecycle.Event.ON_STOP -> {
                        Log.d(TAG, "LifecycleEventObserver: ON_STOP")
                    }

                    Lifecycle.Event.ON_DESTROY -> {
                        Log.d(TAG, "LifecycleEventObserver: ON_DESTROY")
                    }
                    //不会有 on any 事件
                    Lifecycle.Event.ON_ANY -> {
                        Log.d(TAG, "LifecycleEventObserver: ON_ANY")
                    }
                }
            }
        })
    }

    private fun testLifecycleObserverWithLifecycleOnEvent() {

        lifecycle.addObserver(object : LifecycleObserver {

            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate() {
                Log.d(TAG, "LifecycleObserver.onCreate: ")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onStart() {
                Log.d(TAG, "LifecycleObserver.onStart: ")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            fun onResume(owner: LifecycleOwner) {
                Log.d(TAG, "LifecycleObserver.onResume: ")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
            fun onPause() {
                Log.d(TAG, "LifecycleObserver.onPause: ")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
            fun onStop() {
                Log.d(TAG, "LifecycleObserver.onStop: ")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                Log.d(TAG, "LifecycleObserver.onDestroy: ")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
            fun onAny(owner: LifecycleOwner,event: Lifecycle.Event) {
                Log.d(TAG, "LifecycleObserver.onAny: ")
                Log.d(TAG, "onAny() called with: owner = $owner, event = $event")
            }
        })
    }

    private fun testDefaultLifecycleObserver() {
        lifecycle.addObserver(object : DefaultLifecycleObserver {

            override fun onCreate(owner: LifecycleOwner) {
                super.onCreate(owner)
                Log.d(TAG, "DefaultLifecycleObserver.onCreate: ")
            }

            override fun onStart(owner: LifecycleOwner) {
                super.onStart(owner)
                Log.d(TAG, "DefaultLifecycleObserver.onStart: ")
            }

            override fun onResume(owner: LifecycleOwner) {
                super.onResume(owner)
                Log.d(TAG, "DefaultLifecycleObserver.onResume: ")
            }

            override fun onPause(owner: LifecycleOwner) {
                super.onPause(owner)
                Log.d(TAG, "DefaultLifecycleObserver.onPause: ")
            }

            override fun onStop(owner: LifecycleOwner) {
                super.onStop(owner)
                Log.d(TAG, "DefaultLifecycleObserver.onStop: ")
            }

            override fun onDestroy(owner: LifecycleOwner) {
                super.onDestroy(owner)
                Log.d(TAG, "DefaultLifecycleObserver.onDestroy: ")
            }
        })
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "Activity.onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "Activity.onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "Activity.onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "Activity.onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Activity.onDestroy: ")
    }

    class ConflictLifecycleObserver : DefaultLifecycleObserver, LifecycleEventObserver {

        companion object {
            private const val TAG = "ConflictLifecycle"
        }

        override fun onCreate(owner: LifecycleOwner) {
            super.onCreate(owner)
            Log.d(TAG, "ConflictLifecycleObserver.onCreate:")
        }

        override fun onResume(owner: LifecycleOwner) {
            super.onResume(owner)
            Log.d(TAG, "ConflictLifecycleObserver.onResume:")
        }

        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            Log.d(
                TAG,
                "ConflictLifecycleObserver.onStateChanged()  event = $event : ConflictLifecycleObserver"
            )
        }

    }
}
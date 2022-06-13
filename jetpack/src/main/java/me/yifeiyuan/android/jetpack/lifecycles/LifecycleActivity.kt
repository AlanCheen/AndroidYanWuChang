package me.yifeiyuan.android.jetpack.lifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.lifecycle.*
import me.yifeiyuan.android.jetpack.R

class LifecycleActivity : AppCompatActivity() {

    private val TAG = "LifecycleActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        //官方废弃
        lifecycle.addObserver(object : LifecycleObserver {

            @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
            fun onCreate() {
                Log.d(TAG, "onCreate() called by OnLifecycleEvent")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            fun onResume() {
                Log.d(TAG, "onResume() called by OnLifecycleEvent")
            }

            @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
            fun onAny() {

            }
        })

//        lifecycle.addObserver(object : DefaultLifecycleObserver {
//
//            override fun onCreate(owner: LifecycleOwner) {
//                super.onCreate(owner)
//                Log.d(TAG, "onCreate() called by DefaultLifecycleObserver")
//            }
//
//            override fun onResume(owner: LifecycleOwner) {
//                super.onResume(owner)
//                Log.d(TAG, "onResume() called by DefaultLifecycleObserver")
//            }
//        })

        lifecycle.addObserver(object : LifecycleEventObserver {
            override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
                Log.d(TAG, "onStateChanged() called with: source = $source, event = $event")
            }
        })

        lifecycle.addObserver(ConflictLifecycleObserver())

    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    class ConflictLifecycleObserver : DefaultLifecycleObserver, LifecycleEventObserver {

        companion object{
            private const val TAG = "LifecycleActivity"
        }

//        override fun onCreate(owner: LifecycleOwner) {
//            super.onCreate(owner)
//            Log.d(TAG, "onCreate: ")
//        }
//
//        override fun onResume(owner: LifecycleOwner) {
//            super.onResume(owner)
//            Log.d(TAG, "onResume: ")
//        }

        override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
            Log.d(TAG, "onStateChanged() called with: source = $source, event = $event")
        }

    }
}
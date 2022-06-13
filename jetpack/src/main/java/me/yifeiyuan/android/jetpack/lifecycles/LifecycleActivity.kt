package me.yifeiyuan.android.jetpack.lifecycles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleObserver
import me.yifeiyuan.android.jetpack.R

class LifecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        lifecycle.addObserver(YWCLifecycleObserver())
    }
}
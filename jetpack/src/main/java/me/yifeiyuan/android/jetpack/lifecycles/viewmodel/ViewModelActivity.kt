package me.yifeiyuan.android.jetpack.lifecycles.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.yifeiyuan.android.jetpack.R

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
    }
}
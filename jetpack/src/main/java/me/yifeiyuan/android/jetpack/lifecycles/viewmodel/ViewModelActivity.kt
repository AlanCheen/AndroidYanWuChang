package me.yifeiyuan.android.jetpack.lifecycles.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.viewmodel.viewModelFactory
import me.yifeiyuan.android.jetpack.R

class ViewModelActivity : AppCompatActivity() {


    lateinit var viewModel: YWCViewModel

//    var viewModel2 : YWCViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)

        viewModel = ViewModelProvider(this).get()

    }
}
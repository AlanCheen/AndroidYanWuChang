package me.yifeiyuan.android.jetpack.lifecycles.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel

/**
 * Created by 程序亦非猿 on 2022/6/14.
 */
class YWCAndroidViewModel(application: Application) : AndroidViewModel(application) {

    override fun onCleared() {
        super.onCleared()
    }
}
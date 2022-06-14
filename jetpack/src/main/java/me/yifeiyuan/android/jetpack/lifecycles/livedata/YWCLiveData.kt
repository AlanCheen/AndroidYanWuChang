package me.yifeiyuan.android.jetpack.lifecycles.livedata

import android.util.Log
import androidx.lifecycle.LiveData

/**
 * Created by 程序亦非猿 on 2022/6/14.
 */
open class YWCLiveData<T> : LiveData<T>() {

    companion object{
        private const val TAG = "YWCLiveData"
    }

    override fun onActive() {
        super.onActive()
        Log.d(TAG, "onActive: ")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d(TAG, "onInactive: ")
    }


}
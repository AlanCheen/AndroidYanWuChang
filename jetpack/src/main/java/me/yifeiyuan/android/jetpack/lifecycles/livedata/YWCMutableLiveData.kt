package me.yifeiyuan.android.jetpack.lifecycles.livedata

import androidx.lifecycle.MutableLiveData

/**
 * Created by 程序亦非猿 on 2022/6/20.
 */
class YWCMutableLiveData<T> : MutableLiveData<T> {

    constructor(value: T) : super(value)
    constructor() : super()

    override fun postValue(value: T) {
        super.postValue(value)
    }

    override fun setValue(value: T) {
        super.setValue(value)
    }

    override fun onActive() {
        super.onActive()
    }

    override fun onInactive() {
        super.onInactive()
    }
}
package me.yifeiyuan.android.jetpack.lifecycles.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

/**
 * Created by 程序亦非猿 on 2022/6/27.
 */
class CoroutinesViewModel : ViewModel() {

   private val repository = Repository()

    fun login(){

        viewModelScope.launch(Dispatchers.IO){
            repository.login()
        }

    }
}
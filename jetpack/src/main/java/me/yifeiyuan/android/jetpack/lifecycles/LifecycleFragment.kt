package me.yifeiyuan.android.jetpack.lifecycles

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Created by 程序亦非猿 on 2022/6/13.
 */
class LifecycleFragment : Fragment() {

    companion object{
        private const val TAG = "LifecycleFragment"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
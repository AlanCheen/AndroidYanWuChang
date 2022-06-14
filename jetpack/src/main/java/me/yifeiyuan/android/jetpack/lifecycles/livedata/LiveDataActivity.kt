package me.yifeiyuan.android.jetpack.lifecycles.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import me.yifeiyuan.android.common.BaseActivity
import me.yifeiyuan.android.common.YWC
import me.yifeiyuan.android.jetpack.R
import kotlin.math.log

@YWC(
    "LiveDataActivity",
    title = "LiveDataActivity",
    logLifecycle = true
)
class LiveDataActivity : BaseActivity() {

    private val TAG = "LiveDataActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)

        testBasicLiveData()

        val liveData = object : MutableLiveData<String>() {
            override fun onActive() {
                super.onActive()
                Log.d(TAG, "onActive: ")
            }

            override fun onInactive() {
                super.onInactive()
                Log.d(TAG, "onInactive: ")
            }
        }

        liveData.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.d(TAG, "onChanged() called with: t = $t")
            }
        })
    }

    /**
     * 测试 LiveData 基础功能
     */
    private fun testBasicLiveData() {
        val liveData = MutableLiveData<String>()

        val preObserver = object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.d(TAG, "onChanged() called with: t = $t")
            }
        }

        liveData.observe(this, preObserver)

        liveData.value = "程序亦非猿"

        val afterObserver = object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.d(TAG, "onChanged() called with: t = $t")
            }
        }

        liveData.observe(this, afterObserver)
    }
}
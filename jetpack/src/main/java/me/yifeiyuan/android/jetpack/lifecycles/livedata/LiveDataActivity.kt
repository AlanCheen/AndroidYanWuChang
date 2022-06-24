package me.yifeiyuan.android.jetpack.lifecycles.livedata

import android.os.Bundle
import android.util.Log
import androidx.arch.core.util.Function
import androidx.lifecycle.*
import me.yifeiyuan.android.common.BaseActivity
import me.yifeiyuan.android.common.YWC
import me.yifeiyuan.android.jetpack.R

/**
 * https://developer.android.com/topic/libraries/architecture/livedata
 */
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

    private fun testBasicLiveData() {
        val liveData = MutableLiveData<String>()

        val observer = object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.d(TAG, "onChanged() called with: t = $t")
            }
        }

        liveData.observe(this, observer)

        liveData.value = "程序亦非猿"
    }

    override fun onResume() {
        super.onResume()

        testBasicLiveData()

        testLiveDataSticky()
    }

    private fun testLiveDataSticky() {
        val liveData = MutableLiveData<String>()
        liveData.value = "程序亦非猿 before observe"

        val observer = object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.d(TAG, "onChanged() called with: t = $t")
            }
        }

        liveData.observe(this, observer)

        liveData.value = "程序亦非猿 after observe"
    }

    /**
     * 测试 LiveData 基础功能
     */
    private fun testBasicLiveData2() {
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

    private fun testMediatorLiveData() {

        val nameLiveData = MutableLiveData("默认值")

        val ageLiveData = MutableLiveData(-1)

        val mediatorLiveData = MediatorLiveData<String>()

        mediatorLiveData.addSource(nameLiveData, object : Observer<String> {
            override fun onChanged(name: String?) {
                mediatorLiveData.value = "姓名：" + name + "，年龄：" + ageLiveData.value
            }
        })

        mediatorLiveData.addSource(ageLiveData, object : Observer<Int> {
            override fun onChanged(age: Int?) {
                mediatorLiveData.value = "姓名：" + nameLiveData.value + "，年龄：" + age
            }
        })

        mediatorLiveData.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                Log.d(TAG, "mediatorLiveData onChanged() called with: t = $t")
            }
        })

        nameLiveData.value = "程序亦非猿"
        ageLiveData.value = 18
    }

    private fun testMapTransformations() {
        val stringLiveData = MutableLiveData("666")

        val intLiveData: LiveData<Int> = Transformations.map(stringLiveData, Function {
            Integer.parseInt(it)
        })

        intLiveData.observe(this, object : Observer<Int> {
            override fun onChanged(t: Int?) {
                Log.d(TAG, "intLiveData onChanged: ")
            }
        })
    }

    private fun testSwitchMapTransformations() {
        val stringLiveData = MutableLiveData("666")

        val intLiveData: LiveData<Int> = Transformations.switchMap(stringLiveData, object:Function<String,LiveData<Int>>{
            override fun apply(input: String?): LiveData<Int> {
                return MutableLiveData(Integer.parseInt(input))
            }
        })

        intLiveData.observe(this, object : Observer<Int> {
            override fun onChanged(t: Int?) {
                Log.d(TAG, "intLiveData onChanged: ")
            }
        })
    }
}
package me.yifeiyuan.android.ywc

import android.content.Intent
import me.yifeiyuan.adh.showcase.AdhShowcaseActivity
import me.yifeiyuan.adh.showcase.AdhShowcaseItem
import me.yifeiyuan.android.jetpack.lifecycles.lifecycle.LifecycleActivity
import me.yifeiyuan.android.jetpack.lifecycles.livedata.LiveDataActivity

private const val TAG = "MainActivity"

class MainActivity : AdhShowcaseActivity() {


    override fun provideShowcaseItems(): List<AdhShowcaseItem> {
        return mutableListOf(
            //lifecycle
            createShowcaseItem(
                "Jetpack Lifecycle",
                createIntent(LifecycleActivity::class.java),
                null
            ),
            createShowcaseItem(
                "Jetpack LiveData",
                createIntent(LiveDataActivity::class.java),
                null
            ),
        )
    }

    private fun createIntent(clazz: Class<*>) = Intent(this@MainActivity, clazz)

    override fun onResume() {
        super.onResume()
        DebugPropsReader.isDebug()
    }
}
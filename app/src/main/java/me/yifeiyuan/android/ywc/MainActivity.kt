package me.yifeiyuan.android.ywc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.yifeiyuan.adh.showcase.AdhShowcaseActivity
import me.yifeiyuan.adh.showcase.AdhShowcaseItem
import me.yifeiyuan.android.jetpack.JetpackActivity
import me.yifeiyuan.android.jetpack.lifecycles.LifecycleActivity
import me.yifeiyuan.android.jetpack.lifecycles.livedata.LiveDataActivity

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

    private fun createIntent(clazz: Class<*>) = Intent(this@MainActivity,clazz)
}
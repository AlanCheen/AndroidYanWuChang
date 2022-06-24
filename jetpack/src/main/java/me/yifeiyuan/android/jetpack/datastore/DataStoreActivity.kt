package me.yifeiyuan.android.jetpack.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.yifeiyuan.android.jetpack.R

/**
 *
 * https://developer.android.com/topic/libraries/architecture/datastore
 */
class DataStoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_store)
    }
}
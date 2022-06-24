package me.yifeiyuan.android.components

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import me.yifeiyuan.android.common.BaseActivity
import me.yifeiyuan.android.common.YWC

@YWC(
    BroadcastReceiverActivity.TAG
)
class BroadcastReceiverActivity : BaseActivity(R.layout.activity_broadcast_receiver) {
    companion object{
         const val TAG = "BroadcastReceiverActivi"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    fun testBroadcastReceiverByCode() {

        val broadcastReceiver = object : BroadcastReceiver(){
            override fun onReceive(context: Context?, intent: Intent?) {
            }
        }

        val filter = IntentFilter()

        registerReceiver(broadcastReceiver, filter)

        registerReceiver(YWCBroadCastReceiver(), filter)
    }
    fun testSendBroadcast() {

        sendBroadcast(Intent())
    }

    fun testSendOrderBroadcast() {
        sendOrderedBroadcast(Intent(), null)
    }

    fun testLocalBroadcast() {
        val filter = IntentFilter()

        LocalBroadcastManager.getInstance(this).registerReceiver(YWCBroadCastReceiver(), filter)

        LocalBroadcastManager.getInstance(this).sendBroadcast(Intent())
    }
}
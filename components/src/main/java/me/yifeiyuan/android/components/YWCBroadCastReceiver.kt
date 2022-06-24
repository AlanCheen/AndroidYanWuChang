package me.yifeiyuan.android.components

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.util.Log

/**
 * Created by 程序亦非猿 on 2022/6/13.
 */
class YWCBroadCastReceiver : BroadcastReceiver {

    companion object {
        private const val TAG = "YWCBroadCast"
    }

    constructor() : super() {
        Log.e(TAG, "" , NullPointerException("YWCBroadCastReceiver created"))
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.e(TAG, "onReceive" , NullPointerException("YWCBroadCastReceiver onReceive"))
        Log.d(TAG, "onReceive() called with: context = $context, intent = $intent")

        //
        abortBroadcast()
    }

    override fun peekService(myContext: Context?, service: Intent?): IBinder {
        Log.d(TAG, "peekService() called with: myContext = $myContext, service = $service")
        return super.peekService(myContext, service)
    }
}
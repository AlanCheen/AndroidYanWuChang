package me.yifeiyuan.android.components

import android.app.Service
import android.content.Intent
import android.os.IBinder

/**
 * Created by 程序亦非猿 on 2022/6/13.
 */
class YWCBindService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
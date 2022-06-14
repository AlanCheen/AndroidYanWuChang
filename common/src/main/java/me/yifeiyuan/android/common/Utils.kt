package me.yifeiyuan.android.common

import androidx.appcompat.app.AppCompatActivity

/**
 * Created by 程序亦非猿 on 2022/6/14.
 */


fun parseYwcAnnotation(activity: AppCompatActivity) {

    val ywcAnnotation :YWC? = activity::class.java.getAnnotation(YWC::class.java)

    ywcAnnotation?.run {

        ywcAnnotation.logLifecycle

        activity.title = ywcAnnotation.title
    }

}
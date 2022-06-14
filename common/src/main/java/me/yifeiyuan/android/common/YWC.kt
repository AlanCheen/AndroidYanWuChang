package me.yifeiyuan.android.common

/**
 * Created by 程序亦非猿 on 2022/6/14.
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)

annotation class YWC(
    val logTag: String = "YWC",
    val title: String = "演武场",
    val logLifecycle: Boolean = false
)

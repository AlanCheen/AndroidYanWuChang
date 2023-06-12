package me.yifeiyuan.android.ywc

/**
 * Created by 程序亦非猿 on 2022/6/30.
 */
object DebugPropsReader {


    fun isDebug():Boolean{

        var result = true;

        try {
        val process = Runtime.getRuntime().exec("getprop jwc.debug")
            val resultString = process.inputStream.bufferedReader().readLine()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return result;
    }
}
package me.yifeiyuan.android.ywc.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView


/**
 * Created by 程序亦非猿 on 2022/6/13.
 */
class IconFontTextView : AppCompatTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        try {
            val iconfont = Typeface.createFromAsset(context.assets, "iconfont/iconfont.ttf")
            typeface = iconfont
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
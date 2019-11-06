package emrizkiem.dev.secondkade.util

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import kotlin.math.roundToInt

class ProportionalImageView : AppCompatImageView  {

    companion object {
        private val ASPECT_RATIO = 1.5f
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val width = View.MeasureSpec.getSize(widthMeasureSpec)
        val height = (width * ASPECT_RATIO).roundToInt()
        setMeasuredDimension(width, height)
    }
}
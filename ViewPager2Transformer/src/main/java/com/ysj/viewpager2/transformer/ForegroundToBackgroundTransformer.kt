package com.ysj.viewpager2.transformer

import android.view.View
import kotlin.math.abs
import kotlin.math.max

class ForegroundToBackgroundTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        val height = page.height.toFloat()
        val width = page.width.toFloat()
        val scale = max(if (position > 0) 1f else abs(1f + position), 0.5f)

        page.scaleX = scale
        page.scaleY = scale
        page.pivotX = width * 0.5f
        page.pivotY = height * 0.5f
        if (isHorizontal(page)) {
            page.translationX = if (position > 0) width * position else -width * position * 0.25f
        } else {
            page.translationY = if (position > 0) height * position else -height * position * 0.25f
        }
    }

}
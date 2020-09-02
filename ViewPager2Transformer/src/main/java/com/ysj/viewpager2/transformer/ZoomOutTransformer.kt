package com.ysj.viewpager2.transformer

import android.view.View
import kotlin.math.abs

class ZoomOutTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        val scale = 1f + abs(position)
        page.scaleX = scale
        page.scaleY = scale
        page.pivotX = page.width * 0.5f
        page.pivotY = page.height * 0.5f
        page.alpha = if (position < -1f || position > 1f) 0f else 1f - (scale - 1f)
        if (isHorizontal(page)) {
            page.translationX = -page.left.toFloat() // scrolling would change view position, so move it back
        } else {
            page.translationY = -page.top.toFloat() // scrolling would change view position, so move it back
        }
    }

}
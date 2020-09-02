package com.ysj.viewpager2.transformer

import android.view.View
import kotlin.math.abs
import kotlin.math.max

class ZoomOutSlideTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        // Modify the default slide transition to shrink the page as well
        val height = page.height.toFloat()
        val width = page.width.toFloat()
        val scaleFactor = max(MIN_SCALE, 1 - abs(position))
        val vertMargin = height * (1 - scaleFactor) / 2
        val horzMargin = width * (1 - scaleFactor) / 2

        // Center vertically
        page.pivotY = 0.5f * height
        page.pivotX = 0.5f * width

        if (isHorizontal(page)) {
            page.translationX =
                if (position < 0) horzMargin - vertMargin / 2
                else -horzMargin + vertMargin / 2
        } else {
            page.translationY =
                if (position < 0) horzMargin - vertMargin / 2
                else -horzMargin + vertMargin / 2
        }

        // Scale the page down (between MIN_SCALE and 1)
        page.scaleX = scaleFactor
        page.scaleY = scaleFactor

        // Fade the page relative to its size.
        page.alpha = MIN_ALPHA + (scaleFactor - MIN_SCALE) / (1 - MIN_SCALE) * (1 - MIN_ALPHA)
    }

    companion object {
        private const val MIN_SCALE = 0.85f
        private const val MIN_ALPHA = 0.5f
    }

}
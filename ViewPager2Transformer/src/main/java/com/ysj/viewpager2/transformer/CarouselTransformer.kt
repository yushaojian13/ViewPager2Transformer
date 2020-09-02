package com.ysj.viewpager2.transformer

import android.view.View
import kotlin.math.abs

class CarouselTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        // Modify the default slide transition to shrink the page as well
        val height = page.height.toFloat()
        val width = page.width.toFloat()
        val scaleFactor = 1 + (MIN_SCALE - 1) * abs(position)
        val vertMargin = height * (1 - scaleFactor) / 2
        val horzMargin = width * (1 - scaleFactor) / 2

        // Center vertically
        page.pivotY = 0.5f * height
        page.pivotX = 0.5f * width

        if (isHorizontal(page)) {
            page.translationX = if (position < 0) horzMargin - vertMargin / 2 else -horzMargin + vertMargin / 2
        } else {
            page.translationY = if (position < 0) horzMargin - vertMargin / 2 else -horzMargin + vertMargin / 2
        }

        // Scale the page down (between MIN_SCALE and 1)
        page.scaleX = scaleFactor
        page.scaleY = scaleFactor
    }

    companion object {
        private const val MIN_SCALE = 0.9f
    }
}
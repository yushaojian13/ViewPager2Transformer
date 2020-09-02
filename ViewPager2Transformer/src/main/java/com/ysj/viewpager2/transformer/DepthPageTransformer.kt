package com.ysj.viewpager2.transformer

import android.view.View
import androidx.core.view.ViewCompat
import kotlin.math.abs

private const val MIN_SCALE = 0.75f

class DepthPageTransformer : ABaseTransformer() {

    override fun transformPage(view: View, position: Float) {
        view.apply {
            val pageWidth = width
            when {
                position < -1 -> { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    alpha = 0f
                }
                position <= 0 -> { // [-1,0]
                    // Use the default slide transition when moving to the left page
                    alpha = 1f
                    translationX = 0f
                    ViewCompat.setTranslationZ(view, 0f)
                    scaleX = 1f
                    scaleY = 1f
                }
                position <= 1 -> { // (0,1]
                    // Fade the page out.
                    alpha = 1 - position

                    // Counteract the default slide transition
                    if (isHorizontal(view)) {
                        translationX = pageWidth * -position
                    } else {
                        translationY = pageWidth * -position
                    }
                    // Move it behind the left page
                    ViewCompat.setTranslationZ(view, -1f)

                    // Scale the page down (between MIN_SCALE and 1)
                    val scaleFactor = (MIN_SCALE + (1 - MIN_SCALE) * (1 - abs(position)))
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                }
                else -> { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    alpha = 0f
                }
            }
        }
    }
}
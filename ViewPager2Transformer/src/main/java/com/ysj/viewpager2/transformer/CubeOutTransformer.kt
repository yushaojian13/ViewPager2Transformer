package com.ysj.viewpager2.transformer

import android.view.View

class CubeOutTransformer @JvmOverloads constructor(private val distanceMultiplier: Int = 20) : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        if (isHorizontal(page)) {
            page.cameraDistance = (page.width * distanceMultiplier).toFloat()
            page.pivotX = if (position < 0f) page.width.toFloat() else 0f
            page.pivotY = page.height * 0.5f
            page.rotationY = 90f * position
        } else {
            page.cameraDistance = (page.height * distanceMultiplier).toFloat()
            page.pivotX = page.width * 0.5f
            page.pivotY = if (position < 0f) page.height.toFloat() else 0f
            page.rotationX = -90f * position
        }
    }

}
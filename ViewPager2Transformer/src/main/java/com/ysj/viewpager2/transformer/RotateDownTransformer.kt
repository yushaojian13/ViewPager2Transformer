package com.ysj.viewpager2.transformer

import android.view.View

class RotateDownTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        val width = page.width.toFloat()
        val height = page.height.toFloat()
        val rotation = ROT_MOD * position

        if (isHorizontal(page)) {
            page.pivotX = width * 0.5f
            page.pivotY = height
        } else {
            page.pivotX = 0f
            page.pivotY = height * 0.5f
        }
        page.rotation = rotation
    }

    companion object {
        private const val ROT_MOD = 18.75f
    }

}
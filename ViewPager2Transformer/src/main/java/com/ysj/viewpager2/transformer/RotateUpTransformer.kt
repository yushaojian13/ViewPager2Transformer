package com.ysj.viewpager2.transformer

import android.view.View

class RotateUpTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        val width = page.width.toFloat()
        val rotation = ROT_MOD * position

        if (isHorizontal(page)) {
            page.pivotX = width * 0.5f
            page.pivotY = 0f
        } else {
            page.pivotX = width
            page.pivotY = page.height * 0.5f
        }
        page.rotation = rotation

    }

    companion object {
        private const val ROT_MOD = -15f
    }

}
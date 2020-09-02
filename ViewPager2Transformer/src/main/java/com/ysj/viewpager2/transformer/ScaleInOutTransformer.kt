package com.ysj.viewpager2.transformer

import android.view.View

class ScaleInOutTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        val scale = if (position < 0) 1f + position else 1f - position
        page.scaleX = scale
        page.scaleY = scale
        if (isHorizontal(page)) {
            page.pivotX = (if (position < 0) 0 else page.width).toFloat()
            page.pivotY = page.height / 2f
            page.translationX = -page.left.toFloat() // scrolling would change view position, so move it back
        } else {
            page.pivotX = page.width / 2f
            page.pivotY = (if (position < 0) 0 else page.height).toFloat()
            page.translationY = -page.top.toFloat() // scrolling would change view position, so move it back
        }
    }

}
package com.ysj.viewpager2.transformer

import android.view.View

class FlipHorizontalTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        if (!isHorizontal(page)) {
            return // vertical is not supported well
        }

        val rotation = 180f * position

        page.alpha = if (rotation > 90f || rotation < -90f) 0f else 1f
        page.pivotX = page.width * 0.5f
        page.pivotY = page.height * 0.5f
        page.rotationY = rotation
        page.translationX = -page.left.toFloat() // scrolling would change view position, so move it back

        // resolve problem: new page can't handle click event!
        page.visibility = if (position > -0.5f && position < 0.5f) View.VISIBLE else View.INVISIBLE
    }

}
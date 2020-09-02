package com.ysj.viewpager2.transformer

import android.view.View

class AccordionTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        if (isHorizontal(page)) {
            page.pivotX = if (position > 0) 0f else page.width.toFloat()
            page.scaleX = if (position < 0) 1f + position else 1f - position
        } else {
            page.pivotY = if (position > 0) 0f else page.height.toFloat()
            page.scaleY = if (position < 0) 1f + position else 1f - position
        }
    }

}
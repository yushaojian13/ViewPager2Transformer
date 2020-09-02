package com.ysj.viewpager2.transformer

import android.view.View

class StackInTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        if (isHorizontal(page)) {
            page.translationX = if (position > 0) 0f else -page.left.toFloat()
        } else {
            page.translationY = if (position > 0) 0f else -page.top.toFloat()
        }
    }

}
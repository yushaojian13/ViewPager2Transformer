package com.ysj.viewpager2.transformer

import android.view.View
import androidx.core.view.ViewCompat

class StackOutTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        if (isHorizontal(page)) {
            page.translationX = if (position <= 0f || position >= 1f) 0f else -page.left.toFloat()
        } else {
            page.translationY = if (position <= 0f || position >= 1f) 0f else -page.top.toFloat()
        }
        ViewCompat.setElevation(page, if (position <= 0f || position >= 1f) 1f else 0f)
    }

}
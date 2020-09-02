package com.ysj.viewpager2.transformer

import android.view.View
import androidx.core.view.ViewCompat

class DrawerTransformer : ABaseTransformer() {

    override fun transformPage(page: View, position: Float) {
        if (isHorizontal(page)) {
            page.translationX = if (position > 0 && position < 1) (-page.width / 2 * position) else 0f
        } else {
            page.translationY = if (position > 0 && position < 1) (-page.height / 2 * position) else 0f
        }
        ViewCompat.setElevation(page, if (position <= 0f) 1f else 0f)
    }

}
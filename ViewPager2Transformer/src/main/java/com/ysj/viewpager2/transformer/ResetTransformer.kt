package com.ysj.viewpager2.transformer

import android.view.View
import androidx.core.view.ViewCompat
import androidx.viewpager2.widget.ViewPager2

class ResetTransformer : ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.visibility = View.VISIBLE
        page.alpha = 1f
        page.rotationX = 0f
        page.rotationY = 0f
        page.rotation = 0f
        page.scaleX = 1f
        page.scaleY = 1f
        page.pivotX = page.width / 2f
        page.pivotY = page.height / 2f
        page.translationX = 0f
        page.translationY = 0f
        ViewCompat.setTranslationZ(page, 0f)
        ViewCompat.setElevation(page, 0f)
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
            val cameraDistance = (page.parent as View).cameraDistance
            page.cameraDistance = cameraDistance
        }
    }

}
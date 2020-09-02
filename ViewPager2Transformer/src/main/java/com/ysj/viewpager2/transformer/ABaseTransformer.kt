package com.ysj.viewpager2.transformer

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

abstract class ABaseTransformer : ViewPager2.PageTransformer {

    protected fun isHorizontal(page: View) = requireViewPager(page).orientation == ViewPager2.ORIENTATION_HORIZONTAL

    private fun requireViewPager(page: View): ViewPager2 {
        val parent = page.parent
        val parentParent = parent.parent
        if (parent is RecyclerView && parentParent is ViewPager2) {
            return parentParent
        }
        throw IllegalStateException(
            "Expected the page view to be managed by a ViewPager2 instance."
        )
    }
}
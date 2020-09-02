package com.ysj.viewpager2.transformer.sample

import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.ysj.viewpager2.transformer.*

/**
 * Populates a [Spinner] with a set of [ViewPager2.PageTransformer]s.
 * Propagates user selection to the [ViewPager2].
 */
class PageTransformerController(private val viewPager: ViewPager2, private val spinner: Spinner) {
    fun setUp() {
        val transformers = listOf(
                DefaultTransformer(),
                CarouselTransformer(),
                AccordionTransformer(),
                BackgroundToForegroundTransformer(),
                CubeOutTransformer(),
                DepthPageTransformer(),
                DrawerTransformer(),
                FlipHorizontalTransformer(),
                ForegroundToBackgroundTransformer(),
                RotateDownTransformer(),
                RotateUpTransformer(),
                ScaleInOutTransformer(),
                StackInTransformer(),
                StackOutTransformer(),
                ZoomInTransformer(),
                ZoomOutSlideTransformer(),
                ZoomOutTransformer()
        )

        spinner.adapter = ArrayAdapter(
                spinner.context, android.R.layout.simple_spinner_item,
                transformers.map { it.javaClass.simpleName }.toList()
        ).also {
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
            ) {
                val selected = transformers.first { it.javaClass.simpleName == parent.selectedItem }
                viewPager.setPageTransformer(CompositePageTransformer().also {
                    it.addTransformer(ResetTransformer())
                    it.addTransformer(selected)
                })
            }

            override fun onNothingSelected(adapterView: AdapterView<*>) {}
        }
    }
}
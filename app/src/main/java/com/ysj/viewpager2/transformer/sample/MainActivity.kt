package com.ysj.viewpager2.transformer.sample

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager.adapter = SimpleAdapter()

        findViewById<SeekBar>(R.id.padding_seek_bar).setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val recyclerView = viewPager.getChildAt(0) as RecyclerView
                val padding = progress.dpToPx
                if (viewPager.orientation == ViewPager2.ORIENTATION_HORIZONTAL) {
                    recyclerView.setPadding(padding, 0, padding, 0)
                } else {
                    recyclerView.setPadding(0, padding, 0, padding)
                }
                recyclerView.clipToPadding = false
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        OrientationController(viewPager, findViewById(R.id.orientation_spinner)).setUp()
        PageTransformerController(viewPager, findViewById(R.id.transformer_spinner)).setUp()
    }

    private class SimpleAdapter : RecyclerView.Adapter<ViewHolder>() {

        private val colors = listOf(Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN)

        override fun getItemCount() = colors.size

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val textView = TextView(parent.context)
            textView.gravity = Gravity.CENTER
            textView.setTextColor(Color.WHITE)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72f)
            textView.layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            return ViewHolder(textView)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val textView = holder.itemView as TextView
            textView.setBackgroundColor(colors[position])
            textView.text = (position + 1).toString()
        }

    }

    private class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val (Int).dpToPx: Int
        get() = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            this.toFloat(),
            resources.displayMetrics
        ).toInt()

}
package com.example.halzion.activities

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.halzion.R
import com.example.halzion.activities.LoginActivity
import com.example.halzion.adapter.SliderAdapter
import com.example.halzion.config.AppPrefs
import com.example.halzion.utils.hide
import com.example.halzion.utils.show

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var nextBtn: Button
    private lateinit var skipBtn: Button
    private lateinit var startBtn: Button
    private lateinit var slider: ViewPager
    private lateinit var dotsLayout: LinearLayout

    private lateinit var sliderAdapter: SliderAdapter
    private var dots: Array<TextView?>? = null
    private lateinit var layouts: Array<Int>
    private val sliderChangeListener = object : OnPageChangeListener {

        override fun onPageSelected(position: Int) {
            addBottomDots(position)

            if (position == layouts.size - 1) {
                nextBtn.hide()
                skipBtn.hide()
                startBtn.show()
            } else {
                nextBtn.show()
                skipBtn.show()
                startBtn.hide()
            }
        }

        override fun onPageScrollStateChanged(state: Int) {
        }

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        init()
        dataSet()
        interactions()
    }

    private fun init() {
        // Layouts of the three onBoarding Screens.
        layouts = arrayOf(
            R.layout.onboarding_slide1,
            R.layout.onboarding_slide2,
            R.layout.onboarding_slide3
        )

        sliderAdapter = SliderAdapter(this, layouts)

        // Initialize UI elements
        nextBtn = findViewById(R.id.nextBtn)
        skipBtn = findViewById(R.id.skipBtn)
        startBtn = findViewById(R.id.startBtn)
        slider = findViewById(R.id.slider)
        dotsLayout = findViewById(R.id.dotsLayout)
    }

    private fun dataSet() {
        addBottomDots(0)

        slider.apply {
            adapter = sliderAdapter
            addOnPageChangeListener(sliderChangeListener)
        }
    }

    private fun interactions() {
        skipBtn.setOnClickListener {
            navigateToLogin()
        }
        startBtn.setOnClickListener {
            navigateToLogin()
        }
        nextBtn.setOnClickListener {
            val current = getCurrentScreen(1)
            if (current < layouts.size) {
                slider.currentItem = current
            } else {
                navigateToLogin()
            }
        }
    }

    private fun navigateToLogin() {
        AppPrefs(this).setFirstTimeLaunch(false)
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun addBottomDots(currentPage: Int) {
        dots = arrayOfNulls(layouts.size)

        dotsLayout.removeAllViews()
        for (i in 0 until layouts.size) {
            dots!![i] = TextView(this)
            dots!![i]?.text = Html.fromHtml("&#8226;")
            dots!![i]?.textSize = 35f
            dots!![i]?.setTextColor(resources.getColor(R.color.colorGrey))
            dotsLayout.addView(dots!![i])
        }

        if (dots!!.isNotEmpty()) {
            dots!![currentPage]?.setTextColor(resources.getColor(R.color.colorIndigo))
        }
    }

    private fun getCurrentScreen(i: Int): Int = slider.currentItem + i
}

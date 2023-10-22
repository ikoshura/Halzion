package com.example.halzion.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.view.WindowCompat
import com.example.halzion.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        WindowCompat.setDecorFitsSystemWindows(
        window,
        false
        )

        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {
                startActivity(Intent(this@SplashActivity, OnBoardingActivity::class.java))
                finish()
            },
            2500
        )
        //val typeface: Typeface = Typeface.createFromAsset(assets, "BauhausRegular.ttf")
        //tvAppName.typeface = typeface
    }

}
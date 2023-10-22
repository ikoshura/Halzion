package com.example.halzion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.example.halzion.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        WindowCompat.setDecorFitsSystemWindows(
            window, false
        )

        val btn_back: com.example.halzion.utils.MSPButton = findViewById(R.id.btn_back)
        btn_back.setOnClickListener {

            onBackPressed()
        }

    }
}
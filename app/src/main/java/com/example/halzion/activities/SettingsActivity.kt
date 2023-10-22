package com.example.halzion.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.WindowCompat
import com.example.halzion.R

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        WindowCompat.setDecorFitsSystemWindows(
            window, false
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar_register_activity)
        setSupportActionBar(toolbar)

        // Aktifkan tombol "Back"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // Tindakan ketika tombol "Back" diklik, misalnya kembali ke aktivitas sebelumnya atau menutup aktivitas ini
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)

}
}
package com.example.halzion.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.core.view.WindowCompat
import com.example.halzion.R
import com.example.halzion.utils.MSPTextViewBold
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        WindowCompat.setDecorFitsSystemWindows(
            window, false
        )

        val tv_login: MSPTextViewBold = findViewById(R.id.tv_login)

        tv_login.setOnClickListener {
            // Launch the register screen when the user clicks on the text.
            onBackPressed()
        }

        val btn_submit: com.example.halzion.utils.MSPButton = findViewById(R.id.btn_submit)
        btn_submit.setOnClickListener {
            validateForgotDetails()
        }
    }

    private fun validateForgotDetails() {
        val et_email: com.example.halzion.utils.MSPEditText = findViewById(R.id.et_email)

        when {
            TextUtils.isEmpty(et_email.text.toString().trim { it <= ' ' }) -> {
                // Make sure showErrorSnackBar function is defined
                showErrorSnackBar(getString(R.string.err_msg_enter_email), true)
            }
            else -> {
                // Start LoginActivity
                onBackPressed()
            }
        }
    }
}

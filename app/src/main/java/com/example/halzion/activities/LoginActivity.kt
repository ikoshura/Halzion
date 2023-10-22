package com.example.halzion.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.halzion.R
import com.example.halzion.activities.RegisterActivity
import com.example.halzion.utils.MSPTextViewBold
import androidx.core.view.WindowCompat
import com.example.halzion.utils.MSPTextView
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        WindowCompat.setDecorFitsSystemWindows(
            window, false
        )

        val tv_register: MSPTextViewBold = findViewById(R.id.tv_register)
        val tv_forget_password: MSPTextView = findViewById(R.id.tv_forgot_password)


        tv_register.setOnClickListener {
            // Launch the register screen when the user clicks on the text.
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        tv_forget_password.setOnClickListener {
            // Launch the register screen when the user clicks on the text.
            val intent = Intent(this@LoginActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        val btn_login: com.example.halzion.utils.MSPButton = findViewById(R.id.btn_login)
        btn_login.setOnClickListener {

            validateLoginDetails()
        }
    }

    private fun validateLoginDetails(): Boolean {
        val et_email: com.example.halzion.utils.MSPEditText = findViewById(R.id.et_email)
        val et_password: com.example.halzion.utils.MSPEditText = findViewById(R.id.et_password)

        return when {
            TextUtils.isEmpty(et_email.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }

            TextUtils.isEmpty(et_password.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }
            else -> {
                // Start DashboardActivity
                val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                startActivity(intent)
                true
            }
        }
    }
}
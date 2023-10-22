package com.example.halzion.activities

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.MenuItem
import android.view.WindowManager
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.example.halzion.R
import com.example.halzion.utils.MSPTextViewBold

class RegisterActivity : BaseActivity() {

    /**
     * This function is auto created by Android when the Activity Class is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // This calls the parent constructor
        super.onCreate(savedInstanceState)
        // This is used to align the XML view to this class
        setContentView(R.layout.activity_register)

        val btn_register: com.example.halzion.utils.MSPButton = findViewById(R.id.btn_register)
        btn_register.setOnClickListener {

            validateRegisterDetails()
        }

        val tv_login: MSPTextViewBold = findViewById(R.id.tv_login)


        tv_login.setOnClickListener {
            // Launch the register screen when the user clicks on the text.
            onBackPressed()
        }
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

    // START
    /**
     * A function to validate the entries of a new user.
     */
    private fun validateRegisterDetails(): Boolean {

        val et_first_name: com.example.halzion.utils.MSPEditText = findViewById(R.id.et_first_name)
        val et_last_name: com.example.halzion.utils.MSPEditText = findViewById(R.id.et_last_name)
        val et_email: com.example.halzion.utils.MSPEditText = findViewById(R.id.et_email)
        val et_password: com.example.halzion.utils.MSPEditText = findViewById(R.id.et_password)
        val et_confirm_password: com.example.halzion.utils.MSPEditText = findViewById(R.id.et_confirm_password)
        val cb_terms_and_condition: androidx.appcompat.widget.AppCompatCheckBox = findViewById(R.id.cb_terms_and_condition)

        return when {
            TextUtils.isEmpty(et_first_name.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_first_name), true)
                false
            }

            TextUtils.isEmpty(et_last_name.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_last_name), true)
                false
            }

            TextUtils.isEmpty(et_email.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_email), true)
                false
            }

            TextUtils.isEmpty(et_password.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_password), true)
                false
            }

            TextUtils.isEmpty(et_confirm_password.text.toString().trim { it <= ' ' }) -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_enter_confirm_password), true)
                false
            }

            et_password.text.toString().trim { it <= ' ' } != et_confirm_password.text.toString()
                .trim { it <= ' ' } -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_password_and_confirm_password_mismatch), true)
                false
            }
            !cb_terms_and_condition.isChecked -> {
                showErrorSnackBar(resources.getString(R.string.err_msg_agree_terms_and_condition), true)
                false
            }
            else -> {
                true
            }
        }
    }
    // END
}
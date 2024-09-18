package com.shajib.mvppractice

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), LoginContract.View {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSignin: Button
    private lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEmail = findViewById(R.id.emailEditText)
        etPassword = findViewById(R.id.passwordEditText)
        btnSignin = findViewById(R.id.loginButton)

        loginPresenter = LoginPresenter(this)

        btnSignin.setOnClickListener {
            val emailOrUsername = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            loginPresenter.onLoginButtonClick(emailOrUsername, password)
        }
    }

    override fun showInvalidCredentialsError() {
        Toast.makeText(this, R.string.invalid_credentials_error, Toast.LENGTH_SHORT).show()
    }

    override fun showLoginSuccessMessage() {
        Toast.makeText(this, R.string.signin_success, Toast.LENGTH_SHORT).show()

        val intent = Intent(this@MainActivity, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}
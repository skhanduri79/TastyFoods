package com.example.sakshi.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sakshi.R
import com.example.sakshi.R.layout.activity_login

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNo: EditText
    lateinit var etPassword:EditText
    lateinit var btnLogin:Button
    lateinit var txtForgotPass:TextView
    lateinit var txtSignUp:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_login)

        title="Login"

        etMobileNo = findViewById(R.id.etMobileNo)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPass = findViewById(R.id.txtForgotPass)
        txtSignUp = findViewById(R.id.txtSignUp)

        btnLogin.setOnClickListener{
            startActivity(Intent(this@LoginActivity,
                MainActivity::class.java))
        }

        txtForgotPass.setOnClickListener {
            startActivity(Intent(this@LoginActivity,
                ForgotPassActivity::class.java))
        }

        txtSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity,
                RegisterActivity::class.java))
        }


    }


}
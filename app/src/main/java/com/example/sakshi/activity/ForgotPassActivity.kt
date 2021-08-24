package com.example.sakshi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sakshi.R

class ForgotPassActivity : AppCompatActivity() {

    lateinit var txtEnterDetails:TextView
    lateinit var etMobileNo:EditText
    lateinit var etEmailAdd:EditText
    lateinit var btnSubmit:Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pass)

        title="Forgot Password"

        txtEnterDetails=findViewById(R.id.txtEnterDetails)
        etMobileNo=findViewById(R.id.etMobileNo)
        etEmailAdd=findViewById(R.id.etEmailAdd)
        btnSubmit=findViewById(R.id.btnSubmit)
    }
}
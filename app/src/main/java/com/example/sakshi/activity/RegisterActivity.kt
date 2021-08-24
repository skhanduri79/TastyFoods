package com.example.sakshi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.sakshi.R

class RegisterActivity : AppCompatActivity() {

    lateinit var txtEnterDetails:TextView
    lateinit var etName:EditText
    lateinit var etMobileNo:EditText
    lateinit var etEmailAdd:EditText
    lateinit var etDeliveryAdd:EditText
    lateinit var btnSubmit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        title="Register"

        txtEnterDetails=findViewById(R.id.txtEnterDetails)
        etName=findViewById(R.id.etName)
        etMobileNo=findViewById(R.id.etMobileNo)
        etEmailAdd=findViewById(R.id.etEmailAdd)
        etDeliveryAdd=findViewById(R.id.etDeliveryAdd)
        btnSubmit=findViewById(R.id.btnSubmit)
    }
}
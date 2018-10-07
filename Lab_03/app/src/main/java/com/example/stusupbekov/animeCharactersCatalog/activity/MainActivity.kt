package com.example.stusupbekov.animeCharactersCatalog.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.stusupbekov.animeCharactersCatalog.R
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

        private val mAuth = FirebaseAuth.getInstance()!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginBtn = findViewById<View>(R.id.login_button) as Button
        val registerBtn = findViewById<View>(R.id.register_button) as Button

        loginBtn.setOnClickListener {
            login()
        }

        registerBtn.setOnClickListener {
            register()
        }

    }

    private fun login(){
        val emailField = findViewById<View>(R.id.email_fld) as EditText
        val passwordField = findViewById<View>(R.id.username_fld) as EditText

        val email = emailField.text.toString()
        val password = passwordField.text.toString()

        if(!email.isEmpty() && !password.isEmpty()){
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(this, MenuActivity::class.java))
                } else {
                    Toast.makeText(this, "Error :C", Toast.LENGTH_LONG).show()
                }
            }
        }else{
            Toast.makeText(this, "Please fill email and password fields! C:", Toast.LENGTH_LONG).show()
        }
    }

    private fun register(){
        startActivity(Intent(this, RegisterActivity::class.java))
    }
}

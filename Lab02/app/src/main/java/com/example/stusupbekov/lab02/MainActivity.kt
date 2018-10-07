package com.example.stusupbekov.lab02

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pressMeButton = findViewById<View>(R.id.button)
        val imageView = findViewById<ImageView>(R.id.imageView)
        pressMeButton.setOnClickListener {
            Toast.makeText(this, "GOTCHA!!!", Toast.LENGTH_LONG).show()
            imageView.setImageResource(R.drawable.gotcha)
            Handler().postDelayed({
                imageView.setImageResource(R.drawable.hey)
            }, 2000)
        }
    }
}

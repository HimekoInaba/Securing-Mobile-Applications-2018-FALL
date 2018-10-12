package com.example.stusupbekov.lab5

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*

@SuppressLint("Registered")
class MainActivity : AppCompatActivity() {
    private lateinit var resultField: TextView
    private lateinit var city: String
    private var timeZone = ""

    var time: CountDownTimer = object : CountDownTimer(1000000000, 1000) {
        override fun onFinish() {}

        @SuppressLint("SetTextI18n")
        override fun onTick(millisUntilFinished: Long) {
            val t = TimeZone.getTimeZone(timeZone)
            val c = Calendar.getInstance(t)
            resultField.text = "Current time in " + city + " is: " +
                    c.get(Calendar.HOUR_OF_DAY).toString() + ":" + c.get(Calendar.MINUTE) + ":" +
                    c.get(Calendar.SECOND)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultField = findViewById(R.id.resultField)

    }

    fun setTimeZone(view: View) {
        val button = view as Button
        city = button.text.toString()
        timeZone = CityTimezoneEnum.valueOf(city.toUpperCase()).timeZone
        time.cancel()
        time.start()
    }
}

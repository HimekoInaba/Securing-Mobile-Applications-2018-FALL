package com.example.stusupbekov.lab4

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var resultField: TextView
    private lateinit var numberField: EditText
    private lateinit var operationField: TextView
    private  var secondOperand: Double = 0.0
    private var firstOperation = "="

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultField = findViewById(R.id.resultField)
        numberField = findViewById(R.id.numberField)
        operationField = findViewById(R.id.operationField)
    }


    fun number(view: View) {
        val button = view as Button
        numberField.append(button.text)

        if (firstOperation == "=" && secondOperand == 0.0) secondOperand = 0.0
        if (firstOperation == "√" && numberField.text.isEmpty()) secondOperand = Math.abs(secondOperand)
    }

    fun operation(view: View) {
        val button = view as Button
        val op = button.text.toString()
        val number = numberField.text.toString()
        if (number.isNotEmpty()) {
            performOperation(number.toDouble())
            numberField.setText("")
        }
        firstOperation = op
        operationField.text = firstOperation
    }

    @SuppressLint("SetTextI18n")
    private fun performOperation(number: Double) {

        when (firstOperation) {
            "=" -> secondOperand = number
            "/" -> secondOperand = if (number == 0.0) 0.0 else number.let { secondOperand.div(it) }

            "*" -> secondOperand *= number
            "+" -> secondOperand += number
            "-" -> secondOperand -= number
            "√" -> {
                secondOperand = if (number != 0.0 ) Math.pow(number, 1/resultField.text.toString().toDouble()) else Math.sqrt(number)
                resultField.text = ""
                numberField.setText("")
                operationField.text = ""
            }
            "C" -> {
                resultField.text = ""
                numberField.setText("")
                operationField.text = ""
            }
            "x^y" -> secondOperand = Math.pow(java.lang.Double.valueOf(resultField.text.toString()), number)
        }

        resultField.text = secondOperand.toString()
        numberField.setText("")
    }
}



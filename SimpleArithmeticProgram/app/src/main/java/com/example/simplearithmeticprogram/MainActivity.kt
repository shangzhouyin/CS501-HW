package com.example.simplearithmeticprogram

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var simpleCal: TextView
    lateinit var editNumber1: EditText
    lateinit var editNumber2: EditText
    lateinit var add: RadioButton
    lateinit var sub: RadioButton
    lateinit var mul: RadioButton
    lateinit var div: RadioButton
    lateinit var mod: RadioButton
    lateinit var OutputButton:Button
    lateinit var out:TextView
    lateinit var notes:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        simpleCal = findViewById(R.id.simCal)
        editNumber1 = findViewById(R.id.number1)
        editNumber2 = findViewById(R.id.number2)
        add = findViewById(R.id.addition)
        sub = findViewById(R.id.subtraction)
        mul = findViewById(R.id.multiplication)
        div = findViewById(R.id.division)
        mod = findViewById(R.id.modulus)
        OutputButton = findViewById(R.id.calculateButton)
        out = findViewById(R.id.output)
        notes = findViewById(R.id.note)

        OutputButton.setOnClickListener{
            val number1 = editNumber1.text.toString().toDouble()
            val number2 = editNumber2.text.toString().toDouble()

            val selectedOperation = when{
                add.isChecked ->"Addition"
                sub.isChecked -> "Subtraction"
                mul.isChecked -> "Multiplication"
                div.isChecked -> "Division"
                mod.isChecked -> "Modulus"
                else -> ""
            }
            when (selectedOperation){
                "Addition" -> addition(number1, number2)
                "Subtraction" -> subtraction(number1, number2)
                "Multiplication" -> multiplication(number1, number2)
                "Division" -> division(number1, number2)
                "Modulus" -> modulus(number1, number2)
                else -> notes.text = "Select an option"
            }
        }

    }

    //addition function
    private fun addition(num1:Double, num2: Double){
        val result = num1 + num2
        out.text = result.toString()
    }

    //subtraction function
    private fun subtraction(num1: Double, num2: Double){
        val result = num1 - num2
        out.text = result.toString()
    }

    //multiplication function
    private fun multiplication(num1: Double, num2: Double){
        val result = num1 * num2
        out.text = result.toString()
    }

    //division function
    private fun division(num1: Double, num2: Double) {
        try{
            if (num2 == 0.0) {
                notes.text = "Denominator cannot be zero"
                out.text = ""
            } else {
                val result = num1 / num2
                val decimalFormat = DecimalFormat("#.######")
                out.text = decimalFormat.format(result).toString()
            }
        }catch(e:ArithmeticException){
            notes.text = "Error"
        }

    }

    //modulus function
    private fun modulus(num1: Double, num2: Double) {
        val result = num1 % num2
        out.text = result.toString()
    }

}
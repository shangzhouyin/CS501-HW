package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener{view: View ->
            val mySnackbar1 = Snackbar.make(view,R.string.Correct_snackBar, Snackbar.LENGTH_LONG)
            mySnackbar1.setDuration(20)
            mySnackbar1.show()
        }
        falseButton.setOnClickListener {view: View->
            val mySnackbar2 = Snackbar.make(view,R.string.Incorrect_snackBar, Snackbar.LENGTH_LONG)
            mySnackbar2.setDuration(20)
            mySnackbar2.show()
        }
    }
}
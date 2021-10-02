package com.example.task1anagramsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val presenter = ReversePresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //get views
        val userInputEditText: EditText? = findViewById(R.id.wordEditText)
        val charactersToEscapeEditText: EditText? = findViewById(R.id.wordEditTextEscapechars)
        val displayTextView: TextView? = findViewById(R.id.displayTextView)
        val convertButton: Button = findViewById(R.id.convertButton)

        convertButton.setOnClickListener {
            val userInputString = userInputEditText?.text.toString()
            val charactersToEscapeString = charactersToEscapeEditText?.text.toString()
            onConvertButtonClick(userInputString, charactersToEscapeString, displayTextView)
        }
    }

    private fun onConvertButtonClick(input1: String, input2: String, displayText: TextView?) {
        if (input1.isNotEmpty() || input2.isNotEmpty()) {
            displayText?.text = presenter.reverse(input1, input2)
        } else {
            displayText?.text = getString(R.string.invalid_input)

        }
    }
}
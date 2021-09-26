package com.example.task1anagramsapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //get views
        val userInput: EditText? = findViewById(R.id.wordEditText)
        val displayText: TextView? = findViewById(R.id.displayTextView)
        val convertButton: Button = findViewById(R.id.convertButton)


        convertButton.setOnClickListener {
            val ans = userInput?.text.toString()
            if (!ans.isEmpty()) {
                displayText?.text = reverse(ans)
            } else {
                //I was able to get string without resources or context?
                displayText?.text = getString(R.string.invalid_input)
            }
        }
    }

    fun reverse(string: String): String {
        // convert to char array
        val str = string.toCharArray()
        // Initialize left and right travs
        var right = str.size - 1
        var left = 0

        // Traverse string from both ends until
        // 'l' and 'r'
        while (left < right) {
            // Ignore special characters
            if (!Character.isAlphabetic(str[left].toInt()))
                left++
            else if (!Character.isAlphabetic(str[right].toInt()))
                right--
            else {
                val tmp = str[left]
                str[left] = str[right]
                str[right] = tmp
                left++
                right--
            }
        }
        return String(str)
    }

}
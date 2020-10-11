package com.andrukh.lab1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(view: View) {
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)
        // Get the current value of the text view.
        val passedMessage = edit_message.text.toString()

        // Then the text received from the text field is passed to the activity being started
        randomIntent.putExtra(SecondActivity.PASSED_MESSAGE, passedMessage)
        // Start the new activity.
        startActivity(randomIntent)
    }
}
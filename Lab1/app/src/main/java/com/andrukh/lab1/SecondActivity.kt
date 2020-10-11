package com.andrukh.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        showText()
    }

    companion object {
        const val PASSED_MESSAGE = "passed_message"
    }
    
    private fun showText() {
        val passedMessage = intent.getStringExtra(PASSED_MESSAGE);
        val cm=Integer.parseInt(passedMessage);
        val cubicMetr = cm * 1000000;
        textView.text = "" + cm + " метрів кубічних це " + cubicMetr + " сантиметрів кубічних";
    }
}
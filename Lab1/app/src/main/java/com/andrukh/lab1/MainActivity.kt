package com.andrukh.lab1

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.mainpage.*
import kotlinx.android.synthetic.main.mybooking.textView36
import kotlinx.android.synthetic.main.mybooking.*
import kotlinx.android.synthetic.main.second_layout.*
import kotlinx.android.synthetic.main.showbooking.textView32
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    var date="";
    var global_time="";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainpage)
        button2.setOnLongClickListener{
            Toast.makeText(this, "Long click detected", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }
    }

    fun showImg(view: View) {
        img_star.setScaleX(1F);
        img_star.setScaleY(1F);
    }

    fun showText(view: View) {
        header.setText("hover on img")
    }
    fun show_booking_page(view: View) {
        setContentView(R.layout.second_layout)
        val formate = SimpleDateFormat("dd MMM, YYYY", Locale.US)

        button6.setOnClickListener {
            val now = Calendar.getInstance()

            val datePicker = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(Calendar.YEAR, i)
                    selectedDate.set(Calendar.MONTH, i2)
                    selectedDate.set(Calendar.DAY_OF_MONTH, i3)
                     date = formate.format(selectedDate.time)
                    Toast.makeText(
                        this,
                        "SALE is active to\nYear : " + i + "\nMonth: " + i2 + "\nDate: " + i3,
                        Toast.LENGTH_SHORT
                    ).show()
                },
                now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()
        }
    }
    fun showbook(view: View){

       val time = editTextTime.text;
        val isCheck = checkBox.isChecked();
        val a = " Година :" + time + "\n Чек:" + isCheck + "\n Дата:  " + date;
        global_time = "" + editTextTime.text;
        setContentView(R.layout.showbooking)
        textView32.text = "";
        textView32.text = a

    }
    fun chooseDate(view: View){

    }
    fun gomain(view: View) {
        setContentView(R.layout.mainpage)

    }

    fun show_my_booking(view: View) {
        setContentView(R.layout.mybooking)
        var doubleClick: Boolean? = false
        button3.setOnClickListener {
            if (doubleClick!!) {
                Toast.makeText(
                    this,
                    "double click",
                    Toast.LENGTH_SHORT
                ).show()
            }
            doubleClick = true
            Handler().postDelayed({ doubleClick = false }, 2000)
        }
        textView36.setText(date + "   ")
        textView4.setText(global_time)
    }

        fun onButtonClick(view: View) {
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)
        // Get the current value of the text view.
        val passedMessage = "sasha"

        // Then the text received from the text field is passed to the activity being started
        randomIntent.putExtra(SecondActivity.PASSED_MESSAGE, passedMessage)
        // Start the new activity.
        startActivity(randomIntent)
    }
}
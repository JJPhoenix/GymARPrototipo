package com.bignerdranch.android.gymarprototipo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.bignerdranch.android.gymarprototipo.R
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var pruebaButton: Button
    private lateinit var mainDate: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pruebaButton = findViewById(R.id.exercise)

        pruebaButton.setOnClickListener{
            val intent = Intent(this,
                TrainerActivity::class.java)
            startActivity(intent)
        }

        mainDate = findViewById(R.id.main_date)
        val simpleDateFormat = SimpleDateFormat("EEE, dd MMM")
        val currentDateAndTime: String = simpleDateFormat.format(Date()).toUpperCase()
        mainDate.text = currentDateAndTime
    }
}
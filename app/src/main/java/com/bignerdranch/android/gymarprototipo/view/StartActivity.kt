package com.bignerdranch.android.gymarprototipo.view

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bignerdranch.android.gymarprototipo.R

class StartActivity:AppCompatActivity() {
    private lateinit var startButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        startButton = findViewById(R.id.get_started)

        startButton.setOnClickListener {
            Toast.makeText(this,R.string.test_screen, Toast.LENGTH_SHORT).show()
        }
    }
}
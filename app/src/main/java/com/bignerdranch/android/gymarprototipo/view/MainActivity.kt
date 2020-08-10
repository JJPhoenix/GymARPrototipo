package com.bignerdranch.android.gymarprototipo.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.bignerdranch.android.gymarprototipo.R

class MainActivity : AppCompatActivity() {

    private lateinit var pruebaButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pruebaButton = findViewById(R.id.exercise)

        pruebaButton.setOnClickListener{
            val intent = Intent(this,
                prueba_ra::class.java)
            startActivity(intent)
        }
    }
}
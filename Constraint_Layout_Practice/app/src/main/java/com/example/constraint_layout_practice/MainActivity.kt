package com.example.constraint_layout_practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView : TextView
    lateinit var Button8 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        Button8 = findViewById(R.id.clickButton)

        Button8.setOnClickListener {
            textView.text = "Press the button please"
        }
    }
}
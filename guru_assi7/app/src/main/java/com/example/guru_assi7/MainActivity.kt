package com.example.guru_assi7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textView1 : TextView
    lateinit var button1 : Button
    public final lateinit var editText1: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView1 = findViewById(R.id.textView1)
        button1 = findViewById<Button>(R.id.button1)
        editText1 = findViewById(R.id.editText1)

        button1.setOnClickListener {
            textView1.setText(editText1.getText().toString());
        }
    }
}
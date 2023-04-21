package com.example.radio_group_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.RadioGroup
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var radioGroup : RadioGroup
    lateinit var radioApple : RadioGroup
    lateinit var radioBanana : RadioGroup
    lateinit var radioOrange : RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.radioGroup)
        radioApple = findViewById(R.id.radioApple)
        radioBanana = findViewById(R.id.radioBanana)
        radioOrange = findViewById(R.id.radioOrange)

        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId)
            {
                R.id.radioApple -> Toast.makeText(applicationContext, "사과",Toast.LENGTH_SHORT).show()
                R.id.radioOrange -> Toast.makeText(applicationContext, "오렌지",Toast.LENGTH_SHORT).show()
                R.id.radioBanana -> Toast.makeText(applicationContext, "바나나",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
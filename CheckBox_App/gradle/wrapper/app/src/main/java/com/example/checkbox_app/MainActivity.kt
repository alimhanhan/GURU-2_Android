package com.example.checkbox_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var checkApple : CheckBox
    lateinit var checkOrange : CheckBox
    lateinit var checkBanana : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkApple=findViewById(R.id.checkApple)
        checkOrange=findViewById(R.id.checkOrange)
        checkBanana=findViewById(R.id.checkBanana)

        var listener = CompoundButton.OnCheckedChangeListener {buttonView, isChecked ->
            if(isChecked)
            {
                when(buttonView.id)
                {
                    R.id.checkApple -> Toast.makeText(applicationContext, "사과", Toast.LENGTH_SHORT).show()
                    R.id.checkOrange -> Toast.makeText(applicationContext, "오렌지", Toast.LENGTH_SHORT).show()
                    R.id.checkBanana -> Toast.makeText(applicationContext, "바나나", Toast.LENGTH_SHORT).show()
                }
            }
        }

        checkApple.setOnCheckedChangeListener(listener)
        checkOrange.setOnCheckedChangeListener(listener)
        checkBanana.setOnCheckedChangeListener(listener)
    }
}
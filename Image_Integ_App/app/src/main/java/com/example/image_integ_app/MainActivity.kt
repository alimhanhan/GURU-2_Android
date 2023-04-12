package com.example.image_integ_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Audio.Radio
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var text1 : TextView
    lateinit var text2 : TextView
    lateinit var chkAgree : CheckBox
    lateinit var rGroup1 : RadioGroup
    lateinit var rdoRice : RadioButton
    lateinit var rdoMeat : RadioButton
    lateinit var rdoPizza : RadioButton
    lateinit var btnOK : Button
    lateinit var imgFood : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title ="음식 사진 보기"
        text1 = findViewById(R.id.Text1)
        chkAgree = findViewById(R.id.ChkAgree)

        text2 = findViewById(R.id.Text2)
        rGroup1 = findViewById(R.id.Rgroup1)
        rdoMeat = findViewById(R.id.RdoMeat)
        rdoPizza = findViewById(R.id.RdoPizza)
        rdoRice = findViewById(R.id.RdoRice)

        btnOK = findViewById(R.id.BtnOK)
        imgFood = findViewById(R.id.ImgFood)

        chkAgree.setOnCheckedChangeListener { buttonView, isChecked ->
            if (chkAgree.isChecked == true) {
                text2.visibility = android.view.View.VISIBLE
                rGroup1.visibility = android.view.View.VISIBLE
                btnOK.visibility = android.view.View.VISIBLE
                imgFood.visibility = android.view.View.VISIBLE
            } else {
                text2.visibility = android.view.View.INVISIBLE
                rGroup1.visibility = android.view.View.INVISIBLE
                btnOK.visibility = android.view.View.INVISIBLE
                imgFood.visibility = android.view.View.INVISIBLE
            }
        }
        btnOK.setOnClickListener {
            when(rGroup1.checkedRadioButtonId)
            {
                R.id.RdoRice -> imgFood.setImageResource(R.drawable.rice)
                R.id.RdoMeat -> imgFood.setImageResource(R.drawable.meat)
                R.id.RdoPizza -> imgFood.setImageResource(R.drawable.pizza)
                else -> Toast.makeText(applicationContext, "음식을 먼저 선택하시오.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
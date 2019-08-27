package com.example.bmi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result_activity.*
import org.jetbrains.anko.toast

class result_activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_activity)

        val height = intent.getStringExtra("height").toDouble()
        val weight = intent.getStringExtra("weight").toDouble()
        val bmi = weight / Math.pow(height/100.0 , 2.0)
        when{
            bmi >= 35 -> resultTextView.text = "고도비만"
            bmi >= 30 -> resultTextView.text = "2도 비만"
            bmi >= 25 -> resultTextView.text = "1도 비만"
            bmi >= 23 -> resultTextView.text = "과체중"
            bmi >= 18.5 -> resultTextView.text = "정상"
            else -> resultTextView.text = "저체중"
        }
        toast("${bmi}")
    }
}

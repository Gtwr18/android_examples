package com.example.bmi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultButton.setOnClickListener{
            val weight:String? = weightEditText.text.toString()
            val height:String? = heightEditText.text.toString()
            if(weight==""||height==""){
                Toast.makeText(this,"값을 입력하세요!", Toast.LENGTH_LONG).show()
            }else {
                startActivity<result_activity>(
                    "weight" to weightEditText.text.toString(),
                    "height" to heightEditText.text.toString()
                )
            }
        }
    }
}

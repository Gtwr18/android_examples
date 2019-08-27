package com.example.lifecycleexam

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var level:Int = 0
    var score:Int = 0
//    fun setNumberInText(level:Int,score: Int){
//        this.level = level
//        this.score = score
//        level_text.setText("레벨 : ${level}")
//        score_text.setText("레벨 : ${score}")
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if(savedInstanceState ==null){
//
//        }else{
//
//        }
        levelUpBtn.setOnClickListener{
            level++
            level_text.setText("레벨 : ${level}")
        }
        scoreUpBtn.setOnClickListener{
            score++
            score_text.setText("레벨 : ${score}")
        }
        resetBtn.setOnClickListener{
            level=0
            score=0
            level_text.setText("레벨 : ${level}")
            score_text.setText("레벨 : ${score}")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("playerLevel",level)
        outState.putInt("playerScore",score)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        level = savedInstanceState.getInt("playerLevel")
        score = savedInstanceState.getInt("playerScore")
        level_text.setText("레벨 : ${level}")
        score_text.setText("레벨 : ${score}")
    }
}

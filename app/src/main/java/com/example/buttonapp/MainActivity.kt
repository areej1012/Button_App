package com.example.buttonapp

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var tvNumber: TextView
    lateinit var btPluse: Button
    lateinit var btMinus: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNumber = findViewById(R.id.tvNumber)
        btPluse = findViewById(R.id.btPluse)
        btMinus = findViewById(R.id.bnMinus)

        btPluse.setOnClickListener {
            sum()
        }

        btMinus.setOnClickListener {
            minus()
        }
    }

    fun sum() {
        var num = Integer.parseInt(tvNumber.text.toString())
        num++
        ChangeColorPostion(num)
    }

    fun minus() {
        var num = Integer.parseInt(tvNumber.text.toString())
        num--
        ChangeColorPostion(num)
    }

    fun ChangeColorPostion(num: Int) {
        if (num > 0) {
            tvNumber.setTextColor(Color.GREEN)
        } else if (num < 0) {
            tvNumber.setTextColor(Color.RED)
        } else {
            tvNumber.setTextColor(Color.BLACK)
        }
        tvNumber.text = num.toString()
        tvNumber.setY(num.toFloat())
    }
}
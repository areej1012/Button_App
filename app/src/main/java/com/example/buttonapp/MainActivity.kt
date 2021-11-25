package com.example.buttonapp

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var tvNumber: TextView
    lateinit var btPluse: Button
    lateinit var btMinus: Button
    lateinit var lymain : ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNumber = findViewById(R.id.tvNumber)
        btPluse = findViewById(R.id.btPluse)
        btMinus = findViewById(R.id.bnMinus)
        lymain = findViewById(R.id.lyMain)

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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.name -> {
                Snackbar.make(lymain, "Your name is Areej",Snackbar.LENGTH_LONG).show()
                return true
            }
            R.id.use -> {
                Snackbar.make(lymain, "Clicked on the buttons to add or minus the number",Snackbar.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
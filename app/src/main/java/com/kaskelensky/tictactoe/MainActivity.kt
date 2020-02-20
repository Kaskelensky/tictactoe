package com.kaskelensky.tictactoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val easyBtn = findViewById<ImageButton>(R.id.easyBtn)
        val normalBtn = findViewById<ImageButton>(R.id.normalBtn)
        val hardBtn = findViewById<ImageButton>(R.id.hardBtn)
        val wfBtn = findViewById<ImageButton>(R.id.wfBtn)

        easyBtn?.setOnClickListener() {
            startGame()
        }
        normalBtn?.setOnClickListener() {
            startGame()
        }
        hardBtn?.setOnClickListener() {
            startGame()
        }
        wfBtn?.setOnClickListener() {
            startGame()
        }
    }

    private fun startGame() {
        //get id from API
        val intent = Intent(this, GamePlace::class.java)
        startActivity(intent)
    }
}

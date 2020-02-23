package com.kaskelensky.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class Easy : AppCompatActivity() {

    var roundCount = 0

    var player1Turn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy)

        for (i in 0..2) {
            for (j in 0..2) {
                val buttonID = "b$i$j"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                val btn = findViewById<Button>(resID)
                btn.setOnClickListener(this::onClick)
            }
        }
    }

    fun onClick(v: View) {
        if ((v as Button).text.toString() != "") {
            return
        }
        if (player1Turn) {
            v.text = "X"
            roundCount++
        }

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins()
            } else {
                player2Wins()
            }
        } else if (roundCount == 9) {
            draw()
        }

        player1Turn = !player1Turn

        if (!player1Turn) {
            autoPlay()
        }

        if (checkForWin()) {
            if (player1Turn) {
                player1Wins()
            } else {
                player2Wins()
            }
        } else if (roundCount == 9) {
            draw()
        }
        player1Turn = !player1Turn
    }

    fun resetBoard() {
        roundCount = 0
        for (i in 0..2) {
            for (j in 0..2) {
                val buttonID = "b$i$j"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                val btn = findViewById<Button>(resID)
                btn.text = ""
            }
        }
    }

    fun checkForWin(): Boolean {
        val field =
            Array(3) { arrayOfNulls<String>(3) }
        for (i in 0..2) {
            for (j in 0..2) {
                val buttonID = "b$i$j"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                val btn = findViewById<Button>(resID)
                field[i][j] = btn.text.toString()
            }
        }
        for (i in 0..2) {
            if (field[i][0] == field[i][1] && field[i][0] == field[i][2] && field[i][0] != "") {
                return true
            }
        }
        for (i in 0..2) {
            if (field[0][i] == field[1][i] && field[0][i] == field[2][i] && field[0][i] != "") {
                return true
            }
        }
        if (field[0][0] == field[1][1] && field[0][0] == field[2][2] && field[0][0] != "") {
            return true
        }
        if (field[0][2] == field[1][1] && field[0][2] == field[2][0] && field[0][2] != "") {
            return true
        }
        return false
    }

    fun player1Wins() {
        Toast.makeText(this, "You wins!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    fun player2Wins() {
        Toast.makeText(this, "Computer wins!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    fun draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    fun autoPlay() {

        val emptyButtons = ArrayList<Button>()

        for (i in 0..2) {
            for (j in 0..2) {
                val buttonID = "b$i$j"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                val btn = findViewById<Button>(resID)
                if (btn.text == "") {
                    emptyButtons.add(btn)
                }
            }
        }

        if (emptyButtons.size > 0 || emptyButtons.size == 9) {

            Collections.shuffle(emptyButtons);

            emptyButtons.get(0).text = "O"

            roundCount++
        }
    }

}

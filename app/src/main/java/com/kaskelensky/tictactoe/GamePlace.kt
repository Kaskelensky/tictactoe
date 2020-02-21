package com.kaskelensky.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GamePlace : AppCompatActivity() {

    var player1Turn = true
    val roundCount = 0

    val b00 = findViewById<Button>(R.id.b00)
    val b01 = findViewById<Button>(R.id.b01)
    val b02 = findViewById<Button>(R.id.b02)

    val b10 = findViewById<Button>(R.id.b10)
    val b11 = findViewById<Button>(R.id.b11)
    val b12 = findViewById<Button>(R.id.b12)

    val b20 = findViewById<Button>(R.id.b20)
    val b21 = findViewById<Button>(R.id.b21)
    val b22 = findViewById<Button>(R.id.b22)

    val buttonArray = arrayOf(
        arrayOf(b00, b01, b02),
        arrayOf(b10, b11, b12),
        arrayOf(b20, b21, b22)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_place)



    }

    fun onClick(v: View) {
        if ((v as Button).text.toString() != "") {
            return
        }
        if (player1Turn) {
            v.text = "X"
        } else {
            v.text = "O"
        }
        val roundCount = roundCount + 1
        if (checkForWin()) {
            if (player1Turn) {
                player1Wins()
            } else {
                player2Wins()
            }
        } else if (roundCount == 9) {
            draw()
        } else {
            player1Turn = !player1Turn
        }
    }

    fun isPressed(btn: Button) : Boolean {
        if (btn.text.toString() != "") {
            return false
        }
        return true
    }

    fun resetBoard() {
        for (i in 0..2) {
            for (j in 0..2) {
                buttonArray[i][j].text = ""
            }
        }
    }

    fun checkForWin(): Boolean {
        val field =
            Array(3) { arrayOfNulls<String>(3) }
        for (i in 0..2) {
            for (j in 0..2) {
                field[i][j] = buttonArray.get(i).get(j).text.toString()
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
        Toast.makeText(this, "O wins!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    fun player2Wins() {
        Toast.makeText(this, "X wins!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    fun draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

}

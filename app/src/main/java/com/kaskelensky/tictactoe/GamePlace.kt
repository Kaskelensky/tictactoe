package com.kaskelensky.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game_place.*

class GamePlace : AppCompatActivity() {

    var player1Turn = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_place)

        val roundCount = 0

        ///dfdfdf

        b00.setOnClickListener {
            if (b00.text.toString() != "") {
                return@setOnClickListener
            }
            if (player1Turn) {
                b00.text = "X"
            } else {
                b00.text = "O"
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

        b01.setOnClickListener {
            if (b01.text.toString() != "") {
                return@setOnClickListener
            }
            if (player1Turn) {
                b01.text = "X"
            } else {
                b01.text = "O"
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

        b02.setOnClickListener {
            if (b02.text.toString() != "") {
                return@setOnClickListener
            }
            if (player1Turn) {
                b02.text = "X"
            } else {
                b02.text = "O"
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

        b10.setOnClickListener {
            if (b10.text.toString() != "") {
                return@setOnClickListener
            }
            if (player1Turn) {
                b10.text = "X"
            } else {
                b10.text = "O"
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

        b11.setOnClickListener {
            if (b11.text.toString() != "") {
                return@setOnClickListener
            }
            if (player1Turn) {
                b11.text = "X"
            } else {
                b11.text = "O"
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

        b12.setOnClickListener {
            if (b12.text.toString() != "") {
                return@setOnClickListener
            }
            if (player1Turn) {
                b12.text = "X"
            } else {
                b12.text = "O"
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

        b20.setOnClickListener {
            if (b20.text.toString() != "") {
                return@setOnClickListener
            }
            if (player1Turn) {
                b20.text = "X"
            } else {
                b20.text = "O"
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

        b21.setOnClickListener {
            if (b21.text.toString() != "") {
                return@setOnClickListener
            }
            if (player1Turn) {
                b21.text = "X"
            } else {
                b21.text = "O"
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

        b22.setOnClickListener {
            if (b22.text.toString() != "") {
                return@setOnClickListener
            }
            if (player1Turn) {
                b22.text = "X"
            } else {
                b22.text = "O"
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
        Toast.makeText(this, "X wins!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    fun player2Wins() {
        Toast.makeText(this, "O wins!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

    fun draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show()
        resetBoard()
    }

}

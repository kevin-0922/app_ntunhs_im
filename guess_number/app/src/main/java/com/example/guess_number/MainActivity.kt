package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.util.*
import android.os.Handler
import android.os.Looper
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    private var big_num = 100
    private var small_num = 0
    private var secret = Random().nextInt(100) + 1

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler(Looper.getMainLooper())

        val textView: TextView = findViewById(R.id.textView)
        val guessButton: Button = findViewById(R.id.guess_button)
        val resetButton: Button = findViewById(R.id.reset_button)
        val editText: EditText = findViewById(R.id.editText)

        guessButton.setOnClickListener {
            val input = editText.text.toString()
            val gs = input.toIntOrNull() ?: 0

            if (gs == 0) {
                textView.text = getString(R.string.please_enter_a_number)
                findViewById<EditText>(R.id.editText).text.clear()
                return@setOnClickListener
            }

            val validateNum = gs - secret
            var ansStr: String

            when {
                validateNum == 0 -> {
                    ansStr = getString(R.string.correct)
                    textView.text = ansStr
                    handler.postDelayed({
                        Toast.makeText(this, getString(R.string.reset_game_mention), Toast.LENGTH_SHORT).show()
                    }, 6000)
                    resetGame()
                }
                validateNum > 0 -> {
                    big_num = Math.min(gs, big_num)
                    ansStr = getString(R.string.too_big_range, small_num.toString(), big_num.toString())
                    textView.text = ansStr
                }
                validateNum < 0 -> {
                    small_num = Math.max(gs, small_num)
                    ansStr = getString(R.string.too_small_range, small_num.toString(), big_num.toString())
                    textView.text = ansStr
                }
            }
        }

        resetButton.setOnClickListener {
            resetGame()
        }
    }

    private fun resetGame() {
        secret = Random().nextInt(100) + 1
        big_num = 100
        small_num = 0
        findViewById<TextView>(R.id.textView).text = getString(R.string.let_us_guess_again)
        findViewById<EditText>(R.id.editText).text.clear()
    }
}
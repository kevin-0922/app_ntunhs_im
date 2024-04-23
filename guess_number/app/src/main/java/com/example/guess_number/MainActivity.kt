package com.example.guess_number

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.guess_number.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val game = GuessNumberGame()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.guessButton.setOnClickListener {
            val input = binding.editText.text.toString()
            val result = game.guess(input)
            binding.textView.text = result
            if (result == getString(R.string.correct)) {
                Toast.makeText(this, getString(R.string.reset_game_mention), Toast.LENGTH_SHORT).show()
                game.reset()
                binding.textView.text = getString(R.string.let_us_guess_again)
            }
        }

        binding.resetButton.setOnClickListener {
            game.reset()
            binding.textView.text = getString(R.string.let_us_guess_again)
            binding.editText.text.clear()
        }
    }
}

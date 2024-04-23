package com.example.guess_number

import java.util.*

class GuessNumberGame {
    private var secret = Random().nextInt(100) + 1
    private var bigNum = 100
    private var smallNum = 0

    fun guess(input: String): String {
        val guess = input.toIntOrNull() ?: return "Please enter a number"
        return when {
            guess == secret -> "Correct"
            guess > secret -> {
                bigNum = Math.min(guess, bigNum)
                "Too big! Range: $smallNum to $bigNum"
            }
            else -> {
                smallNum = Math.max(guess, smallNum)
                "Too small! Range: $smallNum to $bigNum"
            }
        }
    }

    fun reset() {
        secret = Random().nextInt(100) + 1
        bigNum = 100
        smallNum = 0
    }
}

package com.example.mathwithfinik.plus_minus_screen

import androidx.navigation.findNavController
import com.example.mathwithfinik.BaseViewModel
import com.example.mathwithfinik.Constants
import com.example.mathwithfinik.R
import com.example.mathwithfinik.databinding.ExerciseFragmentBinding
import com.example.mathwithfinik.models.MathProblemModel
import kotlin.random.Random

class PlusMinusViewModel(override val binding: ExerciseFragmentBinding) : BaseViewModel(binding) {

    private var firstValue = 0
    private var secondValue = 0
    private var answer = 0
    private val wrongAnswers = ArrayList<Number>()
    private var max = 0
    private var level: String? = null

    override fun makeMathProblemModel(
        level: String?
    ): MathProblemModel {
        if (this.level == null) {
            this.level = level
        }
        if (level.equals(Constants.HARD_CHAR)) {
            binding.exercise.apply {
                firstValue.textSize = 60F
                secondValue.textSize = 60F
                symbol.textSize = 60F
            }
        }
        generatePair(this.level)
        if (Random.nextBoolean()) {
            answer = firstValue + secondValue
            when (this.level) {
                Constants.EASY_CHAR -> {
                    while (answer > 10) {
                        generatePair(this.level)
                        answer = firstValue + secondValue
                    }
                }
                Constants.MEDIUM_CHAR -> {
                    while (answer > 100) {
                        generatePair(this.level)
                        answer = firstValue + secondValue
                    }
                }
                Constants.HARD_CHAR -> {
                    while (answer > 1000) {
                        generatePair(this.level)
                        answer = firstValue + secondValue
                    }
                }
            }

            max = answer + firstValue
            while (max < 5) {
                max++
            }
            binding.exercise.symbol.text = "+"
        } else {
            if (firstValue < secondValue) {
                val tmp = firstValue
                firstValue = secondValue
                secondValue = tmp
            }
            answer = firstValue - secondValue
            max = firstValue + secondValue
            while (max < 5) {
                max++
            }
            binding.exercise.symbol.text = "-"
        }
        val min = 1
        while (wrongAnswers.size < 3) {
            val value = Random.nextInt(min, max)
            if (value != answer && !wrongAnswers.contains(value)) {
                wrongAnswers.add(value)
            }
        }
        return MathProblemModel(firstValue, secondValue, answer, wrongAnswers)
    }

    private fun generatePair(level: String?): Pair<Int, Int> {
        when (level) {
            Constants.EASY_CHAR -> {
                firstValue = Random.nextInt(1, 10)
                secondValue = Random.nextInt(1, 10)
            }
            Constants.MEDIUM_CHAR -> {
                firstValue = Random.nextInt(1, 100)
                secondValue = Random.nextInt(1, 100)
            }
            Constants.HARD_CHAR -> {
                firstValue = Random.nextInt(1, 1000)
                secondValue = Random.nextInt(1, 1000)
            }
            else -> {
                firstValue = 0
                secondValue = 0
            }
        }
        return Pair(firstValue, secondValue)
    }

    override fun actionBackToMainScreen() {
        binding.root.findNavController()
            .navigate(R.id.action_plusMinusFragment_to_mainScreenFragment)
    }
}
package com.example.mvvm_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController

class GameFragment : Fragment() {

    // The current word
    var word = ""
    // The current score
    var score = 0

    private lateinit var wordList: MutableList<String>

    lateinit var  wordText:TextView
    lateinit var  scoreText:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view  = inflater.inflate(R.layout.game_fragment, container, false)

        resetList()

        wordText= view.findViewById(R.id.word_text)
        scoreText = view.findViewById(R.id.score_text)

        //Skip button
        val skip:Button = view.findViewById(R.id.skip_button)
        skip.setOnClickListener { onSkip() }

        //Got it Button
        val correctButton:Button = view.findViewById(R.id.correct_button)
        correctButton.setOnClickListener { correct() }

        //EndGame
        val endGame:Button = view.findViewById(R.id.end_game_button)
        endGame.setOnClickListener { endGame() }


        return  view
    }

    private fun endGame() {
        val action = GameFragmentDirections.actionGameFragmentToScoreFramgent()
        action.score = score
        findNavController().navigate(action)
    }

    private fun correct() {
        score++
        if (!wordList.isEmpty())
        {
            word = wordList.removeAt(0)
        }
        wordText.text = word
        scoreText.text = score.toString()

    }

    private fun onSkip() {
        score--
        if (!wordList.isEmpty())
        {
            word = wordList.removeAt(0)
        }
        wordText.text = word
        scoreText.text = score.toString()

    }

    private fun resetList() {
        wordList = mutableListOf("queen", "hospital", "basketball", "cat", "change", "snail", "soup", "calendar", "sad", "desk",
            "guitar", "home", "railway", "zebra", "jelly", "car", "crow", "trade", "bag", "roll", "bubble")
        wordList.shuffle()
    }


}
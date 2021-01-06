package com.example.mvvm_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController


class ScoreFramgent : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.score_framgent, container, false)



        val scoreText:TextView = view.findViewById(R.id.score_text)

        val score = ScoreFramgentArgs.fromBundle(requireArguments()).score.toString()
        scoreText.text = score


        //play again
        val playAgin:Button = view.findViewById(R.id.play_again_button)
        playAgin.setOnClickListener { findNavController().navigate(ScoreFramgentDirections.actionRestart()) }

        return  view
    }

}
package com.example.mvvm_game

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class TitleFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.title_fragment, container, false)
        val Play:Button = view.findViewById(R.id.play_game_button)
        Play.setOnClickListener {
            findNavController().navigate(TitleFragmentDirections.actionGameToScore())
        }
        return view
    }


}
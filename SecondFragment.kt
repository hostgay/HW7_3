package com.example.aruuke_rakhmanova_hw7_3m

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aruuke_rakhmanova_hw7_3m.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private val musicList = arrayListOf(
        Music("Swim", "Chase Atlantic", "1", "06:20"),
        Music("Swim", "Chase Atlantic", "2", "12:00"),
        Music("Swim", "Chase Atlantic", "3", "02:10"),
        Music("Swim", "Chase Atlantic", "4", "01:02"),
        Music("Swim", "Chase Atlantic", "5", "01:29"),
        Music("Swim", "Chase Atlantic", "6", "01:31"),
        Music("Swim", "Chase Atlantic", "7", "02:10"),
        Music("Swim", "Chase Atlantic", "8", "01:08"),
        Music("Swim", "Chase Atlantic", "9", "01:03"),
        Music("Swim", "Chase Atlantic", "10", "01:08")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MusicAdapter(musicList, this::onClick)
        binding.rvMusic.adapter = adapter
    }

    private fun onClick(position: Int){
        val intent = Intent(activity, SecondActivity::class.java)
        intent.putExtra("key",position)
        startActivity(intent)
    }

}
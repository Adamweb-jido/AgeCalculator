package com.adamweb.agecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adamweb.agecalculator.databinding.FragmentMainMenuBinding


class MainMenuFragment : Fragment() {

   private var _binding : FragmentMainMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

}
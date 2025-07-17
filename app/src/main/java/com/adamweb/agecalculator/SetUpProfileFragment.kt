package com.adamweb.agecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.adamweb.agecalculator.databinding.FragmentSetUpProfileBinding


class SetUpProfileFragment : Fragment() {

    private var _binding : FragmentSetUpProfileBinding? = null
    private val binding get() = _binding!!

    private val mainMenu = MainMenuFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { _binding = FragmentSetUpProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       binding.continueBtn.setOnClickListener {
           parentFragmentManager.beginTransaction().replace(R.id.frameContainer, mainMenu).commit()
       }
    }

}
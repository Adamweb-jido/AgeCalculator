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

    private val homeFragment = HomeFragment()
    private val historyFragment = HistoryFragment()
    private val profileFragment = ProfileFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { _binding = FragmentMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

       setCurrentFragment(homeFragment)
        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.nav_home -> setCurrentFragment(homeFragment)
                R.id.nav_history -> setCurrentFragment(historyFragment)
                R.id.nav_profile -> setCurrentFragment(profileFragment)
            }
            true
        }
    }

    private fun setCurrentFragment(fragment : Fragment) {
        childFragmentManager.beginTransaction().setCustomAnimations(
            R.anim.slide_in_right,
            R.anim.slide_out_left,
            R.anim.slide_in_left,
            R.anim.slide_out_right
        )
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
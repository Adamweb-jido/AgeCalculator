package com.adamweb.agecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adamweb.agecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AgeCalculator)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val fragmentList = listOf(
                firstOnboardFragment(),
                SecondOnboardFragment(),
                ThirdOnboardFragment()
        )
        val adapter = OnboardingAdapter(this, fragmentList)
            binding.onboardViewPager.adapter = adapter
    }
}
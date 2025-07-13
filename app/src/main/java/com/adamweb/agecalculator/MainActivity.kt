package com.adamweb.agecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adamweb.agecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter: OnboardingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AgeCalculator)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPagerHandler()
    }

    private fun viewPagerHandler() {
        val fragmentList = listOf(
            OnboardFragment.newInstance(R.drawable.onboardingimg3, "Your Life In Numbers", "Discover your exact Age in Years, Months and Days instantly - Agetric gives you more than just a Number", false),
            OnboardFragment.newInstance(R.drawable.onboardingimg2, "Explore More Than Just Years", "Find your Birthday Day, next Birthday countdown, and even your Age in seconds. Time is powerful - now it's Personal", false),
            OnboardFragment.newInstance(R.drawable.onboardingimg1, "Style Meets Accuracy", "Enjoy playful interface and precise Age results. Let Agetric make your moments count.", true)
        )

        adapter = OnboardingAdapter(this, fragmentList)
        binding.onboardViewPager.adapter = adapter

    }


}
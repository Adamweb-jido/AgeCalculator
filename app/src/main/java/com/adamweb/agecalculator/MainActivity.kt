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
            OnboardFragment.newInstance(R.drawable.onboardingimg1, "First Slide", "This is the First Slide", false),
            OnboardFragment.newInstance(R.drawable.onboardingimg2, "Second Slide", "This is the Second Slide", false),
            OnboardFragment.newInstance(R.drawable.onboardingimg1, "First Slide", "This is Third Slide", true)
        )

        adapter = OnboardingAdapter(this, fragmentList)
        binding.onboardViewPager.adapter = adapter

    }

    fun goToLastPage(){
        binding.onboardViewPager.currentItem = adapter.itemCount -1
    }
}
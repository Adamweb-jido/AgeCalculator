package com.adamweb.agecalculator

import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextSwitcher
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.adamweb.agecalculator.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var messeges : List<String>
    private var messegeIndex = 0
    private lateinit var textSlider : TextSwitcher

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
         textSlider = binding.textSlide

        textSlider.setFactory {
            TextView(requireContext()).apply {
                textSize = 20f
                setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                typeface = Typeface.DEFAULT_BOLD
                gravity = Gravity.CENTER
            }
        }

        messeges = listOf(
            "More than just numbers — Agetric celebrates your journey through time.",
            "Agetric: Because every age holds a story worth knowing.",
            "Your age. Your timeline. Your truth — with Agetric.",
            "Track your age. Treasure your growth. Live timelessly.",
            "Agetric: Where time meets meaning — one birthday at a time.",
            "Not just your age — your legacy, calculated.",
            "Time never stops — but Agetric helps you understand it.",
            "Growing older is automatic. Knowing how far you've come? That's Agetric.",
            "Every second counts. Agetric shows you how much they’ve added up to."
        )

        nextSlideText()
    }

    private fun nextSlideText() {
        textSlider.setText(messeges[messegeIndex])
        messegeIndex = (messegeIndex + 1) % messeges.size
        Handler(Looper.getMainLooper()).postDelayed({nextSlideText()}, 4000)
    }
}
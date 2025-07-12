package com.adamweb.agecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.adamweb.agecalculator.databinding.OnboardFragmentBinding

class OnboardFragment : Fragment() {

    private var _binding : OnboardFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View { _binding = OnboardFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args = requireArguments()
        binding.onboardImg.setImageResource(args.getInt("images"))
        binding.onboardTittle.setText(args.getString("Title"))
        binding.onboardDesc.setText(args.getString("Descriptions"))

        val isLast = args.getBoolean("isLast", false)

        binding.nextBtn.apply {
            text = if (isLast) "Jump In" else "Next"
            setOnClickListener {
                if (isLast){
                    Toast.makeText(context, "Welcome to Agetric", Toast.LENGTH_SHORT).show()
                } else {
                    val viewPager = activity?.findViewById<ViewPager2>(R.id.onboardViewPager)
                    viewPager?.let {
                        it.currentItem += 1
                    }
                }
            }
        }

        binding.skipBtn.setOnClickListener {
            Toast.makeText(context, "Welcome to Agetric", Toast.LENGTH_SHORT).show()
        }
    }



}
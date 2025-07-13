package com.adamweb.agecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
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
        binding.onboardTittle.text = args.getString("title")
        binding.onboardDesc.text = args.getString("desc")

        (activity as? AppCompatActivity)?.supportActionBar?.hide()
        val window = requireActivity().window
        val controller = WindowCompat.getInsetsController(window, view)
        controller.show(WindowInsetsCompat.Type.systemBars())

        val isLast = args.getBoolean("isLast", false)

        if (isLast) {
            binding.skipBtn.isEnabled = false
            binding.skipBtn.alpha = 0.3f
        } else {
            binding.skipBtn.isEnabled = true
            binding.skipBtn.alpha = 1f
        }

        binding.skipBtn.setOnClickListener {
            Toast.makeText(context, "Welcome to Agetric", Toast.LENGTH_SHORT).show()
        }

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


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance(imageRes: Int, title: String, desc: String, isLast: Boolean) = OnboardFragment().apply {
            arguments = Bundle().apply {
                putInt("images", imageRes)
                putString("title", title)
                putString("desc", desc)
                putBoolean("isLast", isLast)
            }
        }
    }

}
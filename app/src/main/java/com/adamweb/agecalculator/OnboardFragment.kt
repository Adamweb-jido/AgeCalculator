package com.adamweb.agecalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.adamweb.agecalculator.databinding.OnboardFragmentBinding

class OnboardFragment : Fragment() {

    private var _binding : OnboardFragmentBinding? = null
    private val binding get() = _binding!!
    val profilePage = SetUpProfileFragment()

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
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val controller = WindowInsetsControllerCompat(window, view)
        controller.hide(WindowInsetsCompat.Type.systemBars())
        controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE


        val isLast = args.getBoolean("isLast", false)

        if (isLast) {
            binding.skipBtn.isEnabled = false
            binding.skipBtn.alpha = 0.3f
        } else {
            binding.skipBtn.isEnabled = true
            binding.skipBtn.alpha = 1f
        }

        binding.skipBtn.setOnClickListener {
            activity?.findViewById<ViewPager2>(R.id.onboardViewPager)?.visibility = View.GONE
            parentFragmentManager.beginTransaction().replace(R.id.frameContainer, profilePage).commit()
            activity?.findViewById<FrameLayout>(R.id.frameContainer)?.visibility = View.VISIBLE
        }

        binding.nextBtn.apply {
            text = if (isLast) "Jump In" else "Next"
            setOnClickListener {
                if (isLast){
                    activity?.findViewById<ViewPager2>(R.id.onboardViewPager)?.visibility = View.GONE
                    parentFragmentManager.beginTransaction().replace(R.id.frameContainer, profilePage).commit()
                    activity?.findViewById<FrameLayout>(R.id.frameContainer)?.visibility = View.VISIBLE
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
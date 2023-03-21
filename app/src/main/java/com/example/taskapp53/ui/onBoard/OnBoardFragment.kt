package com.example.taskapp53.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.taskapp53.databinding.FragmentOnBoardBinding
import com.example.taskapp53.ui.onBoard.adapter.OnBoardingAdapter
import me.relex.circleindicator.CircleIndicator3
import java.util.zip.Inflater


class OnBoardFragment : Fragment() {

    private lateinit var binding:FragmentOnBoardBinding

    private val adapter = OnBoardingAdapter(this::onStartClick)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = adapter
        setIndicator()
    }

    private fun setIndicator() {
        val indicator:CircleIndicator3 = binding.indicator
        val viewPager = binding.viewPager
        indicator.setViewPager(viewPager)
    }

    private  fun onStartClick(){
        findNavController().navigateUp()

    }
}


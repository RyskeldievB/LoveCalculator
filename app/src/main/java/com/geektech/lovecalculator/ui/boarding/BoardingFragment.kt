package com.geektech.lovecalculator.ui.boarding

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.FragmentBoardingBinding
import com.geektech.lovecalculator.ui.boarding.adapter.BoardingAdapter
import com.geektech.lovecalculator.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoardingFragment : Fragment() {
    private lateinit var binding: FragmentBoardingBinding
    private lateinit var adapter: BoardingAdapter
    private val viewModel: BoardingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initObserve()
        initAdapter()
    }

    private fun initObserve() {
        viewModel.boardingShowed()
        viewModel.showBoardingLive.observe(viewLifecycleOwner, Observer {
            if (it) {
                findNavController().navigate(R.id.homeFragment)
            }
        })
    }

    private fun initAdapter() {
        adapter = BoardingAdapter {
            viewModel.saveBoardingShowed(true)
            findNavController().navigate(R.id.homeFragment)
        }
        binding.viewPager.adapter = adapter
    }
}


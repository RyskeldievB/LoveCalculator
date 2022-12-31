package com.geektech.lovecalculator.ui.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.FragmentResultBinding
import com.geektech.lovecalculator.ui.home.remote.LoveModel
import com.geektech.taskmanager.key.Key

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
        navigateHome()
    }

    private fun setData() {
        var data = arguments?.getSerializable(Key.KEY_DATA)

        if (data != null) {
            data = data as LoveModel
            with(binding) {
                tvFirstName.text = data.firstName
                tvSecondName.text = data.secondName
                tvPercentage.text = data.percentage
                tvResult.text = data.result
            }
        }
    }

    private fun navigateHome() {
        with(binding) {
            btnTryAgain.setOnClickListener { findNavController().navigate(R.id.homeFragment) }
            ivHeart.setOnClickListener { findNavController().navigate(R.id.homeFragment) }
            tvHome.setOnClickListener { findNavController().navigate(R.id.homeFragment) }
        }
    }
}
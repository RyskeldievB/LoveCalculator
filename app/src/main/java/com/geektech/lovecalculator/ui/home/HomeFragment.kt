package com.geektech.lovecalculator.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.FragmentHomeBinding
import com.geektech.taskmanager.key.Key


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicker()
    }

    private fun initClicker() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveModel(
                    binding.etFirstName.text.toString(),
                    binding.etSecondName.text.toString()
                ).observe(viewLifecycleOwner) {
                    findNavController().navigate(R.id.resultFragment, bundleOf(Key.KEY_DATA to it))
                }
            }
        }
    }
}
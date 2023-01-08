package com.geektech.lovecalculator.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.FragmentHomeBinding
import com.geektech.lovecalculator.ui.home.remote.LoveModel
import com.geektech.taskmanager.key.Key
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private var updateModel: LoveModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        openLoveModel()
        initClicker()
    }

    private fun openLoveModel() {
        arguments?.let {
            val value = it.getSerializable(Key.KEY_DATA_UPDATE)
            if (value != null) {
                updateModel = value as LoveModel
                binding.etFirstName.setText(updateModel?.firstName)
                binding.etSecondName.setText(updateModel?.secondName)
            }
        }
    }

    private fun initClicker() {
        binding.btnCalculate.setOnClickListener {
            if (updateModel !== null) {
                updateData()
            } else {
                saveData()
            }
            saveData()
        }
    }

    private fun updateData() {
        viewModel.getLiveLoveModel(
            binding.etFirstName.text.toString(),
            binding.etSecondName.text.toString()
        ).observe(viewLifecycleOwner){ newData ->
            updateModel?.firstName = newData.firstName
            updateModel?.secondName = newData.secondName
            updateModel?.percentage = newData.percentage
            updateModel?.result = newData.result
            updateModel?.let { it -> viewModel.updateLove(it) }
            findNavController().navigate(R.id.resultFragment, bundleOf(Key.KEY_DATA_UPDATE to updateModel))
        }
    }

    private fun saveData() {
        viewModel.getLiveLoveModel(
            binding.etFirstName.text.toString(),
            binding.etSecondName.text.toString()
        ).observe(viewLifecycleOwner) {
            viewModel.insertLove(it)
            findNavController().navigate(R.id.resultFragment, bundleOf(Key.KEY_DATA to it))
        }
    }
}
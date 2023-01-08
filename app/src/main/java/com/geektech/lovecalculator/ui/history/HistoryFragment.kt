package com.geektech.lovecalculator.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.geektech.lovecalculator.R
import com.geektech.lovecalculator.databinding.FragmentHistoryBinding
import com.geektech.lovecalculator.ui.history.adapter.HistoryAdapter
import com.geektech.lovecalculator.ui.home.remote.LoveModel
import com.geektech.taskmanager.key.Key
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: HistoryAdapter
    private val viewModel: HistoryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        addData()
    }

    private fun addData() {
        viewModel.getAllLiveLove()
        viewModel.liveLoveData.observe(viewLifecycleOwner) {
            adapter.loadData(it)
        }
    }

    private fun initAdapter() {
        adapter = HistoryAdapter(this::onClick)
        binding.rvHistory.adapter = adapter
    }

    private fun onClick(model: LoveModel) {
        val alertDialogBuilder =
            AlertDialog.Builder(requireContext()).setMessage("Do you want change the result?")
        alertDialogBuilder.setPositiveButton("Yes") { dialog, id ->
            findNavController().navigate(R.id.homeFragment, bundleOf(Key.KEY_DATA_UPDATE to model))
        }
        alertDialogBuilder.setNegativeButton("No") { dialog, id ->
            dialog.dismiss()
        }
        alertDialogBuilder.show()
    }
}
package com.geektech.lovecalculator.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.geektech.lovecalculator.App
import com.geektech.lovecalculator.databinding.FragmentHistoryBinding
import com.geektech.lovecalculator.ui.history.adapter.HistoryAdapter
import com.geektech.lovecalculator.ui.home.HomeViewModel


class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter:HistoryAdapter
    private val viewModel: HomeViewModel by viewModels()

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
        App.appDataBase.getDao().getAll().observe(viewLifecycleOwner, Observer {
            adapter.loadData(it)
        })
    }

    private fun initAdapter() {
        adapter = HistoryAdapter()
        binding.rvHistory.adapter = adapter
    }
}
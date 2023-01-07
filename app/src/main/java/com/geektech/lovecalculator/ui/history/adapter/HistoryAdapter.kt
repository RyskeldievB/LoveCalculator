package com.geektech.lovecalculator.ui.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.geektech.lovecalculator.databinding.ItemHistoryBinding
import com.geektech.lovecalculator.ui.home.remote.LoveModel

class HistoryAdapter : Adapter<HistoryAdapter.HistoryViewHolder>() {
    val data = arrayListOf<LoveModel>()

    fun loadData(newData: List<LoveModel>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        ViewHolder(binding.root) {
        fun bind(model: LoveModel) {
            with(binding){
                tvFirstName.text = model.firstName
                tvSecondName.text = model.secondName
                tvPercentage.text = model.percentage
            }
        }
    }
}
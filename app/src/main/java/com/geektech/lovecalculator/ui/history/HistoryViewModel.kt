package com.geektech.lovecalculator.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.lovecalculator.repository.Repository
import com.geektech.lovecalculator.ui.home.remote.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {
    lateinit var  liveLoveData : LiveData<List<LoveModel>>

    fun getAllLiveLove() {
        liveLoveData = repository.getAllLove()
    }
}
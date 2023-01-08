package com.geektech.lovecalculator.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.lovecalculator.ui.home.remote.LoveModel
import com.geektech.lovecalculator.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    fun getLiveLoveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLiveLove(firstName, secondName)
    }

    fun insertLove(model: LoveModel) {
        repository.insertLove(model)
    }

    fun updateLove(model: LoveModel) {
        repository.updateLove(model)
    }
}
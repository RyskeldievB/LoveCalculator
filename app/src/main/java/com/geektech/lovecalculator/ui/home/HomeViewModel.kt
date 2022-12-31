package com.geektech.lovecalculator.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.lovecalculator.ui.home.remote.LoveModel
import com.geektech.lovecalculator.ui.home.repository.Repository

class HomeViewModel : ViewModel() {

    private val repository = Repository()
    fun getLiveLoveModel(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLiveLove(firstName, secondName)
    }
}
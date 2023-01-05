package com.geektech.lovecalculator.ui.boarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geektech.lovecalculator.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BoardingViewModel @Inject constructor(
    private val repository: Repository,
) : ViewModel() {

    private val showBoardingLiveMutable = MutableLiveData<Boolean>()
    val showBoardingLive : LiveData<Boolean> = showBoardingLiveMutable

    fun boardingShowed() {
        showBoardingLiveMutable.value = repository.boardingShowed()
    }

    fun saveBoardingShowed(isShow:Boolean){
        repository.saveBoardingShowed(isShow)
    }
}


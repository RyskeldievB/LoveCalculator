package com.geektech.lovecalculator.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.geektech.lovecalculator.data.local.Pref
import com.geektech.lovecalculator.ui.home.remote.LoveApi
import com.geektech.lovecalculator.ui.home.remote.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {
    @Inject
    lateinit var pref: Pref

    fun getLiveLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        api.getResultLove(
            firstName, secondName
        ).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    liveData.postValue(response.body())
                }
            }
            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("aga", "onFailure: " + t.message)
            }
        })
        return liveData
    }

    fun boardingShowed(): Boolean {
        val liveData = MutableLiveData<Boolean>()
        return pref.boardingShowed()
    }

    fun saveBoardingShowed(isShow:Boolean){
        pref.saveBoardingShowed(isShow)
    }
}
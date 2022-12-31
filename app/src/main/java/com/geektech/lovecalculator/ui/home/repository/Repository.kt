package com.geektech.lovecalculator.ui.home.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.geektech.lovecalculator.ui.home.remote.LoveModel
import com.geektech.lovecalculator.ui.home.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getLiveLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel>()
        RetrofitService().getLoveApi().getResultLove(
            firstName = firstName, secondName = secondName
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
}
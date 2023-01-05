package com.geektech.lovecalculator.data.local

import android.content.SharedPreferences
import com.geektech.taskmanager.key.Key
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Pref @Inject constructor(private var pref:SharedPreferences){

    fun boardingShowed(): Boolean {
        return pref.getBoolean(Key.KEY_ON_BOARDING, false)
    }
    fun saveBoardingShowed(isShow: Boolean) {
        pref.edit().putBoolean(Key.KEY_ON_BOARDING, isShow).apply()
    }
}
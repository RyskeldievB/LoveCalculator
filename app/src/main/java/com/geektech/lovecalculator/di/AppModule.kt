package com.geektech.lovecalculator.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.geektech.lovecalculator.data.local.room.AppDataBase
import com.geektech.lovecalculator.data.local.room.LoveDao
import com.geektech.lovecalculator.ui.home.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
 import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun apiProvide(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun sharedPrefProvide(context: Application):SharedPreferences{
        return context.getSharedPreferences("my_pref",
            Context.MODE_PRIVATE
        )
    }
//
//    @Provides
//    fun loveDaoProvide(appDataBase: AppDataBase): LoveDao{
//        return appDataBase.getDao()
//    }
}
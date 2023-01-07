package com.geektech.lovecalculator.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.geektech.lovecalculator.ui.home.remote.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insertLove(model:LoveModel)

    @Query("SELECT * FROM lovemodel")
    fun getAll(): LiveData<List<LoveModel>>
}
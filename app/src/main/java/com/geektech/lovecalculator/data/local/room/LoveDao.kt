package com.geektech.lovecalculator.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.geektech.lovecalculator.ui.home.remote.LoveModel

@Dao
interface LoveDao {
    @Insert
    fun insertLove(model:LoveModel)

    @Query("SELECT * FROM lovemodel ORDER BY firstName ASC")
    fun getAllLove(): LiveData<List<LoveModel>>

    @Update
    fun updateLove(model: LoveModel)
}
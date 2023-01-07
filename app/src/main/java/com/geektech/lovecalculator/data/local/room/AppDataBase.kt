package com.geektech.lovecalculator.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geektech.lovecalculator.ui.home.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun getDao() : LoveDao
}
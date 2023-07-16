package com.simbadev.m7_hw_1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simbadev.m7_hw_1.data.models.CarEntity

@Database(entities = [CarEntity::class], version = 1)
abstract class CarDataBase: RoomDatabase() {


    abstract fun carDao() : CarDao
}
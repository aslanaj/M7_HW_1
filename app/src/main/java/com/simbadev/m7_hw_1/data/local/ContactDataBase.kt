package com.simbadev.m7_hw_1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.simbadev.m7_hw_1.data.local.ContactsDao
import com.simbadev.m7_hw_1.data.models.ContactEntity

@Database(entities = [ContactEntity::class], version = 1)
abstract class ContactDataBase: RoomDatabase() {


    abstract fun contactDao() : ContactsDao
}
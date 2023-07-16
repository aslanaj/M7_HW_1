package com.simbadev.m7_hw_1.domain.repositories

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.simbadev.m7_hw_1.data.models.ContactEntity

interface ContactRepository {

    fun addContact(contactEntity: ContactEntity)

    fun getContact(): List<ContactEntity>

    fun updateContact(contactEntity: ContactEntity)

    fun deleteContact(contactEntity: ContactEntity)
}
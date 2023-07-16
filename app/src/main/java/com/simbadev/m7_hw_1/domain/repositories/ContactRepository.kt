package com.simbadev.m7_hw_1.domain.repositories

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.simbadev.m7_hw_1.data.models.ContactEntity
import com.simbadev.m7_hw_1.domain.Resource
import com.simbadev.m7_hw_1.domain.models.Contact
import kotlinx.coroutines.flow.Flow

interface ContactRepository {

    fun addContact(contact: Contact) : Flow<Resource<Unit>>

    fun getContact(): Flow<Resource<List<Contact>>>

    fun updateContact(contact: Contact): Flow<Resource<Unit>>

    fun deleteContact(contact: Contact): Flow<Resource<Unit>>
}
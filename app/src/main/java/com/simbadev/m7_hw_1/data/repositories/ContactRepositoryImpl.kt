package com.simbadev.m7_hw_1.data.repositories

import com.simbadev.m7_hw_1.data.local.ContactsDao
import com.simbadev.m7_hw_1.data.mappers.toContact
import com.simbadev.m7_hw_1.data.mappers.toEntity
import com.simbadev.m7_hw_1.data.models.ContactEntity
import com.simbadev.m7_hw_1.domain.Resource
import com.simbadev.m7_hw_1.domain.models.Contact
import com.simbadev.m7_hw_1.domain.repositories.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val contactsDao: ContactsDao
) : ContactRepository {
    override fun addContact(contact: Contact): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = contactsDao.addContact(contact.toEntity()
                )
                emit(Resource.Success(data))
            }catch (e : Exception){
                emit(
                    Resource.Error(
                        // можно заменить  на элвис ?: -> e.localizedMessage ?: "unknown error"
                        if (e.localizedMessage != null){
                            e.localizedMessage
                        }else{
                            "unknown error"
                        }
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun getContact(): Flow<Resource<List<Contact>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val list = contactsDao.getContact()
                val data = list.map { it.toContact() }
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.localizedMessage ?: "unknown error"))
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun updateContact(contact: Contact): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = contactsDao.updateContact(contact.toEntity()
                )
                emit(Resource.Success(data))
            }catch (e : Exception){
                emit(
                    Resource.Error(
                        e.localizedMessage ?: "unknown error"
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
    }

    override fun deleteContact(contact: Contact): Flow<Resource<Unit>> {

        return flow {
            emit(Resource.Loading())
            try {
                val data = contactsDao.deleteContact(contact.toEntity()
                )
                emit(Resource.Success(data))
            }catch (e : Exception){
                emit(
                    Resource.Error(
                        e.localizedMessage ?: "unknown error"
                    )
                )
            }
        }.flowOn(Dispatchers.IO)
    }


}
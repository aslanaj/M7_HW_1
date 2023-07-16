package com.simbadev.m7_hw_1.data.repositories

import com.simbadev.m7_hw_1.data.local.ContactsDao
import com.simbadev.m7_hw_1.data.models.ContactEntity
import com.simbadev.m7_hw_1.domain.repositories.ContactRepository

class ContactRepositoryImpl(
    private val contactsDao: ContactsDao
) : ContactRepository {

    override fun addContact(contactEntity: ContactEntity) {
        contactsDao.addContact(contactEntity)
    }

    override fun getContact(): List<ContactEntity> {
        return contactsDao.getContact()
    }

    override fun updateContact(contactEntity: ContactEntity) {
        contactsDao.updateContact(contactEntity)
    }

    override fun deleteContact(contactEntity: ContactEntity) {
        contactsDao.deleteContact(contactEntity)
    }
}
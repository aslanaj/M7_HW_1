package com.simbadev.m7_hw_1.domain.usecases

import com.simbadev.m7_hw_1.data.models.ContactEntity
import com.simbadev.m7_hw_1.domain.repositories.ContactRepository

class AddContactUseCase(
   private val contactRepository: ContactRepository
) {

    fun addContact(contactEntity: ContactEntity){
        contactRepository.addContact(contactEntity)
    }
}
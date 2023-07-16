package com.simbadev.m7_hw_1.domain.usecases

import com.simbadev.m7_hw_1.data.models.ContactEntity
import com.simbadev.m7_hw_1.domain.repositories.ContactRepository

class GetContactUseCase(
    private val contactRepository: ContactRepository
) {

    fun getAllContacts(): List<ContactEntity>{
        return contactRepository.getContact()
    }
}
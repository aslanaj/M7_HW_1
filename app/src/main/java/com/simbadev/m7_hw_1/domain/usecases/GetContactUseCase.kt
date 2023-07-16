package com.simbadev.m7_hw_1.domain.usecases

import com.simbadev.m7_hw_1.data.models.ContactEntity
import com.simbadev.m7_hw_1.domain.repositories.ContactRepository
import javax.inject.Inject

class GetContactUseCase @Inject constructor(
    private val contactRepository: ContactRepository
) {

    fun getAllContacts(): List<ContactEntity>{
        return contactRepository.getContact()
    }
}
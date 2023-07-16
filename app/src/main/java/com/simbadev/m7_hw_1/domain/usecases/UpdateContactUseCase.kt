package com.simbadev.m7_hw_1.domain.usecases

import com.simbadev.m7_hw_1.data.models.ContactEntity
import com.simbadev.m7_hw_1.domain.repositories.ContactRepository
import javax.inject.Inject

class UpdateContactUseCase @Inject constructor(
    private val contactRepository: ContactRepository
) {
    fun updateContact(contactEntity: ContactEntity){
        contactRepository.updateContact(contactEntity)
    }
}
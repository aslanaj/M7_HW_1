package com.simbadev.m7_hw_1.data.mappers

import com.simbadev.m7_hw_1.data.models.ContactEntity
import com.simbadev.m7_hw_1.domain.models.Contact

fun Contact.toEntity() = ContactEntity(id, name, number, address)

fun ContactEntity.toContact() = Contact(id, name, number, address)
package com.simbadev.m7_hw_1.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.simbadev.m7_hw_1.data.local.ContactDataBase
import com.simbadev.m7_hw_1.data.local.ContactsDao
import com.simbadev.m7_hw_1.data.repositories.ContactRepositoryImpl
import com.simbadev.m7_hw_1.domain.repositories.ContactRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContactModule {

    @Singleton
    @Provides
    fun provideContactDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ContactDataBase::class.java,
        "contact_db"
    )

    @Provides
    fun provideContactDao(contactDataBase: ContactDataBase) = contactDataBase.contactDao()

    @Provides

    fun provideContactRepository(contactsDao: ContactsDao): ContactRepository{
        return ContactRepositoryImpl(contactsDao)
    }


}
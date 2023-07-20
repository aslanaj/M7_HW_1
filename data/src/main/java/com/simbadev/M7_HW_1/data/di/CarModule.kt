package com.simbadev.M7_HW_1.data.di

import android.content.Context
import androidx.room.Room
import com.simbadev.M7_HW_1.data.local.CarDao
import com.simbadev.M7_HW_1.data.local.CarDataBase
import com.simbadev.M7_HW_1.domain.repositories.CarRepository

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CarModule {

    @Singleton
    @Provides
    fun provideContactDataBase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        CarDataBase::class.java,
        "contact_db"
    )

    @Provides
    fun provideCarDao(carDataBase: CarDataBase) = carDataBase.carDao()

    @Provides

    fun provideCarRepository(carDao: CarDao): CarRepository {
        return com.simbadev.M7_HW_1.data.repositories.CarRepositoryImpl(carDao)
    }


}
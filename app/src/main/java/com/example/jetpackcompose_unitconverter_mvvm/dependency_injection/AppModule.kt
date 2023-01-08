package com.example.jetpackcompose_unitconverter_mvvm.dependency_injection

import android.app.Application
import androidx.room.Room
import com.example.jetpackcompose_unitconverter_mvvm.data.ConverterDatabase
import com.example.jetpackcompose_unitconverter_mvvm.data.ConverterRepository
import com.example.jetpackcompose_unitconverter_mvvm.data.ConverterRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideConverterDatabase(app: Application): ConverterDatabase {
        return Room.databaseBuilder(
            app,
            ConverterDatabase::class.java,
            "converter_data_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideConverterRepository(db: ConverterDatabase): ConverterRepository{
        return ConverterRepositoryImpl(db.converterDAO)
    }

}
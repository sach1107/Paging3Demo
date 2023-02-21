package com.sach.paging3demo.di

import android.content.Context
import androidx.room.Room
import com.sach.paging3demo.db.QuoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): QuoteDatabase {
        return Room.databaseBuilder(context, QuoteDatabase::class.java, "quoteDB").build()
    }
}
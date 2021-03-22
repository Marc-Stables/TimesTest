package com.example.timestest.di

import android.content.Context
import androidx.room.Room
import com.example.timestest.data.source.local.NewsfeedItemDao
import com.example.timestest.data.source.local.TimesTestDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDatabaseModule {
    @Provides
    fun provideNewsfeedItemDao(appDatabase: TimesTestDatabase): NewsfeedItemDao {
        return appDatabase.newsFeedItemDao()
    }

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): TimesTestDatabase {
        return Room.databaseBuilder(
            context,
            TimesTestDatabase::class.java,
            "TimesTest"
        ).build()
    }
}
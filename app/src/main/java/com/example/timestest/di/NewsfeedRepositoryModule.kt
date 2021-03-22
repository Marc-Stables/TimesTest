package com.example.timestest.di

import com.example.timestest.data.source.repository.DefaultNewsfeedRepository
import com.example.timestest.data.source.NewsfeedRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewsfeedRepositoryModule {
    @Binds
    abstract fun bindNewsfeedRepository(impl: DefaultNewsfeedRepository): NewsfeedRepository
}
package com.example.timestest.di

import androidx.lifecycle.ViewModel
import com.example.timestest.data.source.NewsfeedDataSource
import com.example.timestest.data.source.NewsfeedDataSourceAndStore
import com.example.timestest.data.source.NewsfeedDataStore
import com.example.timestest.data.source.local.NewsfeedLocalDataSource
import com.example.timestest.data.source.remote.NewsfeedRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
abstract class NewsfeedDataSourceModule {
    @Binds
    @NewsfeedRemoteDataSourceAnno
    abstract fun bindNewsfeedRemoteDataSource(impl: NewsfeedRemoteDataSource): NewsfeedDataSource

    @Binds
    @NewsfeedLocalDataSourceAnno
    abstract fun bindNewsfeedLocalDataSource(impl: NewsfeedLocalDataSource): NewsfeedDataSourceAndStore

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class NewsfeedRemoteDataSourceAnno

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class NewsfeedLocalDataSourceAnno
}
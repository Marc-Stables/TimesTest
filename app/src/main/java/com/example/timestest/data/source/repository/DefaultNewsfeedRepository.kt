package com.example.timestest.data.source.repository

import androidx.lifecycle.LiveData
import com.example.timestest.data.model.NewsfeedItem
import com.example.timestest.data.Result
import com.example.timestest.data.source.NewsfeedDataSource
import com.example.timestest.data.source.NewsfeedDataSourceAndStore
import com.example.timestest.data.source.NewsfeedRepository
import com.example.timestest.di.DispatcherModule
import com.example.timestest.di.NewsfeedDataSourceModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DefaultNewsfeedRepository @Inject constructor(
        @NewsfeedDataSourceModule.NewsfeedLocalDataSourceAnno private val newsFeedLocalDataSource: NewsfeedDataSourceAndStore,
        @NewsfeedDataSourceModule.NewsfeedRemoteDataSourceAnno private val newsFeedRemoteDataSource: NewsfeedDataSource,
        @DispatcherModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher
): NewsfeedRepository {
    override fun observeNewsfeedItems(): LiveData<List<NewsfeedItem>> {
        return newsFeedLocalDataSource.observeNewsfeedItems()
    }

    override suspend fun getNewsfeedItems(fromNetwork: Boolean): Result<List<NewsfeedItem>> = withContext(ioDispatcher) {
        if (fromNetwork) {
            val items = newsFeedRemoteDataSource.getNewsfeedItems()
            if (items is Result.Success) {
                newsFeedLocalDataSource.saveNewsfeedItems(*items.data.toTypedArray())
            }
        }
        return@withContext newsFeedLocalDataSource.getNewsfeedItems()
    }

    override suspend fun getNewsfeedItemFor(id: Long) = withContext(ioDispatcher) {
        return@withContext newsFeedLocalDataSource.getNewsfeedItemFor(id)
    }

    override suspend fun saveNewsfeedItems(vararg items: NewsfeedItem) = withContext(ioDispatcher) {
        newsFeedLocalDataSource.saveNewsfeedItems(*items)
    }
}
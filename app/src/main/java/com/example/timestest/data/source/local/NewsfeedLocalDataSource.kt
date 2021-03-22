package com.example.timestest.data.source.local

import androidx.lifecycle.LiveData
import com.example.timestest.data.model.NewsfeedItem
import com.example.timestest.data.Result
import com.example.timestest.data.source.NewsfeedDataSourceAndStore
import com.example.timestest.di.DispatcherModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsfeedLocalDataSource @Inject constructor(
    private val newsfeedItemDao: NewsfeedItemDao,
    @DispatcherModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher
): NewsfeedDataSourceAndStore {
    override fun observeNewsfeedItems(): LiveData<List<NewsfeedItem>> {
        return newsfeedItemDao.observeNewsfeedItems()
    }

    override suspend fun getNewsfeedItems(): Result<List<NewsfeedItem>> = withContext(ioDispatcher) {
        val items = newsfeedItemDao.getNewsfeedItems()
        return@withContext Result.Success(items)
    }

    override suspend fun saveNewsfeedItems(vararg items: NewsfeedItem) {
        newsfeedItemDao.insertNewsfeedItems(*items)
    }
}
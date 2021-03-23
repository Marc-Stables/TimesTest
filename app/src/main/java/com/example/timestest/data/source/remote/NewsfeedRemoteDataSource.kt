package com.example.timestest.data.source.remote

import androidx.lifecycle.LiveData
import com.example.timestest.data.model.NewsfeedItem
import com.example.timestest.data.source.NewsfeedDataSource
import com.example.timestest.data.Result
import com.example.timestest.di.DispatcherModule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsfeedRemoteDataSource @Inject constructor(
    @DispatcherModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher
): NewsfeedDataSource {
    override fun observeNewsfeedItems(): LiveData<List<NewsfeedItem>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNewsfeedItems(): Result<List<NewsfeedItem>> = withContext(ioDispatcher) {
        try {
            val newsfeedItems = TimesApi.retrofitService.getMostPopular()
            return@withContext Result.Success(newsfeedItems.results)
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    override suspend fun getNewsfeedItemFor(id: Long): Result<NewsfeedItem?> {
        TODO("Not yet implemented")
    }
}
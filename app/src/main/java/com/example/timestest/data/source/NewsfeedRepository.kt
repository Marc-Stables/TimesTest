package com.example.timestest.data.source

import androidx.lifecycle.LiveData
import com.example.timestest.data.model.NewsfeedItem
import com.example.timestest.data.Result

interface NewsfeedRepository {
    fun observeNewsfeedItems(): LiveData<List<NewsfeedItem>>
    suspend fun getNewsfeedItems(fromNetwork: Boolean): Result<List<NewsfeedItem>>
    suspend fun getNewsfeedItemFor(id: Long): Result<NewsfeedItem?>
    suspend fun saveNewsfeedItems(vararg item: NewsfeedItem)
}
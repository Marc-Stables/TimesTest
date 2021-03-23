package com.example.timestest.data.source

import androidx.lifecycle.LiveData
import com.example.timestest.data.model.NewsfeedItem
import com.example.timestest.data.Result

interface NewsfeedDataSource {
    fun observeNewsfeedItems(): LiveData<List<NewsfeedItem>>
    suspend fun getNewsfeedItems(): Result<List<NewsfeedItem>>
    suspend fun getNewsfeedItemFor(id: Long): Result<NewsfeedItem?>
}
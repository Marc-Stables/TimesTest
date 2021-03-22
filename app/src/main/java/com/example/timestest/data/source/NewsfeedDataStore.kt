package com.example.timestest.data.source

import com.example.timestest.data.model.NewsfeedItem

interface NewsfeedDataStore {
    suspend fun saveNewsfeedItems(vararg item: NewsfeedItem)
}
package com.example.timestest.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.timestest.data.model.NewsfeedItem

@Dao
interface NewsfeedItemDao {
    @Query("SELECT * FROM NewsfeedItem")
    fun observeNewsfeedItems(): LiveData<List<NewsfeedItem>>

    @Query("SELECT * FROM NewsfeedItem")
    fun getNewsfeedItems(): List<NewsfeedItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewsfeedItems(vararg items: NewsfeedItem)
}
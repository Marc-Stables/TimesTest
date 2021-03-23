package com.example.timestest.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.timestest.data.model.NewsfeedItem

@Database(entities = [NewsfeedItem::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class TimesTestDatabase: RoomDatabase() {
    abstract fun newsFeedItemDao(): NewsfeedItemDao
}
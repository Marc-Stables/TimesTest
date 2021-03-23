package com.example.timestest.data.source.local

import androidx.room.TypeConverter
import com.example.timestest.data.model.NewsfeedItemMedia
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {
    @TypeConverter
    fun newsfeedItemMediaFromJson(json: String): List<NewsfeedItemMedia>? {
        val type = Types.newParameterizedType(List::class.java, NewsfeedItemMedia::class.java)
        val adapter = Moshi.Builder().build().adapter<List<NewsfeedItemMedia>>(type)
        return adapter.fromJson(json)
    }

    @TypeConverter
    fun newsfeedItemMediaToJson(item: List<NewsfeedItemMedia>?): String {
        val type = Types.newParameterizedType(List::class.java, NewsfeedItemMedia::class.java)
        val adapter = Moshi.Builder().build().adapter<List<NewsfeedItemMedia>>(type)
        return adapter.toJson(item)
    }
}
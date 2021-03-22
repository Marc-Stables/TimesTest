package com.example.timestest.data.source.local.converters

import androidx.room.TypeConverter
import com.example.timestest.data.model.NewsfeedItemMedia
import com.example.timestest.data.model.NewsfeedItemMediaMetadata
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

    @TypeConverter
    fun newsfeedItemMediaMetadataFromJson(json: String): List<NewsfeedItemMediaMetadata>? {
        val type = Types.newParameterizedType(List::class.java, NewsfeedItemMediaMetadata::class.java)
        val adapter = Moshi.Builder().build().adapter<List<NewsfeedItemMediaMetadata>>(type)
        return adapter.fromJson(json)
    }

    @TypeConverter
    fun newsfeedItemMediaMetadataToJson(item: List<NewsfeedItemMediaMetadata>?): String {
        val type = Types.newParameterizedType(List::class.java, NewsfeedItemMediaMetadata::class.java)
        val adapter = Moshi.Builder().build().adapter<List<NewsfeedItemMediaMetadata>>(type)
        return adapter.toJson(item)
    }
}
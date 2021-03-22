package com.example.timestest.data.source.local.adapters

import com.example.timestest.data.model.NewsfeedItemMedia
import com.example.timestest.data.model.NewsfeedItemMediaMetadata
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types

class NewsfeedItemMediaMetadataAdapter {
    @ToJson
    fun toJson(item: List<NewsfeedItemMediaMetadata>): String {
        val type = Types.newParameterizedType(List::class.java, NewsfeedItemMedia::class.java)
        val adapter = Moshi.Builder().build().adapter<List<NewsfeedItemMediaMetadata>>(type)
        return adapter.toJson(item)
    }

    @FromJson
    fun fromJson(json: String): List<NewsfeedItemMediaMetadata>? {
        val type = Types.newParameterizedType(List::class.java, NewsfeedItemMedia::class.java)
        val adapter = Moshi.Builder().build().adapter<List<NewsfeedItemMediaMetadata>>(type)
        return adapter.fromJson(json)
    }
}
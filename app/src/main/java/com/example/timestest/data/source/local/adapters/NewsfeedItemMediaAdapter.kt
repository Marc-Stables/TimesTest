package com.example.timestest.data.source.local.adapters

import com.example.timestest.data.model.NewsfeedItemMedia
import com.squareup.moshi.FromJson
import com.squareup.moshi.Moshi
import com.squareup.moshi.ToJson
import com.squareup.moshi.Types

class NewsfeedItemMediaAdapter {
    @ToJson
    fun toJson(item: List<NewsfeedItemMedia>): String {
        val type = Types.newParameterizedType(List::class.java, NewsfeedItemMedia::class.java)
        val adapter = Moshi.Builder().build().adapter<List<NewsfeedItemMedia>>(type)
        return adapter.toJson(item)
    }

    @FromJson
    fun fromJson(json: String): List<NewsfeedItemMedia>? {
        val type = Types.newParameterizedType(List::class.java, NewsfeedItemMedia::class.java)
        val adapter = Moshi.Builder().build().adapter<List<NewsfeedItemMedia>>(type)
        return adapter.fromJson(json)
    }
}
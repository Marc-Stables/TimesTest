package com.example.timestest.data.model

import androidx.room.Embedded
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsfeedItemMedia (
    var type: String,
    var subtype: String,
    var caption: String,
    @Json(name = "media-metadata") var mediaMetadata: List<NewsfeedItemMediaMetadata>
)
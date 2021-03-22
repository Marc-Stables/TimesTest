package com.example.timestest.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class NewsfeedItemMediaMetadata (
    var url: String,
    var format: String,
    var height: Double,
    var width: Double
)
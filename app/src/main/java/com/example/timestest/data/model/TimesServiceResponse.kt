package com.example.timestest.data.model

import com.squareup.moshi.Json

class TimesServiceResponse (
        var status: String,
        var copyright: String,
        @Json(name = "num_results") var numResults: Int,
        var results: List<NewsfeedItem>
)
package com.example.timestest.data.source.remote

import com.example.timestest.data.model.TimesServiceResponse
import com.example.timestest.data.source.local.adapters.NewsfeedItemMediaAdapter
import com.example.timestest.data.source.local.adapters.NewsfeedItemMediaMetadataAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.nytimes.com/svc/"
private const val API_KEY = "HjbXhRhgXD6PNtKob8ifGwWZogP04sMa"

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .add(KotlinJsonAdapterFactory())
        .build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface TimesApiService {
    @GET("mostpopular/v2/viewed/1.json?api-key=${API_KEY}")
    suspend fun getMostPopular(): TimesServiceResponse
}

object TimesApi {
    val retrofitService: TimesApiService by lazy { retrofit.create(TimesApiService::class.java) }
}
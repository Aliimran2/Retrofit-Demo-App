package com.atom.retrofitdemoapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    //1. provide base url
    private val BASE_URL = "https://jsonplaceholder.typicode.com/"

    // 2. create apiService

    val apiService : PostApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }
}
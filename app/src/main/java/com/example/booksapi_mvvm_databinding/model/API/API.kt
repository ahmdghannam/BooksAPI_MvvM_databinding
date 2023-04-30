package com.example.booksapi_mvvm_databinding.model.API

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

class API {
    private val BASE_URL = "https://simple-books-api.glitch.me"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    val myApiService = retrofit.create(BookApiService::class.java)
}

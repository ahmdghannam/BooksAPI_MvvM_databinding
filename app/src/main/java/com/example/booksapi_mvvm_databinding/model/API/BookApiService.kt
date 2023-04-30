package com.example.booksapi_mvvm_databinding.model.API

import com.example.booksapi_mvvm_databinding.model.dto.Book
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BookApiService {
    @GET("/books/{bookId}")
    fun getBookData( @Path("bookId") bookId:Int): Single<Book>
}
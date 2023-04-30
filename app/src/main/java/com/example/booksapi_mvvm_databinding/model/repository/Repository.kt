package com.example.booksapi_mvvm_databinding.model.repository

import com.example.booksapi_mvvm_databinding.model.API.API
import com.example.booksapi_mvvm_databinding.model.dto.Book
import io.reactivex.rxjava3.core.Single

class Repository {
    private val bookApi = API()

    fun getBookById(bookId: Int): Single<Book> {
        return bookApi.myApiService.getBookData(bookId)
    }

}
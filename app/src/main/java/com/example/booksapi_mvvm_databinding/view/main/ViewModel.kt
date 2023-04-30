package com.example.booksapi_mvvm_databinding.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.booksapi_mvvm_databinding.model.State
import com.example.booksapi_mvvm_databinding.model.dto.Book
import com.example.booksapi_mvvm_databinding.model.repository.Repository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ViewModel : ViewModel() {

    private val repository = Repository()

    private val compositeDisposable = CompositeDisposable()

    private val _book = MutableLiveData<State<Book>>()
    val book: LiveData<State<Book>>
        get() = _book

    private val _toastMessage = MutableLiveData<String>()
    val toastMessage: LiveData<String>
        get() = _toastMessage


    fun getRandomBook() {
        _book.postValue(State.Loading)
        val randomNumber = (1..6).random()
        val a = repository.getBookById(randomNumber)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFailure)
        compositeDisposable.add(a)

    }

    private fun onSuccess(book: Book) {
        this._book.postValue(State.Success(book))
        _toastMessage.postValue("book fetched")
    }

    private fun onFailure(throwable: Throwable) {
        val message = throwable.message.toString()
        this._book.postValue(State.Error(message))
        _toastMessage.postValue(message)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}
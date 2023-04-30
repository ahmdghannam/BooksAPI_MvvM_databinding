package com.example.booksapi_mvvm_databinding.utils

import android.view.View
import androidx.databinding.BindingAdapter
import com.example.booksapi_mvvm_databinding.model.State

@BindingAdapter(value =["app:showWhenLoading"])
fun <T> View.showWhenLoading(state: State<T>?) {
    visibility = if (state is State.Loading) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }

}

@BindingAdapter(value =["app:showWhenError"])
fun <T> View.showWhenError(state: State<T>?) {
    visibility = if (state is State.Error) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }

}
@BindingAdapter(value =["app:showWhenSuccess"])
fun <T> View.showWhenSuccess(state: State<T>?) {
    visibility = if (state is State.Success) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }

}
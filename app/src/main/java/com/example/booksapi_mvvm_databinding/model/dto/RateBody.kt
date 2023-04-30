package com.example.booksapi_mvvm_databinding.model.dto

import com.google.gson.annotations.SerializedName

data class RateBody( // instead of using hashmap
    @SerializedName("value")
    val stars:Int,
)
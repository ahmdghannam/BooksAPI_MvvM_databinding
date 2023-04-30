package com.example.booksapi_mvvm_databinding.model.dto


import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("author")
    val author: String?,
    @SerializedName("available")
    val available: Boolean?,
    @SerializedName("current-stock")
    val currentStock: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: Double?,
    @SerializedName("type")
    val type: String?
)
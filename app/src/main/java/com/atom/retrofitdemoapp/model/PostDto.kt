package com.atom.retrofitdemoapp.model

data class PostDto(
    val userId: Int,
    val id: Int? = null,
    val title: String,
    val body: String
)

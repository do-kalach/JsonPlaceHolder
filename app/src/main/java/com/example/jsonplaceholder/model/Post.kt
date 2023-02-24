package com.example.jsonplaceholder.model

import com.squareup.moshi.Json


data class Post(
    @field:Json(name = "userId") val userId: Int,
    @field:Json(name = "title") var title: String?,
    @field:Json(name = "body") val text: String,
    @field:Json(name = "id") val id: Int
)
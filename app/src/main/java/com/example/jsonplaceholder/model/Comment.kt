package com.example.jsonplaceholder.model

import com.squareup.moshi.Json

data class Comment(
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    @field:Json(name = "body") val text: String
)
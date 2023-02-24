package com.example.jsonplaceholder.api

import com.example.jsonplaceholder.model.Post
import retrofit2.Response
import retrofit2.http.*

interface ModifyPost {

    @PUT("posts/{id}")
    fun putPost(@Path("id") id: Int, @Body post: Post): Response<Post>

    @PATCH("posts/{id}")
    fun patchPost(@Path("id") id: Int, @Body post: Post): Response<Post>

    @DELETE("posts/{id}")
    suspend fun deletePost(@Path("id") id: Int): Unit
}
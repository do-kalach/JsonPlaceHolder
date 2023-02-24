package com.example.jsonplaceholder.api

import com.example.jsonplaceholder.model.Comment
import com.example.jsonplaceholder.model.Post
import retrofit2.Response
import retrofit2.http.*

interface GetPosts {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts")
    suspend fun getPosts(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

    @GET("posts")
    suspend fun getPosts(@QueryMap parameters: Map<String, String>): Response<List<Post>>

    @GET("posts/{id}/comments")
    suspend fun getComments(@Path("id") postId: Int): Response<List<Comment>>

    @GET
    suspend fun getComments(@Url url: String?): Response<List<Comment>>
}
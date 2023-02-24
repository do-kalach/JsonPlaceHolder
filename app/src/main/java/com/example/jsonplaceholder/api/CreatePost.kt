package com.example.jsonplaceholder.api

import com.example.jsonplaceholder.model.Post
import retrofit2.Response
import retrofit2.http.*

interface CreatePost {

    @POST("posts")
    fun createPost(@Body post: Post): Response<Post>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(
        @Field("userId") userId: Int,
        @Field("title") title: String?,
        @Field("body") text: String?
    ): Response<Post>

    @FormUrlEncoded
    @POST("posts")
    fun createPost(@FieldMap fields: Map<String, String>): Response<Post>

}
package com.nikolavinci.retrofit.api

import com.nikolavinci.retrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SimpleApi {

    // Checking a single post on the Base URL
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    // Getting Posts from the URL Dynamically
    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>
}
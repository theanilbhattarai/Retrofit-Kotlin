package com.nikolavinci.retrofit.api

import com.nikolavinci.retrofit.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface SimpleApi {

    // Checking a single post on the Base URL
    @GET("posts/1")
    suspend fun getPost(): Response<Post>

    // Getting Posts from the URL Dynamically
    @GET("posts/{postNumber}")
    suspend fun getPost2(
        @Path("postNumber") number: Int
    ): Response<Post>

    // Adding Query
    @GET("posts")
    suspend fun getCustomPosts(
        @Query("userId") userId: Int,
        @Query("_sort") sort: String,
        @Query("_order") order: String
    ): Response<List<Post>>

    @GET("posts")
    suspend fun getCustomPosts2(
        @Query("userId") userId: Int,
        @QueryMap options: Map<String, String>
    ): Response<List<Post>>

}
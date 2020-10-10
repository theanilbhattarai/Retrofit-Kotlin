package com.nikolavinci.retrofit.repository

import com.nikolavinci.retrofit.api.RetrofitInstance
import com.nikolavinci.retrofit.model.Post
import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    suspend fun getPost(): Response<Post>{
        return RetrofitInstance.api.getPost()
    }
}
package com.example.redteapotdating.API

import com.example.redteapotdating.models.Users
import retrofit2.http.GET

interface RedTeapotDatingApiService {
    @GET("users")
    suspend fun getUsers(): List<Users>
}
package com.picpay.desafio.android.data.api.services

import com.picpay.desafio.android.data.api.responses.UserResponse
import retrofit2.http.GET


interface UserService {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>
}
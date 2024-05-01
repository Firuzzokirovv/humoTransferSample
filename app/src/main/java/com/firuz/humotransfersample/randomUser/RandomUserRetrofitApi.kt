package com.firuz.humotransfersample.randomUser

import com.firuz.humotransfersample.randomUser.model.RandomUserApiService
import com.firuz.humotransfersample.randomUser.model.User
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RandomUserRetrofitApi {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://randomuser.me/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val randomUserApiService = retrofit.create(RandomUserApiService::class.java)
    fun getUser(): Call<User> = randomUserApiService.getUser()

}
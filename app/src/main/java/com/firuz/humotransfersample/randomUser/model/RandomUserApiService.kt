package com.firuz.humotransfersample.randomUser.model

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

interface RandomUserApiService {
    @GET("?results=20")
    fun getUser(): Call<User>
}

data class User(
    @SerializedName("results")
    val results: List<ResultUser>
)

data class ResultUser(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("name")
    val name: Username,
    @SerializedName("email")
    val email: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("picture")
    val picture: Picture

)

data class Username(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)

data class Picture(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
)
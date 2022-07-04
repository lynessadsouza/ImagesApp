package com.example.imagesapp.Model.API

import com.example.example.Categories
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("v1/images/search?limit=100&page=10&order=Desc")
    fun getAllImages() : Call<List<Categories>>

    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                        .baseUrl("https://api.thecatapi.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}
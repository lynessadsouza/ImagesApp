package com.example.imagesapp.Repository

import com.example.imagesapp.Model.API.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllImages() = retrofitService.getAllImages()
}
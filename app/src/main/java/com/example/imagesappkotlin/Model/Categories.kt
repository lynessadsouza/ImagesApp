package com.example.example

import com.google.gson.annotations.SerializedName


data class Categories (

  @SerializedName("id"   ) var id   : Int?    = null,
  @SerializedName("name" ) var name : String? = null

)
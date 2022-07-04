package com.example.example

import com.google.gson.annotations.SerializedName
import java.util.*


data class ImageModelClass (

        @SerializedName("breeds"     ) var breeds     : ArrayList<String>? = null ,
        @SerializedName("categories" ) var categories : ArrayList<Categories>? = null,
        @SerializedName("id"         ) var id         : String?               = null,
        @SerializedName("url"        ) var url        : String?               = null,
        @SerializedName("width"      ) var width      : Int?                  = null,
        @SerializedName("height"     ) var height     : Int?                  = null

)
package com.example.catalgoscompose.models.dto

import com.google.gson.annotations.SerializedName


data class LocationDto (

    @SerializedName("name" ) var name : String? = null,
    @SerializedName("url"  ) var url  : String? = null

)

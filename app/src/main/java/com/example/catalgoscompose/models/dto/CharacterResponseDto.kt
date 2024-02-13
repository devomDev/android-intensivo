package com.example.catalgoscompose.models.dto

import com.google.gson.annotations.SerializedName

data class CharacterResponseDto(
    @SerializedName("info"    ) var info    : InfoDto?              = InfoDto(),
    @SerializedName("results" ) var results : ArrayList<CharacterDto> = arrayListOf()

)
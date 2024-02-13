package com.example.catalgoscompose.api

import com.example.catalgoscompose.models.dto.CharacterResponseDto
import com.example.catalgoscompose.util.CHARACTER_ENDPOINT
import retrofit2.http.GET

interface ApiClient {

    @GET(CHARACTER_ENDPOINT)
    suspend fun getAllCharacterApi(): CharacterResponseDto
}
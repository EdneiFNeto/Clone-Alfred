package com.example.clonealfred.data.api.service

import com.example.clonealfred.data.api.service.response.FilmResponse
import com.example.clonealfred.model.Film
import retrofit2.Call
import retrofit2.http.GET

interface FilmService {
    @GET("characters")
    fun getFilms(): Call<FilmResponse>
}

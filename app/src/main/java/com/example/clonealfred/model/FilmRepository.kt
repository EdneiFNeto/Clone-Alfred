package com.example.clonealfred.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.clonealfred.data.api.service.response.FilmResponse
import com.example.clonealfred.data.api.webservice.FilmWebClient

class FilmRepository(private val webClient: FilmWebClient) {

    private val liveData = MutableLiveData<FilmResponse?>()

    fun getFilms(): LiveData<FilmResponse?> {
        webClient.getFilms(quandoSucesso = {
            liveData.value = it
        }, quandoFalha = {
            liveData.value = null
        })

        return liveData
    }
}

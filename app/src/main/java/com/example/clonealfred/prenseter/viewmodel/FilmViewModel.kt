package com.example.clonealfred.prenseter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.clonealfred.data.api.service.response.FilmResponse
import com.example.clonealfred.model.FilmRepository
import com.example.clonealfred.model.Film

class FilmViewModel(
    private val repository: FilmRepository
) : ViewModel() {

    fun getFilms(): LiveData<FilmResponse?> {
        return repository.getFilms()
    }
}
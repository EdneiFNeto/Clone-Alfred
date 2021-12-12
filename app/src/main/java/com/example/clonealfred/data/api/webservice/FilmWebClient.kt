package com.example.clonealfred.data.api.webservice

import android.util.Log
import com.example.clonealfred.data.api.RetrofitInstance
import com.example.clonealfred.data.api.service.FilmService
import com.example.clonealfred.data.api.service.response.FilmResponse
import com.example.clonealfred.model.Film
import com.example.clonealfred.model.FilmRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FilmWebClient(private val service: FilmService = RetrofitInstance().filmService) {

    private fun <T> executaRequisicao(
        call: Call<T>,
        quandoSucesso: (T) -> Unit,
        quandoFalha: (String?) -> Unit
    ) {
        call.enqueue(object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    var body = response.body()
                    if (body != null)
                        quandoSucesso(body)
                } else {
                    quandoFalha(response.errorBody()?.string())
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable?) {
                t?.let {
                    quandoFalha(it.toString())
                }
            }
        })
    }

    fun getFilms(
        quandoSucesso: (films: FilmResponse) -> Unit,
        quandoFalha: (error: String?) -> Unit
    ) {
        executaRequisicao(service.getFilms(), quandoSucesso, quandoFalha)
    }

}

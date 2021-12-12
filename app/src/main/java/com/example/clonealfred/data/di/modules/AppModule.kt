package com.example.clonealfred.data.di.modules

import com.example.clonealfred.data.api.webservice.FilmWebClient
import com.example.clonealfred.model.FilmRepository
import com.example.clonealfred.prenseter.viewmodel.FilmViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val webService = module {
    single<FilmWebClient> { FilmWebClient() }
}

val repositoryModule = module {
    single<FilmRepository> { FilmRepository(get<FilmWebClient>()) }
}

val viewModelModule = module {
    viewModel { FilmViewModel(get<FilmRepository>()) }
}



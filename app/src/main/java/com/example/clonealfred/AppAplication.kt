package com.example.clonealfred

import android.app.Application
import com.example.clonealfred.data.di.modules.repositoryModule
import com.example.clonealfred.data.di.modules.viewModelModule
import com.example.clonealfred.data.di.modules.webService
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class AppAplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@AppAplication)
            modules(
                listOf(
                    webService,
                    repositoryModule,
                    viewModelModule
                )
            )
        }
    }
}
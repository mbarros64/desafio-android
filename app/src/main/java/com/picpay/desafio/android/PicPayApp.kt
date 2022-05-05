package com.picpay.desafio.android

import android.app.Application
import com.picpay.desafio.android.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.picpay.desafio.android.di.getApisModule

class PicPayApp : Application() {

    companion object {
        const val API_URL = "https://609a908e0f5a13001721b74e.mockapi.io/picpay/api/"
    }

    override fun onCreate() {
        super.onCreate()
        configKoin()
    }

    private fun configKoin() {
        startKoin {
            androidContext(this@PicPayApp)
            modules(appModule + getApisModule(API_URL))
        }
    }
}
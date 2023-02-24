package com.example.jsonplaceholder

import android.app.Application
import com.example.jsonplaceholder.api.Api

class App : Application() {
    fun provideApi(): Api = RetrofitProvider.buildService(Api::class.java)
}
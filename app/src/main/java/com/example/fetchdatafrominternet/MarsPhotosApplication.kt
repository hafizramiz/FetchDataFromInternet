package com.example.fetchdatafrominternet

import android.app.Application
import com.example.fetchdatafrominternet.data.AppContainer
import com.example.fetchdatafrominternet.data.DefaultAppContainer

class MarsPhotosApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container=DefaultAppContainer()
    }

}
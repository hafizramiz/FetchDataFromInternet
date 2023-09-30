package com.example.fetchdatafrominternet.data

import com.example.fetchdatafrominternet.network.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer {
    val marsPhotosRepository:MarsPhotosRepository
}

class DefaultAppContainer: AppContainer{
    // Base url ekle
    private  val baseUrl =
        "https://android-kotlin-fun-mars-server.appspot.com"

// Retrofitten bir nesne olusturan Builder'i ekle ekle


    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    // Bunu lazy ile yaptim. Cunku bu nesneye gercekten ihtiyac olana
//    kadar bunu olusturmayacak.Lazy init o demek oluyor.
    private val  retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
    override val marsPhotosRepository: MarsPhotosRepository by lazy{
        NetworkMarsPhotosRepository(retrofitService)
    }
}










package com.example.fetchdatafrominternet.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET

// Base url ekle
private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

// Retrofitten bir nesne olusturan Builder'i ekle ekle


private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface ApiService {

    // Bu fonksiyonu viewModelScope icinde cagircam. Bunu suspend yapmam gerekiyor.
    @GET ("photos")
    suspend  fun getPhotos(): List<MyModel>
}

// Burda singleton bir sinif yaptim. Bu siniftan retrofit servisi cagirip kullancam
object PhotosApi{
    // Bunu lazy ile yaptim. Cunku bu nesneye gercekten ihtiyac olana
//    kadar bunu olusturmayacak.Lazy init o demek oluyor.
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

// Simdi bunu yani web service'i viewModelde cagirip kullancam. Aslinda onerilen yaklasim
// Bunu repository katmanindan cagirmaktir.

/// Object Kullanimi. Object bir SIngleton nesne olusturmak icin kullanilir.













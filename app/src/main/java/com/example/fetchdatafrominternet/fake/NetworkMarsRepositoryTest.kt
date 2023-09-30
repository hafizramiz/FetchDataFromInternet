package com.example.fetchdatafrominternet.fake

import com.example.fetchdatafrominternet.data.NetworkMarsPhotosRepository
import org.jetbrains.annotations.TestOnly

class NetworkMarsRepositoryTest {
    @TestOnly
    fun networkMarsPhotosRepository_getMarsPhotos_verifyPhotoList(){
        val repository = NetworkMarsPhotosRepository(
            apiService = FakeApiService()
        )
    }
}
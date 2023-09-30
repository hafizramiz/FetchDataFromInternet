package com.example.fetchdatafrominternet.fake

import FakeDataSource
import com.example.fetchdatafrominternet.model.MyModel
import com.example.fetchdatafrominternet.network.ApiService

class FakeApiService: ApiService {
    override suspend fun getPhotos(): List<MyModel> {
        return FakeDataSource.photosList
    }
}
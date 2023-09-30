package com.example.fetchdatafrominternet.data

import com.example.fetchdatafrominternet.model.MyModel
import com.example.fetchdatafrominternet.network.ApiService

// Repository olustururken type of data + Repository  kullanimi yap. Isimlerndirmenin
// bu sekilde olmasina dikkat et
interface MarsPhotosRepository {
    // Burda bir abstract method tanimladim
    suspend fun getMarsPhotos(): List<MyModel>
}

class NetworkMarsPhotosRepository(private  val apiService: ApiService):MarsPhotosRepository{
    override suspend fun getMarsPhotos(): List<MyModel> =apiService.getPhotos()
        // Object sinifi ile tanimladigim sinif icindeki retrofitService icindeki getPhotos() metotunu
        // cagirdim.


}

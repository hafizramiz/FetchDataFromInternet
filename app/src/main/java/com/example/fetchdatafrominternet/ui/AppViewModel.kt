package com.example.fetchdatafrominternet.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fetchdatafrominternet.network.MyModel
import com.example.fetchdatafrominternet.network.PhotosApi
import kotlinx.coroutines.launch
import java.io.IOException

class AppViewModel : ViewModel() {
    // Ui State'i burda basitce tutcam.Tipini belirttim String olacak.
//    var appUiState: String by mutableStateOf("")
//        // Bunu ayrica private set yaptim ki disardan erisip de degistirilmesin
//        private set

    // Burda varsayilan olarak loading yaptim. Data gelince zaten otomatik olarak state degisecek.
    var appUiState:AppUiState by mutableStateOf(AppUiState.Loading)
        private set   // private set yaptim ki disardan erisilip degistirilmesin


    init {
        // init blogu icinde metotu cagircam ki state ilk olarak belirttigim state ile acilsin.
        getDataFromInternet()
        // Burda viewModelScope bir built in Functiondir. Biz burda suspend fonksiyonlari
        // cagirabiliriz. ViewModel temizlendiginde burda baslatilmis herhangi bir coroutine
//        de iptal edilir.
//        viewModelScope.launch {
            // Tek bir launch icinde yaparsam birincinin bitmesini bekliyor. Ayri launch icinde yazarsam
            // Fire and Forget mantigiyla calisiyor.

//        }

    }

    fun getDataFromInternet() {
        // Burda viewModelScope.launch ile cagircam. Bu metotda zaten init icerisinde caliscak
        viewModelScope.launch {
            // Bunun icinde ancak async calismasi icin suspend function olmasi gerekiyor.
//            PhotosApi.retrofitService
            // Bu PhotosApi daki retrofitService'i cagirdi. PhotosApi bir singleton objedir.
        // retrofitService isimli degisken bir retrofit objesi create ediyor.
            try {
                val modelListesi = PhotosApi.retrofitService.getPhotos()
                appUiState=AppUiState.Succes(modelListesi = modelListesi)
                println("model listesi: $modelListesi")
            }catch (e:IOException){
                println("hata olustu: ${e}")
                appUiState=AppUiState.Error
            }
        }
    }
}

sealed interface AppUiState{
    // Sealed classtan exten ediyorum.Burdaki butun classlari
    data class Succes(val modelListesi:List<MyModel>):AppUiState
    object Loading:AppUiState
    object Error: AppUiState
}




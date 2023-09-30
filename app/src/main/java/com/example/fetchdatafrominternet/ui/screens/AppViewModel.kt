package com.example.fetchdatafrominternet.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.fetchdatafrominternet.MarsPhotosApplication
import com.example.fetchdatafrominternet.data.MarsPhotosRepository
import com.example.fetchdatafrominternet.data.NetworkMarsPhotosRepository
import com.example.fetchdatafrominternet.model.MyModel
import kotlinx.coroutines.launch
import java.io.IOException


class AppViewModel(private val marsPhotosRepository: MarsPhotosRepository) : ViewModel() {


    // Ui State'i burda basitce tutcam.Tipini belirttim String olacak.
//    var appUiState: String by mutableStateOf("")
//        // Bunu ayrica private set yaptim ki disardan erisip de degistirilmesin
//        private set

    // Burda varsayilan olarak loading yaptim. Data gelince zaten otomatik olarak state degisecek.
    var appUiState: AppUiState by mutableStateOf(AppUiState.Loading)
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

    // Bu metot private olabilir. Cunku viewScope icinde cagircam.
      fun getDataFromInternet() {
        // Burda viewModelScope.launch ile cagircam. Bu metotda zaten init icerisinde caliscak
        viewModelScope.launch {
            // Bunun icinde ancak async calismasi icin suspend function olmasi gerekiyor.
//            PhotosApi.retrofitService
            // Bu PhotosApi daki retrofitService'i cagirdi. PhotosApi bir singleton objedir.
        // retrofitService isimli degisken bir retrofit objesi create ediyor.
            try {
//                val modelListesi = PhotosApi.retrofitService.getPhotos()
                // Burasi artik repository katmanindan veriyi cekecek.
                // Bu yuzden reporitory sinifindan bir nesne turetmem lazim

                //BURADA VIEW MODEL REPOSITORY'E BAGIMLIDIR. BIR CLASS BASKA BIR CLASS'A IHTIYAC DUYUYORSA
                // ISTE BUNA DEPENDENCY DIYORUZ. SIMDI BIZ BUNU ISTEMIYORUZ. BUNUN ICIN BIR CONTAINER TANIMLIYCAM
                //DEPENDENCIES LARI ORDA TUTCAM VE IHTIYAC OLAN SINIFA ORDAN PARAMETRE OLARAK TEMIN ETCEM.
                //  NEDEN BOYLE YAPCAM? CUNKU UYGULAMANIN HER YERINDEN BU DEPENDENCY"LERE IHTIYAC OLABILIR.
                // HEPSINE TEK BIR YERDEN TEMIN ETCEM.
                val modelListesi=marsPhotosRepository.getMarsPhotos()
                // Artik repository katmanina gidiyor.
                appUiState= AppUiState.Succes(marsPhotosRepository.getMarsPhotos())
                println("model listesi: $modelListesi")
            }catch (e:IOException){
                println("hata olustu: ${e}")
                appUiState= AppUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
                val marsPhotosRepository = application.container.marsPhotosRepository
                AppViewModel(marsPhotosRepository = marsPhotosRepository)
            }
        }
    }

}

sealed interface AppUiState{
    // Sealed classtan exten ediyorum.Burdaki butun classlari
    data class Succes(val modelListesi:List<MyModel>): AppUiState
    object Loading: AppUiState
    object Error: AppUiState
}


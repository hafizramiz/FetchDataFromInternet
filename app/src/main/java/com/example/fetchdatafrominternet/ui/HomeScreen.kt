package com.example.fetchdatafrominternet.ui

import androidx.compose.runtime.Composable
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(appUiState: AppUiState){

when (appUiState){
    is AppUiState.Succes -> {
       // println("elde edilen veri uzunlugu: ${appUiState.photos[0].}")
       return HomeComponent(modelListesi = appUiState.modelListesi)
    }

    is AppUiState.Loading->
        LoadingScreen()
    is AppUiState.Error->
        ErrorScreen()
}



}

suspend fun denemeFunc() {
    println(" denemeFunc basladi")

    delay(3000)
    println("Deneme fonk  bitti")

}

suspend fun denemeFunc1() {
    println(" denemeFunc1 basladi")
    delay(3000)
    println("Deneme fonk1 bitti")

}
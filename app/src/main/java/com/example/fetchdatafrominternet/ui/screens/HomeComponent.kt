package com.example.fetchdatafrominternet.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.fetchdatafrominternet.model.MyModel

// modelListesi yani elde edilen verilerin bir listesi. Kotlin objesine cevrilmis bir liste
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeComponent(modelListesi: List<MyModel>) {
    Box(
        contentAlignment = Alignment.Center
    ){
        LazyVerticalGrid(
            columns = GridCells.Adaptive(200.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(modelListesi.size) { modelItem ->
                    AsyncImage(
                        model = modelListesi[modelItem].imgUrl,
                        contentScale = ContentScale.Crop,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth().wrapContentHeight()
                    )
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}


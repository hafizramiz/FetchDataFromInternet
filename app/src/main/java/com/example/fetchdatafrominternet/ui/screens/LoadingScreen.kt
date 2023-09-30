package com.example.fetchdatafrominternet.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fetchdatafrominternet.R

@Composable

fun LoadingScreen(){
    Image(painter = painterResource(id = R.drawable.loading), contentDescription = "loading icon")
}
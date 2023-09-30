package com.example.fetchdatafrominternet.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyModel (
    @SerialName(value = "img_src")
    val imgUrl: String,
    val id:String,

)



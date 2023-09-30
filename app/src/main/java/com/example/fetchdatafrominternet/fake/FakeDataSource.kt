import com.example.fetchdatafrominternet.model.MyModel

object FakeDataSource {

    const val idOne = "img1"
    const val idTwo = "img2"
    const val imgOne = "url.1"
    const val imgTwo = "url.2"
    val photosList = listOf(
        MyModel(
            id = idOne,
            imgUrl = imgOne
        ),
        MyModel(
            id = idTwo,
            imgUrl = imgTwo
        )
    )
}
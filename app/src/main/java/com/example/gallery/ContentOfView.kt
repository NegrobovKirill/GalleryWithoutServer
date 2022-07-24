package com.example.gallery

import androidx.appcompat.app.AppCompatActivity
import com.example.gallery.picture.Picture
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

open class ContentOfView {

    val imageIdList = listOf(
        R.drawable.image_for_recycler1,
        R.drawable.image_for_recycler2,
        R.drawable.image_for_recycler3,
        R.drawable.image_for_recycler4,
        R.drawable.image_for_recycler5,
        R.drawable.image_for_recycler6
    )
    val titleIdList = listOf(
        "Первый день в Surf",
        "Самый милый корги",
        "Печенья которые приготовить",
        "Чашечка свежего кофе",
        "Карта в поезде",
        "Карта навигатор"
    )
    val discrIdList = listOf(
        surf,
        korgi,
        cake,
        cofe,
        cart,
        navigator,
    )
    val sdf = SimpleDateFormat("dd.MM.yyyy")
    val currentDate = sdf.format(Date())
    val dateInString = currentDate.toString()

}
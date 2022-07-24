package com.example.gallery.picture

import com.example.gallery.*
import java.io.Serializable
import java.text.SimpleDateFormat
import java.util.*

data class Picture (val imageId: Int, val title: String, val discription: String, val addTime: String) : Serializable
{

}



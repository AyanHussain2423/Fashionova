package com.example.fashionnova.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
@Parcelize
data class ItemDataItem(
    val category: String = "",
    val description: String = "",
    val id: Int = 0,
    val image: String = "",
    val price: Double = 0.0,
    val rating: Rating,
    val title: String = ""
): Parcelable{
    constructor() : this("","",0,"",0.0,Rating(),"")
}
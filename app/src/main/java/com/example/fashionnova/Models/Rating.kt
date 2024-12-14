package com.example.fashionnova.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable
@Parcelize
data class Rating(
    val count: Int = 0,
    val rate: Double = 0.0
): Parcelable{
    constructor() : this(0,0.0)
}
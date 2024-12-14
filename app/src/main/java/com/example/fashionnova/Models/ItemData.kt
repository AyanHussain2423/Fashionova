package com.example.fashionnova.Models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemData (
  val product : ArrayList<ItemDataItem>
): Parcelable
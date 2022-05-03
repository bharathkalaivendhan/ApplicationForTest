package com.example.myapplication

import android.os.Parcelable
import androidx.versionedparcelable.ParcelField
import kotlinx.parcelize.Parcelize
import java.io.Serializable

//@Parcelize
data class Jewellery(val JewellryName: String, val Price: String, val Category: String /*, val Discription: String*/) : Serializable


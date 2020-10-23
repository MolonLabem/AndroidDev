package com.example.lab4.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mail(
    val title: String,
    val sender: String,
    val date: String,
    val description: String,
    val category: String
) : Parcelable
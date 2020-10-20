package com.example.midterm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ToDoItem(
    val id: Int,
    val title: String,
    val description: String? = "ToDo Description",
    val status: String? = "ToDo Status",
    val category: String? = "ToDo Category",
    val duration: Int? = 60
) : Parcelable
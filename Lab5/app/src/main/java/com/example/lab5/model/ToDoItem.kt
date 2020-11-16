package com.example.lab5.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDoTable")
data class ToDoItem(
    @PrimaryKey(autoGenerate = true) val id: Int? = 0,
    @ColumnInfo(name = "title")
    val title: String? = "",
    @ColumnInfo(name = "status")
    val status: String? = "ToDo Status",
    @ColumnInfo(name = "description")
    val description: String? = "ToDo Description",
    @ColumnInfo(name = "category")
    val category: String? = "ToDo Category",
    @ColumnInfo(name = "duration")
    val duration: Int? = 60
)


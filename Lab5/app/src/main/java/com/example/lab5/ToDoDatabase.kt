package com.example.lab5

import androidx.room.*
import android.content.Context
import com.example.lab5.model.ToDoItem

@Database(entities = [ToDoItem::class], version = 1, exportSchema = false)
abstract class ToDoDatabase: RoomDatabase(){

    abstract fun getDaoInterface(): DaoInterface

    companion object {
        val databaseName = "tododatabase"
        var todoListDatabase: ToDoDatabase? = null

        fun getInstance(context: Context): ToDoDatabase?{
            if (todoListDatabase == null){
                todoListDatabase = Room.databaseBuilder(context,
                    ToDoDatabase::class.java,
                    ToDoDatabase.databaseName)
                    .allowMainThreadQueries()
                    .build()
            }
            return todoListDatabase
        }
    }
}
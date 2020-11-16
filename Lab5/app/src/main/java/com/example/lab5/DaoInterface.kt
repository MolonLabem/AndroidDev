package com.example.lab5

import androidx.room.*
import com.example.lab5.model.ToDoItem

@Dao
interface DaoInterface {
    @Query("SELECT*FROM ToDoTable ORDER BY id ASC")
    fun getTodoList(): List<ToDoItem>

    @Query("SELECT*FROM ToDoTable WHERE id=:id")
    fun getTodoItem(id: Int): ToDoItem

    @Query("SELECT title, status, category FROM ToDoTable WHERE id=:id")
    fun getTodoShortDesc(id: Int): ToDoItem

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveTodo(todo: ToDoItem)

    @Update
    fun updateTodo(todo: ToDoItem)

    @Delete
    fun removeTodo(todo: ToDoItem)
}
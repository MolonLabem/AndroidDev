package com.example.lab5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab5.fragment.ToDoListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ToDoDatabase = ToDoListDatabase.getInstance(this)
        ToDoAdapter = ToDoAdapter()
        ToDoAdapter?.setTodoItemClickedListener(this)

        moveToToDoListFragment()
    }

    private fun moveToToDoListFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ToDoListFragment.newInstance())
            .commit()
    }
}

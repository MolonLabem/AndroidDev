package com.example.midterm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.midterm.fragment.ToDoListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToToDoListFragment()
    }

    private fun moveToToDoListFragment() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ToDoListFragment.newInstance())
            .commit()
    }
}

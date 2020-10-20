package com.example.midterm.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.midterm.R
import kotlinx.android.synthetic.main.fragment_add_to_do.*

class AddToDoFragment : Fragment() {

    companion object {
        fun newInstance() = AddToDoFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("OnViewCreated", "true")

        addButton.setOnClickListener {
            val id = idEditText.text
            val title = titleEditText.text
            moveToItemDetails(id.toString().toInt(), title.toString())
        }

    }

    private fun moveToItemDetails(id: Int, title: String) {
        val fragment = ToDoListFragment.newInstance(id, title)
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, fragment)
            ?.addToBackStack(fragment.tag)
            ?.commit()
    }
}

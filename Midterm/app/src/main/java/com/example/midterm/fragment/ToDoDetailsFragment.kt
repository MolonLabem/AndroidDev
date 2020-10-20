package com.example.midterm.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.midterm.R
import com.example.midterm.model.ToDoItem
import kotlinx.android.synthetic.main.fragment_item_details.*

class ToDoDetailsFragment: Fragment() {

    companion object {
        const val ARG_TO_DO_ITEM = "toDoItem"

        fun newInstance(toDoItem: ToDoItem) = ToDoDetailsFragment().apply {
            arguments = bundleOf(ARG_TO_DO_ITEM to toDoItem)
        }
    }

    private val toDoInfo: ToDoItem by lazy {
        arguments?.getParcelable<ToDoItem>(ARG_TO_DO_ITEM) as ToDoItem
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_item_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        titleTextView.text = toDoInfo.title
        descriptionTextView.text = toDoInfo.description
        statusTextView.text = toDoInfo.status
        categoryTextView.text = toDoInfo.category
        durationTextView.text = toDoInfo.duration.toString()
    }
}
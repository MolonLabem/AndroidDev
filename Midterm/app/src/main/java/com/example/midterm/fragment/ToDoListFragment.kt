package com.example.midterm.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.midterm.adapter.Adapter
import com.example.midterm.R
import com.example.midterm.model.ToDoItem
import kotlinx.android.synthetic.main.fragment_item_list.*

class ToDoListFragment : Fragment() {

    private var toDoAdapter: Adapter? = null

    companion object {
        const val ARG_TO_DO_ID = "toDoParams"
        const val ARG_TO_DO_TITLE = "toDoTitle"

        fun newInstance() = ToDoListFragment()

        fun newInstance(id: Int, title: String) = ToDoListFragment().apply {
            arguments = bundleOf(ARG_TO_DO_ID to id, ARG_TO_DO_TITLE to title)
        }
    }

    private var id: Int? = null
    private var title: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("OnViewCreated", "true")
        addToDo.setOnClickListener {
            goToAddFragment()
        }
        arguments?.let {
            id = it.getInt(ARG_TO_DO_ID)
            title = it.getString(ARG_TO_DO_TITLE)
        }
        if (id != null && title != null)
            setupItemList(id, title)
        else setupItemList()
    }

    private fun setupItemList(id: Int? = null, title: String? = null) {
        val toDoList: MutableList<ToDoItem> = mutableListOf()
        with(toDoList) {
            add(
                ToDoItem(
                    id = 0,
                    title = "Do homework",
                    description = "React JS project",
                    status = "Urgent",
                    category = "Homework",
                    duration = 60
                )
            )
            add(
                ToDoItem(
                    id = 1,
                    title = "Go to the gym",
                    description = "100 push-ups",
                    status = "Not urgent",
                    category = "Health",
                    duration = 60
                )
            )
            add(
                ToDoItem(
                    id = 2,
                    title = "Example",
                    description = "Example",
                    status = "Example",
                    category = "Example",
                    duration = 60
                )
            )
            if (id != null && title != null) {
                add(
                    ToDoItem(
                        id = id,
                        title = title
                    )
                )
            }
        }
        toDoAdapter = Adapter(
            toDoClickListener = {
                moveToItemDetails(toDoList[it])
            }
        )
        val manager = LinearLayoutManager(context)
        itemsRecyclerView.apply {
            layoutManager = manager
            adapter = toDoAdapter
        }
        toDoAdapter?.addItems(toDoList)
    }

    private fun goToAddFragment() {
        val fragment = AddToDoFragment.newInstance()
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, fragment)
            ?.addToBackStack(fragment.tag)
            ?.commit()
    }

    private fun moveToItemDetails(item: ToDoItem) {
        val fragment = ToDoDetailsFragment.newInstance(item)
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, fragment)
            ?.addToBackStack(fragment.tag)
            ?.commit()
    }
}

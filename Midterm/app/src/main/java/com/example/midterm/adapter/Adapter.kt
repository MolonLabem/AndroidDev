package com.example.midterm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.midterm.R
import com.example.midterm.model.ToDoItem
import kotlinx.android.synthetic.main.item.view.*

class Adapter constructor(private val toDoClickListener: (position: Int) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var toDoList: MutableList<ToDoItem> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ToDoViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ToDoViewHolder).bind(toDoList[position], toDoClickListener)

    }

    fun addItems(list: List<ToDoItem>) {
        toDoList.clear()
        toDoList.addAll(list)
        notifyDataSetChanged()
    }

    fun addItems(toDoItem: ToDoItem) {
        toDoList.add(toDoItem)
        notifyDataSetChanged()
    }

    private class ToDoViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item, parent, false)) {

        private val title = itemView.titleTextView
        private val status = itemView.statusTextView
        private val category = itemView.categoryTextView
        private val itemLayout = itemView.itemLayout

        fun bind(toDoItem: ToDoItem, toDoClickListener: (position: Int) -> Unit) {
            title.text = toDoItem.title
            status.text = toDoItem.status
            category.text = toDoItem.category

            itemLayout.setOnClickListener {
                toDoClickListener(adapterPosition)
            }
        }

    }
}
package com.example.lab4

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.model.Mail
import kotlinx.android.synthetic.main.mail_list_fragment.view.*

class Adapter constructor(private val messageClickListener: (text:String) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var messageList:MutableList<Mail> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ContactViewHolder).bind(messageList[position], messageClickListener)

    }

    fun addItems(list: List<Mail>){
        messageList.clear()
        messageList.addAll(list)
        notifyDataSetChanged()
    }

    private class ContactViewHolder(inflater: LayoutInflater, parent: ViewGroup):
        RecyclerView.ViewHolder(inflater.inflate(R.layout.mail_list_fragment, parent, false)){

        private val senderTextView = itemView.senderTextView
        private val titleTextView = itemView.titleTextView
        private val dateTextView = itemView.dateTextView
        private val descriptionTextView = itemView.descriptionTextView
        private val itemLayout = itemView.itemLayout

        fun bind(mail:Mail, messageClickListener: (text: String) -> Unit){
            senderTextView.text = mail.sender
            titleTextView.text = mail.title
            dateTextView.text = mail.date
//          descriptionTextView.text = mail.description
            itemLayout.setOnClickListener {
                messageClickListener(mail.description)
            }
        }

    }
}
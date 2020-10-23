package com.example.lab4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab4.model.Mail
import kotlinx.android.synthetic.main.item_in_list.*

class ShortMailFragment(): Fragment() {

    private var messageAdapter: Adapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.item_in_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val messages:MutableList<Mail> = mutableListOf()
        messages.add(Mail("Totaly not a phishing mail!", "Your mom", "Oct 25", "Hello, my dear son, you've won $1000", "Spam"))
        messages.add(Mail("Instagram", "Instagram official", "Oct 27", "MolonLabe, you have been liked by 5 poeple!", "Social"))
        messages.add(Mail("Пакет вопросов Синхрон-Lite", "Dinabank", "Sept 20","Вы получили пакет по подписке динабанк", "Urgent"))
        messages.add(Mail("Электронный чек 24123", "Wolt", "Oct 23", "Ваш электронный чек доступен здесь", "Food"))
        messages.add(Mail("Security alert for your liked Google Account", "LeetCode", "Oct 15","New sign-in to your linked account","Google"))
        messages.add(Mail("WARTILE and 5 other items from your Steam wishlist are now available!", "Steam", "Sept 19", "SAVE NOW ON 6 GAMES YOU’VE WISHED FOR!", "Games"))

        messageAdapter = Adapter(
            messageClickListener = {
                this.goToMailDetails(it)
            }
        )
        val manager = LinearLayoutManager(context)
        messageRecyclerView.apply {
            layoutManager = manager
            adapter = messageAdapter
        }
        messageAdapter?.addItems(messages)


    }

    private fun goToMailDetails(text:String){
        fragmentManager
            ?.beginTransaction()
            ?.replace(R.id.right, MailDetailFrag.create(text))
            ?.apply { addToBackStack(this::class.java.simpleName) }
            ?.commit()
    }


}
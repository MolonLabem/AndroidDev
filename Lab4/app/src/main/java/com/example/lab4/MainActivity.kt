package com.example.lab4

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        logoutButton.setOnClickListener {
            goToLoginPage()
        }
    }

    private fun init() {
        val fragmentMail = ShortMailFragment()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.left, fragmentMail)
        fragmentTransaction.commit()
    }

    private fun logout() {
        LoginActivity().clear()
    }

    private fun goToLoginPage() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.putExtra("exitStatus", true)
        startActivity(intent)
    }
}
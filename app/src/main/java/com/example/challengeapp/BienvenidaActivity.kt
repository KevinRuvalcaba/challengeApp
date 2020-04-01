package com.example.challengeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.os.Handler

class BienvenidaActivity : AppCompatActivity() {
    private val TIME: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java )
            )}, TIME)
    }
}


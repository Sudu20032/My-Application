package com.example.uploadimageapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Welcome2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_welcome2)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@Welcome2, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 5000)
    }
}


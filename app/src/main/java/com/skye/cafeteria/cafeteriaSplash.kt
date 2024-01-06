package com.skye.cafeteria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class cafeteriaSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_cafeteria_splash)
        //startActivity(Intent(this, MainActivity::class.java))
        startActivity(Intent(this, LoginActivity::class.java))

    }
}
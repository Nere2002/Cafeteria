package com.skye.cafeteria

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.skye.cafeteria.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate")

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Configurar el listener para el BottomNavigationView
        binding.bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            val navController = supportFragmentManager.findFragmentById(R.id.navHostFragment)?.findNavController()

            when (item.itemId) {
                R.id.action_comida -> {
                    navController?.navigate(R.id.comidaFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_bebida -> {
                    navController?.navigate(R.id.bebidaFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.action_pagar -> {
                    navController?.navigate(R.id.pagarFragment)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> return@setOnNavigationItemSelectedListener false
            }
        }

    }
}

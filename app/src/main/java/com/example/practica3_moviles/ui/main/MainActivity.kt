package com.example.practica3_moviles.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica3_moviles.R
import com.example.practica3_moviles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainBinding.buttonCuadrado.setOnClickListener{
            goToSquare()
        }
    }

    private fun goToSquare(){
        val intent = Intent(this, ActivityCuadrado::class.java)
        startActivity(intent)
    }
}
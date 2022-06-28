package com.example.practica3_moviles.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.practica3_moviles.R
import com.example.practica3_moviles.databinding.ActivityMainBinding
import com.example.practica3_moviles.databinding.ActivityMainCirculoBinding

class MainActivity_circulo : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainCirculoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainCirculoBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

    }
}
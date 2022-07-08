package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica3_moviles.databinding.ActivityCuadradoBinding

private lateinit var cuadradoBinding: ActivityCuadradoBinding

class ActivityCuadrado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cuadrado)
    }
}
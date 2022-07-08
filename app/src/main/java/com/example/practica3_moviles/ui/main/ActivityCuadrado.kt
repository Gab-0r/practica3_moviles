package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.practica3_moviles.databinding.ActivityCuadradoBinding

class ActivityCuadrado : AppCompatActivity() {
    private lateinit var cuadradoBinding: ActivityCuadradoBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cuadradoBinding = ActivityCuadradoBinding.inflate(layoutInflater)
        val view = cuadradoBinding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

    }
}
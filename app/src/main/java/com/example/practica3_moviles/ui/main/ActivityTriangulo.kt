package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica3_moviles.databinding.ActivityTrianguloBinding
import androidx.lifecycle.ViewModelProvider

class ActivityTriangulo : AppCompatActivity() {

    private lateinit var viewModel: ViewModelTriangulo
    private lateinit var activityBinding: ActivityTrianguloBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        activityBinding = ActivityTrianguloBinding.inflate(layoutInflater)//colocado la actividad principal
        val view = activityBinding.root //colocado la actividad principal
        setContentView(view)

        //Parte del ViewModel
        viewModel = ViewModelProvider(this)[ViewModelTriangulo::class.java]

        viewModel.CalculoTrianguloDone.observe(this){ Data ->
            activityBinding.textViewTrianguloResultado.text = Data// envio el resultado
        }

        activityBinding.buttonTrianguloCalcular.setOnClickListener {
            val ladoA = activityBinding.TextInputTLadoA.text.toString()
            val ladoB = activityBinding.TextInputTLadoB.text.toString()
            val ladoC = activityBinding.TextInputTLadoC.text.toString()
            viewModel.Calucular_Triangulo(ladoA,ladoB,ladoC)
        }


    }


}
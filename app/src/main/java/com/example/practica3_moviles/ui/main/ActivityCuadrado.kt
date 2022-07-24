package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.practica3_moviles.databinding.ActivityCuadradoBinding

class ActivityCuadrado : AppCompatActivity() {
    private lateinit var cuadradoBinding: ActivityCuadradoBinding
    private lateinit var viewModel: CuadradoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        cuadradoBinding = ActivityCuadradoBinding.inflate(layoutInflater)
        val view = cuadradoBinding.root
        setContentView(view)

        viewModel = ViewModelProvider(this)[CuadradoViewModel::class.java]

        viewModel.cuadrado_areaDone.observe(this){
            cuadradoBinding.textViewResultArea.text = "Área del cuadrado: " + it.toString() + " m2"
        }

        viewModel.cuadrado_perimetroDone.observe(this){
            cuadradoBinding.textViewResultPer.text = "Perímetro del cuadrado: " + it.toString() + " m"
        }

        cuadradoBinding.buttonCalcCuadrado.setOnClickListener(){
            viewModel.setCuadradoLado(cuadradoBinding.textInputCuadradoLado.text.toString().toFloat())
            viewModel.calcCuadrado()
        }
    }
}
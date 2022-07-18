package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.practica3_moviles.databinding.ActivityPentagonoBinding

class PentagonoActivity : AppCompatActivity() {
    private lateinit var pentagonoBinding: ActivityPentagonoBinding
    private lateinit var pentagonoViewModel: PentagonoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pentagonoBinding = ActivityPentagonoBinding.inflate(layoutInflater)
        val view = pentagonoBinding.root
        setContentView(view)

        pentagonoViewModel = ViewModelProvider(this)[PentagonoViewModel::class.java]

        with(pentagonoBinding){
            pentagonoViewModel.perimetroLiveData_pentagono.observe(this@PentagonoActivity){
                    perimetro_pentagono ->
                perimetroTextView.text = perimetro_pentagono.toString()
            }

            pentagonoViewModel.areaLiveData_pentagono.observe(this@PentagonoActivity){
                    area_pentagono ->
                areaTextView.text = area_pentagono.toString()
            }

            operateButton.setOnClickListener {
                val width = widthEditText.text.toString()
                val height = heightEditText.text.toString()

                pentagonoViewModel.getResult(width, height)
            }
        }
    }
}
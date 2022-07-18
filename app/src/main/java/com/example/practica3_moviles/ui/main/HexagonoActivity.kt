package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.practica3_moviles.databinding.ActivityHexagonoBinding

class HexagonoActivity : AppCompatActivity() {
    private lateinit var hexagonoBinding: ActivityHexagonoBinding
    private lateinit var hexagonoViewModel: HexagonoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hexagonoBinding = ActivityHexagonoBinding.inflate(layoutInflater)
        val view = hexagonoBinding.root
        setContentView(view)

        hexagonoViewModel = ViewModelProvider(this)[HexagonoViewModel::class.java]

        with(hexagonoBinding){
            hexagonoViewModel.perimetroLiveData_hexagono.observe(this@HexagonoActivity){
                    perimetro_hexagono ->
                perimetroTextView.text = perimetro_hexagono.toString()
            }

            hexagonoViewModel.areaLiveData_hexagono.observe(this@HexagonoActivity){
                    area_hexagono ->
                areaTextView.text = area_hexagono.toString()
            }

            operateButton.setOnClickListener {
                val width = widthEditText.text.toString()
                val height = heightEditText.text.toString()

                hexagonoViewModel.getResult(width, height)
            }
        }
    }
}
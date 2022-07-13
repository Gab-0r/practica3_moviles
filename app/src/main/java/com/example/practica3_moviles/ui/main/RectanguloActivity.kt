package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.practica3_moviles.databinding.ActivityRectanguloBinding

class RectanguloActivity : AppCompatActivity() {
    private lateinit var rectanguloBinding: ActivityRectanguloBinding
    private lateinit var rectanguloViewModel: RectanguloViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rectanguloBinding = ActivityRectanguloBinding.inflate(layoutInflater)
        val view = rectanguloBinding.root
        setContentView(view)

        rectanguloViewModel = ViewModelProvider(this)[RectanguloViewModel::class.java]

        with(rectanguloBinding){
            rectanguloViewModel.perimetroLiveData_rectangulo.observe(this@RectanguloActivity){
                    perimetro_rectangulo ->
                perimetroTextView.text = perimetro_rectangulo.toString()
            }

            rectanguloViewModel.areaLiveData_rectangulo.observe(this@RectanguloActivity){
                    area_rectangulo ->
                areaTextView.text = area_rectangulo.toString()
            }

            operateButton.setOnClickListener {
                val width = widthEditText.text.toString()
                val height = heightEditText.text.toString()

                rectanguloViewModel.getResult(width, height)
            }
        }
    }
}
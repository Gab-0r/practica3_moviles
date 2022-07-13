package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.practica3_moviles.databinding.ActivityRectanguloBinding

class RectanguloActivity : AppCompatActivity() {
    private lateinit var rectanguloBinding: ActivityRectanguloBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rectanguloBinding = ActivityRectanguloBinding.inflate(layoutInflater)
        val view = rectanguloBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        with(rectanguloBinding){
            mainViewModel.perimetroLiveData_rectangulo.observe(this@RectanguloActivity){
                    perimetro_rectangulo ->
                perimetroTextView.text = perimetro_rectangulo.toString()
            }

            mainViewModel.areaLiveData_rectangulo.observe(this@RectanguloActivity){
                    area_rectangulo ->
                areaTextView.text = area_rectangulo.toString()
            }

            operateButton.setOnClickListener {
                val width = widthEditText.text.toString()
                val height = heightEditText.text.toString()

                mainViewModel.getResult(width, height)
            }
        }
    }
}
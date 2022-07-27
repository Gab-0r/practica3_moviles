package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.practica3_moviles.R
import com.example.practica3_moviles.databinding.ActivityRectanguloBinding
import java.util.*
import kotlin.concurrent.timerTask

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

            rectanguloViewModel.isEmptyWidthLiveData_rectangulo.observe(this@RectanguloActivity){
                showWarning(widthEditText)
            }

            rectanguloViewModel.isEmptyHeightLiveData_rectangulo.observe(this@RectanguloActivity){
                    showWarning(heightEditText)
            }

            operateButton.setOnClickListener {
                val width = widthEditText.text.toString()
                val height = heightEditText.text.toString()

                rectanguloViewModel.getResult(width, height)
            }
        }
    }
    private fun showWarning(view: EditText){
        val timer = Timer()
        view.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.Red_rectangulo))
        timer.schedule(
            timerTask {
                view.setBackgroundResource(R.drawable.input_rectangulo)
            }
            ,1000
        )
    }
}
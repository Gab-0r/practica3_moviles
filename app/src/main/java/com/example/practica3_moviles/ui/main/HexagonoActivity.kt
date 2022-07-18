package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.practica3_moviles.R
import com.example.practica3_moviles.databinding.ActivityHexagonoBinding
import java.util.*
import kotlin.concurrent.timerTask

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

            hexagonoViewModel.isEmptyApothemLiveData_hexagono.observe(this@HexagonoActivity){
                    isEmptyApothem_hexagono->
                if(isEmptyApothem_hexagono){
                    showWarning(apothemEditText)
                }
            }

            hexagonoViewModel.isEmptyLengthLiveData_hexagono.observe(this@HexagonoActivity){
                    isEmptyLength_hexagono->
                if(isEmptyLength_hexagono){
                    showWarning(lengthEditText)
                }
            }

            operateButton.setOnClickListener {
                val width = apothemEditText.text.toString()
                val height = lengthEditText.text.toString()

                hexagonoViewModel.getResult(width, height)
            }
        }
    }

    private fun showWarning(view: EditText){
        val timer = Timer()
        view.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.Red_hexagono))
        timer.schedule(
            timerTask {
                view.setBackgroundResource(R.drawable.input_hexagono)
            }
        ,1000
        )
    }
}
package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.practica3_moviles.R
import com.example.practica3_moviles.databinding.ActivityPentagonoBinding
import java.util.*
import kotlin.concurrent.timerTask

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

            pentagonoViewModel.isEmptyApothemLiveData_pentagono.observe(this@PentagonoActivity){
                showWarning(apothemEditText)
            }

            pentagonoViewModel.isEmptyLengthLiveData_pentagono.observe(this@PentagonoActivity){
                showWarning(lengthEditText)
            }

            operateButton.setOnClickListener {
                val apothem = apothemEditText.text.toString()
                val length = lengthEditText.text.toString()

                pentagonoViewModel.getResult(apothem, length)
            }
        }
    }
    private fun showWarning(view: EditText){
        val timer = Timer()
        view.setBackgroundColor(ContextCompat.getColor(applicationContext, R.color.Red_pentagono))
        timer.schedule(
            timerTask {
                view.setBackgroundResource(R.drawable.input_pentagono)
            }
            ,1000
        )
    }
}
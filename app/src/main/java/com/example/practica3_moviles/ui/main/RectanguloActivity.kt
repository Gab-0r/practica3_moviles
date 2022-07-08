package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica3_moviles.databinding.ActivityRectanguloBinding

class RectanguloActivity : AppCompatActivity() {
    private lateinit var rectanguloBinding: ActivityRectanguloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rectanguloBinding = ActivityRectanguloBinding.inflate(layoutInflater)
        val view = rectanguloBinding.root
        setContentView(view)

        with(rectanguloBinding){
            resultTextView.text = ""
        }
    }
}
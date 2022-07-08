package com.example.practica3_moviles.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica3_moviles.databinding.ActivityRectanguloBinding

class RectanguloActivity : AppCompatActivity() {
    private lateinit var rectanguloActivity: ActivityRectanguloBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rectanguloActivity = ActivityRectanguloBinding.inflate(layoutInflater)
        val view = rectanguloActivity.root
        setContentView(view)
    }
}
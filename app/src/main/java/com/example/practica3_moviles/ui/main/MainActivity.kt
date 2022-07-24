package com.example.practica3_moviles.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica3_moviles.R
import com.example.practica3_moviles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)//colocado la actividad principal
        val view = mainBinding.root //colocado la actividad principal
        setContentView(view)

        mainBinding.buttonTriangulo.setOnClickListener {
            irActividadTriangulo()
        }

        mainBinding.buttonCuadrado.setOnClickListener{
            goToSquare()
        }
        mainBinding.buttonCirculo.setOnClickListener {
            irActividadCirculo()
        }
    }

    private fun goToSquare(){
        val intent = Intent(this, ActivityCuadrado::class.java)
        startActivity(intent)
    }

    private fun irActividadTriangulo() {// funcion para lanzar la actividad triangulo
        val intent =
            Intent(this, ActivityTriangulo::class.java) //a intent le asigno la actividad
        startActivity(intent) // me voy a ala actividad
    }
    private fun irActividadCirculo() {// funcion para lanzar la actividad triangulo
        val intent =
            Intent(this, ActivityCirculo::class.java) //a intent le asigno la actividad
        startActivity(intent) // me voy a ala actividad
    }
}
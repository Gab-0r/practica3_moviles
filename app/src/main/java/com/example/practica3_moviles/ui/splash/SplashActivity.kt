package com.example.practica3_moviles.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica3_moviles.databinding.ActivitySplashBinding
import com.example.practica3_moviles.ui.main.MainActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : AppCompatActivity() {

    private lateinit var splashBinding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        splashBinding = ActivitySplashBinding.inflate(layoutInflater) //colocado la actividad
        val view = splashBinding.root //colocado la actividad
        setContentView(view)

        val tiempo = Timer() //hago un delay para el inicio de la otra app
        tiempo.schedule(timerTask { irActividadPrincipal() },1000)
    }

    private fun irActividadPrincipal() {// funcion para lanzar la actividad principal
        val intent =
            Intent(this, MainActivity::class.java) //a intent le asigo la actividad principal
        startActivity(intent) // me voy a ala actividad principal
        finish()// destrullo la actividad de inicio
    }
}
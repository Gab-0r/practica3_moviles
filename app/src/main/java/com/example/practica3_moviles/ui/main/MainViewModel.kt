package com.example.practica3_moviles.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.sqrt


class MainViewModel: ViewModel() {

    private val CalculoTriangulo: MutableLiveData<String> = MutableLiveData()
    val CalculoTrianguloDone: LiveData<String> = CalculoTriangulo

    //funciones para trabajar

    fun Calucular_Triangulo(ladoA: String, ladoB: String, ladoC: String){

        val a = ladoA.toDouble()
        val b = ladoB.toDouble()
        val c = ladoC.toDouble()

        val area: Double
        val perimetro: Double
        val s = (a+b+c)/2

        area = sqrt(s*((s-a)*(s-b)*(s-c)))
        perimetro = 2*s

        CalculoTriangulo.value = " Area: $area \n Perimetro: $perimetro"
    }


}
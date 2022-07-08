package com.example.practica3_moviles.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var cuadrado_lado = 0f

    private val cuadrado_area: MutableLiveData<Float> = MutableLiveData()
    val cuadrado_areaDone: LiveData<Float> = cuadrado_area

    private val cuadrado_perimetro: MutableLiveData<Float> = MutableLiveData()
    val cuadrado_perimetroDone: LiveData<Float> = cuadrado_perimetro

    private fun getCuadradoArea(lado: Float){
        cuadrado_area.value = cuadrado_lado * cuadrado_lado
    }

    private fun getCuadradoPerimetro(lado: Float){
        cuadrado_perimetro.value = cuadrado_lado * 4
    }

    fun calcCuadrado(){
        getCuadradoArea(cuadrado_lado)
        getCuadradoPerimetro(cuadrado_lado)
    }

    fun setCuadradoLado(lado: Float){
        cuadrado_lado = lado
    }
}
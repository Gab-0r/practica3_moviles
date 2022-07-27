package com.example.practica3_moviles.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.math.sqrt


class ViewModelTriangulo: ViewModel() {

    private val CalculoTriangulo: MutableLiveData<String> = MutableLiveData()
    val CalculoTrianguloDone: LiveData<String> = CalculoTriangulo

    private val Error : MutableLiveData<String> = MutableLiveData()
    val error : LiveData<String> = Error

    //funciones para trabajar

    fun Calucular_Triangulo(ladoA: String, ladoB: String, ladoC: String){

        if (ladoA.isEmpty() || ladoB.isEmpty() || ladoC.isEmpty()){
            Error.value = "Faltan datos"
            return
        }
        else{
            val a = ladoA.toDouble()
            val b = ladoB.toDouble()
            val c = ladoC.toDouble()

            val area: Double
            val perimetro: Double
            val s = (a+b+c)/2
            val raiz = s*((s-a)*(s-b)*(s-c))
            if (raiz >= 0){
                area = sqrt(raiz)
                perimetro = 2*s
                CalculoTriangulo.value = " Area: $area \n Perimetro: $perimetro"
            }else{
                Error.value = "Datos del triangulo no validos"
            }
        }
    }

}
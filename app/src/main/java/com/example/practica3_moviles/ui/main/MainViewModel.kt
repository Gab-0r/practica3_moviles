package com.example.practica3_moviles.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    fun getResult(width: String, height: String) {
        val widthNumeric = width.toFloat()
        val heightNumeric = height.toFloat()
        perimetroMutableViewModel_rectangulo.value = 2 * widthNumeric + 2 * heightNumeric
        areaMutableViewModel_rectangulo.value = widthNumeric * heightNumeric
    }


    private val perimetroMutableViewModel_rectangulo: MutableLiveData<Float> = MutableLiveData()
    val perimetroLiveData_rectangulo: LiveData<Float> = perimetroMutableViewModel_rectangulo
    private val areaMutableViewModel_rectangulo: MutableLiveData<Float> = MutableLiveData()
    val areaLiveData_rectangulo: LiveData<Float> = areaMutableViewModel_rectangulo
}
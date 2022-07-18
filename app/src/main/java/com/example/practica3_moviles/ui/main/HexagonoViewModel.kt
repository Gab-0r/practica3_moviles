package com.example.practica3_moviles.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HexagonoViewModel: ViewModel() {
    fun getResult(apothem: String, length: String) {
        val apothemNumeric = apothem.toFloat()
        val lengthNumeric = length.toFloat()
        val perimeter = lengthNumeric * 6
        perimetroMutableViewModel_hexagono.value = perimeter
        areaMutableViewModel_hexagono.value = perimeter * apothemNumeric / 2
    }


    private val perimetroMutableViewModel_hexagono: MutableLiveData<Float> = MutableLiveData()
    val perimetroLiveData_hexagono: LiveData<Float> = perimetroMutableViewModel_hexagono
    private val areaMutableViewModel_hexagono: MutableLiveData<Float> = MutableLiveData()
    val areaLiveData_hexagono: LiveData<Float> = areaMutableViewModel_hexagono
}
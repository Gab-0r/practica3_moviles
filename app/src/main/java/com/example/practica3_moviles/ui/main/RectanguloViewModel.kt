package com.example.practica3_moviles.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RectanguloViewModel: ViewModel() {
    fun getResult(width: String, height: String) {
        if(width.isEmpty()){
            isEmptyWidthMutableViewModel_rectangulo.value = true
        }
        else if(height.isEmpty()){
            isEmptyHeightMutableViewModel_rectangulo.value = true
        }
        else{
            val widthNumeric = width.toFloat()
            val heightNumeric = height.toFloat()
            val perimeter = heightNumeric * 6
            perimetroMutableViewModel_rectangulo.value = perimeter
            areaMutableViewModel_rectangulo.value = perimeter * widthNumeric / 2
        }
    }


    private val perimetroMutableViewModel_rectangulo: MutableLiveData<Float> = MutableLiveData()
    val perimetroLiveData_rectangulo: LiveData<Float> = perimetroMutableViewModel_rectangulo
    private val areaMutableViewModel_rectangulo: MutableLiveData<Float> = MutableLiveData()
    val areaLiveData_rectangulo: LiveData<Float> = areaMutableViewModel_rectangulo
    private val isEmptyWidthMutableViewModel_rectangulo: MutableLiveData<Boolean> = MutableLiveData()
    val isEmptyWidthLiveData_rectangulo: LiveData<Boolean> = isEmptyWidthMutableViewModel_rectangulo
    private val isEmptyHeightMutableViewModel_rectangulo: MutableLiveData<Boolean> = MutableLiveData()
    val isEmptyHeightLiveData_rectangulo: LiveData<Boolean> = isEmptyHeightMutableViewModel_rectangulo
}
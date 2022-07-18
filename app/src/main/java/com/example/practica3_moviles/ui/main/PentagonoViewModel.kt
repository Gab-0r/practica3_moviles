package com.example.practica3_moviles.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PentagonoViewModel: ViewModel() {
    fun getResult(apothem: String, length: String) {
        if(apothem.isEmpty()){
            isEmptyApothemMutableViewModel_pentagono.value = true
        }
        else if(length.isEmpty()){
            isEmptyLengthMutableViewModel_pentagono.value = true
        }
        else{
            val apothemNumeric = apothem.toFloat()
            val lengthNumeric = length.toFloat()
            val perimeter = lengthNumeric * 5
            perimetroMutableViewModel_pentagono.value = perimeter
            areaMutableViewModel_pentagono.value = perimeter * apothemNumeric / 2
        }
    }


    private val perimetroMutableViewModel_pentagono: MutableLiveData<Float> = MutableLiveData()
    val perimetroLiveData_pentagono: LiveData<Float> = perimetroMutableViewModel_pentagono
    private val areaMutableViewModel_pentagono: MutableLiveData<Float> = MutableLiveData()
    val areaLiveData_pentagono: LiveData<Float> = areaMutableViewModel_pentagono
    private val isEmptyApothemMutableViewModel_pentagono: MutableLiveData<Boolean> = MutableLiveData()
    val isEmptyApothemLiveData_pentagono: LiveData<Boolean> = isEmptyApothemMutableViewModel_pentagono
    private val isEmptyLengthMutableViewModel_pentagono: MutableLiveData<Boolean> = MutableLiveData()
    val isEmptyLengthLiveData_pentagono: LiveData<Boolean> = isEmptyLengthMutableViewModel_pentagono
}
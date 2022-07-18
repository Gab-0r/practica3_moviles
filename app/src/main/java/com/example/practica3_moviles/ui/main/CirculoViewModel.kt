package com.example.practica3_moviles.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat
import kotlin.math.PI

class CirculoViewModel: ViewModel() {
    val dec= DecimalFormat("###,###,###,###,###,###,###.##")
    private val _operation : MutableLiveData<String> = MutableLiveData()
    val operation : LiveData<String> = _operation


    private val _fieldError : MutableLiveData<String> = MutableLiveData()
    val fieldError : LiveData<String> = _fieldError

    fun logic_c(to: String,botton: String, medida:String) {
        if (to.isEmpty()){
            _fieldError.value = "Please fill in all fields"
            return
        }


        val convertResult = operation_c(to,botton,medida)
        _operation.value = convertResult
    }
    private fun operation_c(to: String,botton:String, medida: String): String {
        var result = dec.format(0.00)
        var med=""
        if(botton=="Area"){
            if(medida=="mm"){med="mm^2"}
            if(medida=="cm"){med="cm^2"}
            if(medida=="m"){med="m^2"}
            result=dec.format(PI*to.toDouble()*to.toDouble())
        }
        if(botton=="Perimetro"){
            if(medida=="mm"){med="mm"}
            if(medida=="cm"){med="cm"}
            if(medida=="m"){med="m"}
            result=dec.format(2*PI*to.toDouble())
        }


        result=result.toString()+" "+med
        return result
    }
}
package com.example.practica3_moviles.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.practica3_moviles.R
import com.example.practica3_moviles.databinding.ActivityMainBinding
import com.example.practica3_moviles.databinding.ActivityMainCirculoBinding

class MainActivity_circulo : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainCirculoBinding
    private lateinit var mainViewModel: CirculoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainCirculoBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[CirculoViewModel::class.java]
        mainViewModel.operation.observe(this) { curr ->
            mainBinding.textOperationField.text = curr
        }
        mainViewModel.fieldError.observe(this) { err ->
            val toast = Toast.makeText(this, err, Toast.LENGTH_SHORT)
            toast.show()
            mainBinding.textOperationField.text=null

        }
        with(mainBinding){
            buttonArea.setOnClickListener {
                val bott="Area"
                val amount = inputCirculoEdit.text.toString()
                val m = mainBinding.spinner.selectedItem.toString()
                mainViewModel.logic_c(amount,bott,m)
            }
            buttonPerimetro.setOnClickListener {
                val bott="Perimetro"
                val amount = inputCirculoEdit.text.toString()
                val m = mainBinding.spinner.selectedItem.toString()
                mainViewModel.logic_c(amount,bott,m)
            }
        }
    }
}
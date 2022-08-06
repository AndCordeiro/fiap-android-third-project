package com.example.fuelcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate.setOnClickListener {
            priceCalculator()
        }
    }


    // Função para calculo de preço
    @SuppressLint("SetTextI18n")
    private fun priceCalculator() {
        val alcoholPrice = etAlcohol.text.toString()
        val gasolinePrice = etGasoline.text.toString()

        val fieldValidated = validateFields(alcoholPrice, gasolinePrice)

        if (fieldValidated) {
            calculateBetterPrice(alcoholPrice, gasolinePrice)
        } else {
            tvResult.text = "Preencha os preços primeiro!!!"
        }
    }

    // Função para validar os campos
    private fun validateFields(alcoholPrice: String, gasolinePrice: String): Boolean {

        // Valida o campo alcool
        if(alcoholPrice == ""){
            return false
        }

        // Valida o campo gasolina
        if (gasolinePrice == ""){
            return false
        }

        return true
    }

    // Função para calcular o melhor preço
    @SuppressLint("SetTextI18n")
    private fun calculateBetterPrice(alcoholPrice: String, gasolinePrice: String) {
        val alcoholValue = alcoholPrice.toDouble()
        val gasolineValue = gasolinePrice.toDouble()

        val result = alcoholValue / gasolineValue

        if (result >= 0.7) {
            tvResult.text = "Melhor utilizar gasolina!!!"
        } else {
            tvResult.text = "Melhor utilizar alcool!!!"
        }
    }
}
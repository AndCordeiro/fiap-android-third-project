package com.example.fuelcalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnConvert.setOnClickListener {
            converter()
        }
    }


    // Função para converter metros em centimetros
    @SuppressLint("SetTextI18n")
    private fun converter() {
        val name = etName.text.toString()
        val meters = etMeters.text.toString()

        val fieldValidated = validateFields(name, meters)

        if (fieldValidated) {
            convertMetersToCM(name, meters)
        } else {
            tvResult.text = "Preencha os campos primeiro!!!"
        }
    }

    // Função para validar os campos
    private fun validateFields(name: String, meters: String): Boolean {

        // Valida o campo nome
        if (name == "") {
            return false
        }

        // Valida o campo metros
        if (meters == "") {
            return false
        }

        return true
    }

    // Função para conveter metros para centimetros
    @SuppressLint("SetTextI18n")
    private fun convertMetersToCM(name: String, meters: String) {
        val metersValue = meters.toDouble()

        val result = metersValue * 100

        tvResult.text = "$name sua conversão é: $result cm"
    }
}
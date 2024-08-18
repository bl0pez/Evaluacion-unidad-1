package com.evaluacion1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class EmpleadoRegularScreen : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_employee_calculation_screen2)

        val btnBack = findViewById<Button>(R.id.btnBack)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val inputFiled = findViewById<EditText>(R.id.inputField)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        btnSubmit.setOnClickListener {
            val inputText = inputFiled.text.toString()
            val salario = inputText.toDouble()
            val calcular = EmpleadoRegular(salario).calcularLiquido()
            textViewResult.text = "Resultado: $calcular"
        }


        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        }
    }
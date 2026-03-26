package com.example.prueba01_luis_gomez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivityGLLF : AppCompatActivity() {

    private lateinit var txtNombresGLLF: EditText
    private lateinit var txtApellidosGLLF: EditText
    private lateinit var txtPrimerNumeroGLLF: EditText
    private lateinit var txtSegundoNumeroGLLF: EditText
    private lateinit var txtMultiplicacionGLLF: EditText
    private lateinit var txtPotenciaGLLF: EditText
    private lateinit var txtFactorialGLLF: EditText
    private lateinit var btnSiguienteGLLF: Button
    private lateinit var btnMostrarResultadoGLLF: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_gllf)

        txtNombresGLLF = findViewById(R.id.txtNombres)
        txtApellidosGLLF = findViewById(R.id.txtApellidos)
        txtPrimerNumeroGLLF = findViewById(R.id.txtPrimerNumero)
        txtSegundoNumeroGLLF = findViewById(R.id.txtSegundoNumero)
        txtMultiplicacionGLLF = findViewById(R.id.txtMultiplicacion)
        txtPotenciaGLLF = findViewById(R.id.txtPotencia)
        txtFactorialGLLF = findViewById(R.id.txtFactorial)
        btnSiguienteGLLF = findViewById(R.id.btnSiguiente)
        btnMostrarResultadoGLLF = findViewById(R.id.btnMostrarResultado)

        btnSiguienteGLLF.isEnabled = true
        btnMostrarResultadoGLLF.isEnabled = false
        txtNombresGLLF.isEnabled = false
        txtApellidosGLLF.isEnabled = false
        txtPrimerNumeroGLLF.isEnabled = false
        txtSegundoNumeroGLLF.isEnabled = false
        txtMultiplicacionGLLF.isEnabled = false
        txtPotenciaGLLF.isEnabled = false
        txtFactorialGLLF.isEnabled = false

        btnSiguienteGLLF.setOnClickListener {
            val intentGLLF = Intent(this, Page2ActivityGLLF::class.java)
            startActivityForResult(intentGLLF, 100)
        }

        btnMostrarResultadoGLLF.setOnClickListener {
            val num1 = txtPrimerNumeroGLLF.text.toString().toIntOrNull() ?: 0
            val num2 = txtSegundoNumeroGLLF.text.toString().toIntOrNull() ?: 0
            
            // Lógica para Potencia y Factorial
            val potencia = Math.pow(num1.toDouble(), num2.toDouble()).toInt()
            val factorial = calcularFactorialGLLF(num1)

            txtPotenciaGLLF.setText("$potencia")
            txtFactorialGLLF.setText("$factorial")
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            txtNombresGLLF.setText(data.getStringExtra("nombresGLLF") ?: "")
            txtApellidosGLLF.setText(data.getStringExtra("apellidosGLLF") ?: "")
            txtPrimerNumeroGLLF.setText(data.getStringExtra("dividendoGLLF") ?: "")
            txtSegundoNumeroGLLF.setText(data.getStringExtra("divisorGLLF") ?: "")
            txtMultiplicacionGLLF.setText(data.getStringExtra("numeroGLLF") ?: "")
            btnMostrarResultadoGLLF.isEnabled = true
        }
    }

    private fun calcularFactorialGLLF(n: Int): Long {
        var resultado: Long = 1
        for (i in 1..n) {
            resultado *= i
        }
        return resultado
    }
}
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

    private var datosRecibidosGLLF: String = ""

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
            if (datosRecibidosGLLF.isNotEmpty()) {
                val partesGLLF = datosRecibidosGLLF.split(";")
                if (partesGLLF.size >= 4) {
                    val nom = partesGLLF[0]
                    val ape = partesGLLF[1]
                    val n1Str = partesGLLF[2]
                    val n2Str = partesGLLF[3]

                    txtNombresGLLF.setText(nom)
                    txtApellidosGLLF.setText(ape)
                    txtPrimerNumeroGLLF.setText(n1Str)
                    txtSegundoNumeroGLLF.setText(n2Str)

                    val num1 = n1Str.toIntOrNull() ?: 0
                    val num2 = n2Str.toIntOrNull() ?: 0

                    val multiplicacion = multiplicacionGLLF(num1, num2)
                    val potencia = potenciaGLLF(num1, num2)
                    val factorial = factorialGLLF(num1)

                    txtMultiplicacionGLLF.setText("$multiplicacion")
                    txtPotenciaGLLF.setText("$potencia")
                    txtFactorialGLLF.setText("$factorial")
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            datosRecibidosGLLF = data.getStringExtra("datosGLLF") ?: ""
            
            txtNombresGLLF.setText("")
            txtApellidosGLLF.setText("")
            txtPrimerNumeroGLLF.setText("")
            txtSegundoNumeroGLLF.setText("")
            txtMultiplicacionGLLF.setText("")
            txtPotenciaGLLF.setText("")
            txtFactorialGLLF.setText("")
            
            btnMostrarResultadoGLLF.isEnabled = true
        }
    }

    private fun multiplicacionGLLF(a: Int, b: Int): Int {
        var resultado = 0
        for (i in 1..b) {
            resultado += a
        }
        return resultado
    }

    private fun potenciaGLLF(a: Int, b: Int): Int {
        if (b == 0) return 1
        var resultado = 1
        for (i in 1..b) {
            resultado = multiplicacionGLLF(resultado, a)
        }
        return resultado
    }

    private fun factorialGLLF(n: Int): Long {
        if (n < 0) return 0
        if (n == 0) return 1
        var resultado: Long = 1
        for (i in 1..n) {
            var temp: Long = 0
            for (j in 1..i) {
                temp += resultado
            }
            resultado = temp
        }
        return resultado
    }
}
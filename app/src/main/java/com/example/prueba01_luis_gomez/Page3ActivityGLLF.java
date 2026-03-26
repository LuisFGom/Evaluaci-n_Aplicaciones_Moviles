package com.example.prueba01_luis_gomez;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Page3ActivityGLLF extends AppCompatActivity {

    private EditText txtNombres;
    private EditText txtApellidos;
    private EditText txtDividendo;
    private EditText txtDivisor;
    private EditText txtNumero;
    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3_gllf);

        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtDividendo = findViewById(R.id.txtDividendo);
        txtDivisor = findViewById(R.id.txtDivisor);
        txtNumero = findViewById(R.id.txtNumero);
        btnCerrar = findViewById(R.id.btnCerrar);

        btnCerrar.setOnClickListener(v -> {
            Intent resultIntent = new Intent();
            resultIntent.putExtra("nombresGLLF", txtNombres.getText().toString());
            resultIntent.putExtra("apellidosGLLF", txtApellidos.getText().toString());
            resultIntent.putExtra("dividendoGLLF", txtDividendo.getText().toString());
            resultIntent.putExtra("divisorGLLF", txtDivisor.getText().toString());
            resultIntent.putExtra("numeroGLLF", txtNumero.getText().toString());
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}

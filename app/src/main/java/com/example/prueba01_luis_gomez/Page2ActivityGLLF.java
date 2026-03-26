package com.example.prueba01_luis_gomez;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Page2ActivityGLLF extends AppCompatActivity {

    private EditText txtNombresGLLF;
    private EditText txtApellidosGLLF;
    private EditText txtDividendoGLLF;
    private EditText txtDivisorGLLF;
    private EditText txtNumeroGLLF;
    private Button btnSiguienteGLLF;
    private Button btnMostrarResultadoGLLF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_gllf);

        txtNombresGLLF = findViewById(R.id.txtNombres);
        txtApellidosGLLF = findViewById(R.id.txtApellidos);
        txtDividendoGLLF = findViewById(R.id.txtDividendo);
        txtDivisorGLLF = findViewById(R.id.txtDivisor);
        txtNumeroGLLF = findViewById(R.id.txtNumero);
        btnSiguienteGLLF = findViewById(R.id.btnSiguiente);
        btnMostrarResultadoGLLF = findViewById(R.id.btnMostrarResultado);

        btnSiguienteGLLF.setOnClickListener(v -> {
            Intent intent = new Intent(this, Page3ActivityGLLF.class);
            startActivityForResult(intent, 200);
        });

        btnMostrarResultadoGLLF.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("nombresGLLF", txtNombresGLLF.getText().toString());
            intent.putExtra("apellidosGLLF", txtApellidosGLLF.getText().toString());
            intent.putExtra("dividendoGLLF", txtDividendoGLLF.getText().toString());
            intent.putExtra("divisorGLLF", txtDivisorGLLF.getText().toString());
            intent.putExtra("numeroGLLF", txtNumeroGLLF.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == RESULT_OK && data != null) {
            txtNombresGLLF.setText(data.getStringExtra("nombresGLLF"));
            txtApellidosGLLF.setText(data.getStringExtra("apellidosGLLF"));
            txtDividendoGLLF.setText(data.getStringExtra("dividendoGLLF"));
            txtDivisorGLLF.setText(data.getStringExtra("divisorGLLF"));
            txtNumeroGLLF.setText(data.getStringExtra("numeroGLLF"));
        }
    }
}

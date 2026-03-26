package com.example.prueba01_luis_gomez;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Page3ActivityGLLF extends AppCompatActivity {

    private EditText txtNombres;
    private EditText txtApellidos;
    private EditText txtPrimerNumero;
    private EditText txtSegundoNumero;
    private Button btnCerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3_gllf);

        txtNombres = findViewById(R.id.txtNombres);
        txtApellidos = findViewById(R.id.txtApellidos);
        txtPrimerNumero = findViewById(R.id.txtPrimerNumero);
        txtSegundoNumero = findViewById(R.id.txtSegundoNumero);
        btnCerrar = findViewById(R.id.btnCerrar);

        txtNombres.setEnabled(false);
        txtApellidos.setEnabled(false);

        btnCerrar.setOnClickListener(v -> {
            String n1Str = txtPrimerNumero.getText().toString();
            String n2Str = txtSegundoNumero.getText().toString();
            String nom = txtNombres.getText().toString();
            String ape = txtApellidos.getText().toString();

            if (n1Str.isEmpty() || n2Str.isEmpty()) {
                Toast.makeText(this, "Campos de numeros vacios", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                int n1 = Integer.parseInt(n1Str);
                int n2 = Integer.parseInt(n2Str);

                if (n1 <= 0 || n2 <= 0) {
                    Toast.makeText(this, "Numeros deben ser mayores a 0", Toast.LENGTH_SHORT).show();
                    return;
                }

                String datosGLLF = nom + ";" + ape + ";" + n1Str + ";" + n2Str;
                Intent resultIntent = new Intent();
                resultIntent.putExtra("datosGLLF", datosGLLF);
                setResult(RESULT_OK, resultIntent);
                finish();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Numero invalido", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

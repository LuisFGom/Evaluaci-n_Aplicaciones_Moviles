package com.example.prueba01_luis_gomez;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Page2ActivityGLLF extends AppCompatActivity {

    private EditText txtNombresGLLF;
    private EditText txtApellidosGLLF;
    private EditText txtPrimerNumeroGLLF;
    private EditText txtSegundoNumeroGLLF;
    private Button btnSiguienteGLLF;
    private Button btnCerrarGLLF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_gllf);

        txtNombresGLLF = findViewById(R.id.txtNombres);
        txtApellidosGLLF = findViewById(R.id.txtApellidos);
        txtPrimerNumeroGLLF = findViewById(R.id.txtPrimerNumero);
        txtSegundoNumeroGLLF = findViewById(R.id.txtSegundoNumero);
        btnSiguienteGLLF = findViewById(R.id.btnSiguiente);
        btnCerrarGLLF = findViewById(R.id.btnCerrar);

        txtNombresGLLF.setEnabled(false);
        txtApellidosGLLF.setEnabled(false);
        txtPrimerNumeroGLLF.setEnabled(false);
        txtSegundoNumeroGLLF.setEnabled(false);
        btnCerrarGLLF.setEnabled(false);

        btnSiguienteGLLF.setOnClickListener(v -> {
            Intent intent = new Intent(this, Page3ActivityGLLF.class);
            startActivityForResult(intent, 200);
        });

        btnCerrarGLLF.setOnClickListener(v -> {
            String nom = txtNombresGLLF.getText().toString();
            String ape = txtApellidosGLLF.getText().toString();
            String n1 = txtPrimerNumeroGLLF.getText().toString();
            String n2 = txtSegundoNumeroGLLF.getText().toString();

            if (nom.isEmpty() || ape.isEmpty()) {
                Toast.makeText(this, "Nombres y apellidos no deben estar vacios", Toast.LENGTH_SHORT).show();
                return;
            }

            String datosGLLF = nom + ";" + ape + ";" + n1 + ";" + n2;
            Intent intent = new Intent();
            intent.putExtra("datosGLLF", datosGLLF);
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && resultCode == RESULT_OK && data != null) {
            String recibidosGLLF = data.getStringExtra("datosGLLF");
            if (recibidosGLLF != null) {
                String[] partesGLLF = recibidosGLLF.split(";");
                if (partesGLLF.length >= 4) {
                    txtNombresGLLF.setText(partesGLLF[0]);
                    txtApellidosGLLF.setText(partesGLLF[1]);
                    txtPrimerNumeroGLLF.setText(partesGLLF[2]);
                    txtSegundoNumeroGLLF.setText(partesGLLF[3]);
                    
                    txtNombresGLLF.setEnabled(true);
                    txtApellidosGLLF.setEnabled(true);
                    btnCerrarGLLF.setEnabled(true);
                }
            }
        }
    }
}

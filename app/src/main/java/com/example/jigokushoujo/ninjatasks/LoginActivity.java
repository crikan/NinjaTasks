package com.example.jigokushoujo.ninjatasks;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // ocultar la ActionBar
        getSupportActionBar().hide();
    }

    // método para la etiqueta "Not a Shinobi Yet?"
    public void crearCuenta(View view) {
        Toast toast = Toast.makeText(this, "Funcionalidad no implementada", Toast.LENGTH_LONG);
        toast.show();
    }
    // método para el botón de "Login Attack"
    public void login(View view) {
        TextInputEditText usuario = (TextInputEditText) findViewById(R.id.cajaUser);
        TextInputEditText pass = (TextInputEditText) findViewById(R.id.cajaPass);

        if (usuario.getText().toString().equalsIgnoreCase("naruto") && pass.getText().toString().equalsIgnoreCase("123")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(this, "You are not a shinobi", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}

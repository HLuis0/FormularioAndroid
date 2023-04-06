package com.example.formulariocontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EditarDatos extends AppCompatActivity {

    private TextView verNombre, verFecha, verTel, verEmail, verDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_datos);

        verNombre = (TextView) findViewById(R.id.verNombre);
        verFecha = (TextView) findViewById(R.id.verFecha);
        verTel = (TextView) findViewById(R.id.verTel);
        verEmail = (TextView) findViewById(R.id.verEmail);
        verDesc = (TextView) findViewById(R.id.verDesc);

        String nombre = getIntent().getStringExtra("nombre");
        verNombre.setText("Nombre: " + nombre);
        String fecha = getIntent().getStringExtra("fecha");
        verFecha.setText("Fecha de Nacimiento: " + fecha);
        String telefono = getIntent().getStringExtra("telefono");
        verTel.setText("Telefono: " + telefono);
        String email = getIntent().getStringExtra("email");
        verEmail.setText("Email: " + email);
        String descripcion = getIntent().getStringExtra("descripcion");
        verDesc.setText("Descripcion: " + descripcion);
    }
    public void Editar(View view){
        Intent miIntent = new Intent(this,MainActivity.class);
        startActivity(miIntent);
    }
}
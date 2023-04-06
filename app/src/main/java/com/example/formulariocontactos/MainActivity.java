package com.example.formulariocontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private EditText nombre,tel,email,Desc;
    private TextView tvDate;

    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = (EditText)findViewById(R.id.nombre);
        tel = (EditText)findViewById(R.id.tel);
        email = (EditText)findViewById(R.id.email);
        Desc = (EditText)findViewById(R.id.Desc);
        tvDate = findViewById(R.id.tv_date);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tvDate.setText(date);

            }
        };


    }
    public void onClick(View view){
        Intent miIntent = new Intent(MainActivity.this,EditarDatos.class);
        miIntent.putExtra("nombre", nombre.getText().toString());
        miIntent.putExtra("fecha", tvDate.getText().toString());
        miIntent.putExtra("telefono", tel.getText().toString());
        miIntent.putExtra("email", email.getText().toString());
        miIntent.putExtra("descripcion", Desc.getText().toString());
        startActivity(miIntent);
    }

}

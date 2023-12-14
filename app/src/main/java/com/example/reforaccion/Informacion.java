package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Informacion extends AppCompatActivity {

    ImageView consejos,registro,inicio,estadisticas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        consejos=(ImageView) findViewById(R.id.consejos);
        registro=(ImageView) findViewById(R.id.registro);
        inicio=(ImageView) findViewById(R.id.inicio);
        estadisticas=(ImageView) findViewById(R.id.estadisticas);


        consejos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Informacion.this, Consejos.class);
                startActivity(i);
            }
        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Informacion.this, Registro.class);
                startActivity(i);
            }
        });

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Informacion.this, Inicio.class);
                startActivity(i);
            }
        });

        estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Informacion.this, Estadisticas.class);
                startActivity(i);
            }
        });




    }
}
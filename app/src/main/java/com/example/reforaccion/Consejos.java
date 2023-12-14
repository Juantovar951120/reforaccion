package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Consejos extends AppCompatActivity {

    ImageView registro,inicio,estadisticas,informacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);


        registro=(ImageView) findViewById(R.id.registro);
        inicio=(ImageView) findViewById(R.id.inicio);
        estadisticas=(ImageView) findViewById(R.id.estadisticas);
        informacion=(ImageView) findViewById(R.id.informacion);


        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Consejos.this, Registro.class);
                startActivity(i);
            }
        });

        inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Consejos.this, Inicio.class);
                startActivity(i);
            }
        });

        estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Consejos.this, Estadisticas.class);
                startActivity(i);
            }
        });

        informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Consejos.this, Informacion.class);
                startActivity(i);
            }
        });


    }
}

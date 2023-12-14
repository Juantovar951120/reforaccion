package com.example.reforaccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Inicio extends AppCompatActivity {

    ImageView consejos,registro,estadisticas,informacion;
   // private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        consejos=(ImageView) findViewById(R.id.consejos);
        registro=(ImageView) findViewById(R.id.registro);
        estadisticas=(ImageView) findViewById(R.id.estadisticas);
        informacion=(ImageView) findViewById(R.id.informacion);

       consejos.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(Inicio.this, Consejos.class);
               startActivity(i);
           }
       });

       registro.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(Inicio.this, Registro.class);
               startActivity(i);
           }
       });


        estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inicio.this, Estadisticas.class);
                startActivity(i);
            }
        });

        informacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Inicio.this, Informacion.class);
                startActivity(i);
            }
        });
    }

}